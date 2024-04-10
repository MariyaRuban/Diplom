package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    //Валидные данные
    public static String getApprovedCardNumber() {
        return ("4444 4444 4444 4441");
    }

    public static String getDeclinedCardNumber() {
        return ("4444 4444 4444 4442");
    }

    public static String getMonth() {
//        Random random = new Random();
//        int month = random.nextInt(12);
//        return LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYear() {
//        Random random = new Random();
//        int year = random.nextInt(4) + 1;
//        return LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generatorHolder() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generatorCvc() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }


    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String holder;
        String cvc;
    }


    // Не валидные
    public static CardInfo getApprovedCard() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo(
                getDeclinedCardNumber(), getMonth(), getYear(), generatorHolder(), generatorCvc());
    }


    // card
    public static CardInfo getCardNumber17() {
        return new CardInfo(
                "1234_1234_1234_1234_1", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getCardNumber15() {
        return new CardInfo(
                "1234_1234_1234_123", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getCardNumberSpecial() {
        return new CardInfo(
                "1234_1234_%%34_1234", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getCardNumberAlphabetRu() {
        return new CardInfo(
                "1234_1234_1234_123щ", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getCardNumberAlphabetEn() {
        return new CardInfo(
                "1ffg_1234_1234_1234", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getCardNumberSpace() {
        return new CardInfo(
                " ", getMonth(), getYear(), generatorHolder(), generatorCvc());
    }


// month

    public static CardInfo getMonthSpace() {
        return new CardInfo(
                getApprovedCardNumber(), " ", getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getMonth00() {
        return new CardInfo(
                getApprovedCardNumber(), "00", getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getMonth13() {
        return new CardInfo(
                getApprovedCardNumber(), "13", getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getMonthAlphabet() {
        return new CardInfo(
                getApprovedCardNumber(), "1s", getYear(), generatorHolder(), generatorCvc());
    }

    public static CardInfo getMonth1() {
        return new CardInfo(
                getApprovedCardNumber(), "7", getYear(), generatorHolder(), generatorCvc());
    }


    // year
    public static CardInfo getYearSpace() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), " ", generatorHolder(), generatorCvc());
    }

    public static CardInfo getYear4() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), "4", generatorHolder(), generatorCvc());
    }

    public static CardInfo getYearLast() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), "23", generatorHolder(), generatorCvc());
    }

    public static CardInfo getYearBig() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), "34", generatorHolder(), generatorCvc());
    }

    public static CardInfo getYearSpecial() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), "%4", generatorHolder(), generatorCvc());
    }


    // holder
    public static CardInfo getHolderRu() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), "Мария", generatorCvc());
    }

    public static CardInfo getHolderSpecial() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), "Mariya%% Ruban", generatorCvc());
    }

    public static CardInfo getHolder123() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), "123", generatorCvc());
    }

    public static CardInfo getHolderSpace() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), "", generatorCvc());
    }

    public static CardInfo getHolder1Alphabet() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), "d", generatorCvc());
    }


    // cvc
    public static CardInfo getCvcSpace() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), " ");
    }

    public static CardInfo getCvc2() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), "2");
    }

    public static CardInfo getCvcSpecial() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), "45%");
    }

    public static CardInfo getCvcAlphabetEn() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), "nkf");
    }

    public static CardInfo getCvcAlphabetRu() {
        return new CardInfo(
                getApprovedCardNumber(), getMonth(), getYear(), generatorHolder(), "тлд");
    }


    public static CardInfo getSpaceCardInfo() {
        return new CardInfo(
                " ", " ", " ", " ", " ");
    }

}
