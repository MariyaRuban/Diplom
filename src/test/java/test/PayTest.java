package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayTest {
    StartPage startPage;
    PaymentPage paymentPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        startPage = new StartPage();
        paymentPage = startPage.PayTour();
    }


    @Test
    public void PayApprovedCard() {
        var cardInfo = DataHelper.getApprovedCard();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.successfulPayment();
        assertEquals("APPROVED", SqlHelper.getStatusPay());
    }

    @Test
    public void PayDeclinedCard() {
        var cardInfo = DataHelper.getDeclinedCard();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.refusedTransaction();
        assertEquals("DECLINED", SqlHelper.getStatusPay());
    }


    @Test
    public void getCardNumber17() {
        var cardInfo = DataHelper.getCardNumber17();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCardNumber15() {
        var cardInfo = DataHelper.getCardNumber15();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCardNumberSpecial() {
        var cardInfo = DataHelper.getCardNumberSpecial();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCardNumberAlphabetRu() {
        var cardInfo = DataHelper.getCardNumberAlphabetRu();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCardNumberAlphabetEn() {
        var cardInfo = DataHelper.getCardNumberAlphabetEn();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCardNumberSpace() {
        var cardInfo = DataHelper.getCardNumberSpace();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }


    @Test
    public void getMonthSpace() {
        var cardInfo = DataHelper.getMonthSpace();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getMonth00() {
        var cardInfo = DataHelper.getMonth00();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.InvalidExpirationCard();
    }

    @Test
    public void getMonth13() {
        var cardInfo = DataHelper.getMonth13();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.InvalidExpirationCard();
    }

    @Test
    public void getMonthAlphabet() {
        var cardInfo = DataHelper.getMonthAlphabet();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getMonth1() {
        var cardInfo = DataHelper.getMonth1();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }


    @Test
    public void getYearSpace() {
        var cardInfo = DataHelper.getYearSpace();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getYear4() {
        var cardInfo = DataHelper.getYear4();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getYearLast() {
        var cardInfo = DataHelper.getYearLast();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.verifyCardExpired();
    }

    @Test
    public void getYearBig() {
        var cardInfo = DataHelper.getYearBig();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.InvalidExpirationCard();
    }

    @Test
    public void getYearSpecial() {
        var cardInfo = DataHelper.getYearSpecial();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }


    @Test
    public void getHolderRu() {
        var cardInfo = DataHelper.getHolderRu();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getHolderSpecial() {
        var cardInfo = DataHelper.getHolderSpecial();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getHolder123() {
        var cardInfo = DataHelper.getHolder123();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getHolderSpace() {
        var cardInfo = DataHelper.getHolderSpace();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.verifyRequiredField();
    }

    @Test
    public void getHolder1Alphabet() {
        var cardInfo = DataHelper.getHolder1Alphabet();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }


    @Test
    public void getCvcSpace() {
        var cardInfo = DataHelper.getCvcSpace();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCvc2() {
        var cardInfo = DataHelper.getCvc2();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCvcSpecial() {
        var cardInfo = DataHelper.getCvcSpecial();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCvcAlphabetEn() {
        var cardInfo = DataHelper.getCvcAlphabetEn();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }

    @Test
    public void getCvcAlphabetRu() {
        var cardInfo = DataHelper.getCvcAlphabetRu();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
    }


    @Test
    public void getSpaceCardInfo() {
        var cardInfo = DataHelper.getSpaceCardInfo();
        var paymentPage = startPage.PayTour();
        paymentPage.allFieldsFilled(cardInfo);
        paymentPage.invalidFormat();
        paymentPage.verifyRequiredField();
    }
}
