package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SqlHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CreditPage;
import page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditTest {
    StartPage startPage;
    CreditPage credit;

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
        credit = startPage.CreditTour();
    }


    @Test
    public void CreditApprovedCard() {
        var cardInfo = DataHelper.getApprovedCard();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.successfulPayment();
        assertEquals("APPROVED", SqlHelper.getStatusCredit());
    }

    @Test
    public void CreditDeclinedCard() {
        var cardInfo = DataHelper.getDeclinedCard();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.refusalPurchaseOnCredit();
        assertEquals("DECLINED", SqlHelper.getStatusCredit());
    }


    @Test
    public void getCardNumber17() {
        var cardInfo = DataHelper.getCardNumber17();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCardNumber15() {
        var cardInfo = DataHelper.getCardNumber15();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCardNumberSpecial() {
        var cardInfo = DataHelper.getCardNumberSpecial();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCardNumberAlphabetRu() {
        var cardInfo = DataHelper.getCardNumberAlphabetRu();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCardNumberAlphabetEn() {
        var cardInfo = DataHelper.getCardNumberAlphabetEn();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCardNumberSpace() {
        var cardInfo = DataHelper.getCardNumberSpace();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }


    @Test
    public void getMonthSpace() {
        var cardInfo = DataHelper.getMonthSpace();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getMonth00() {
        var cardInfo = DataHelper.getMonth00();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getMonth13() {
        var cardInfo = DataHelper.getMonth13();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.InvalidExpirationCard();
    }

    @Test
    public void getMonthAlphabet() {
        var cardInfo = DataHelper.getMonthAlphabet();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getMonth1() {
        var cardInfo = DataHelper.getMonth1();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }


    @Test
    public void getYearSpace() {
        var cardInfo = DataHelper.getYearSpace();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getYear4() {
        var cardInfo = DataHelper.getYear4();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getYearLast() {
        var cardInfo = DataHelper.getYearLast();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.verifyCardExpired();
    }

    @Test
    public void getYearBig() {
        var cardInfo = DataHelper.getYearBig();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.InvalidExpirationCard();
    }

    @Test
    public void getYearSpecial() {
        var cardInfo = DataHelper.getYearSpecial();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }


    @Test
    public void getHolderRu() {
        var cardInfo = DataHelper.getHolderRu();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getHolderSpecial() {
        var cardInfo = DataHelper.getHolderSpecial();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getHolder123() {
        var cardInfo = DataHelper.getHolder123();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getHolderSpace() {
        var cardInfo = DataHelper.getHolderSpace();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.verifyRequiredField();
    }

    @Test
    public void getHolder1Alphabet() {
        var cardInfo = DataHelper.getHolder1Alphabet();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }


    @Test
    public void getCvcSpace() {
        var cardInfo = DataHelper.getCvcSpace();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCvc2() {
        var cardInfo = DataHelper.getCvc2();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCvcSpecial() {
        var cardInfo = DataHelper.getCvcSpecial();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCvcAlphabetEn() {
        var cardInfo = DataHelper.getCvcAlphabetEn();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }

    @Test
    public void getCvcAlphabetRu() {
        var cardInfo = DataHelper.getCvcAlphabetRu();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
    }


    @Test
    public void getSpaceCardInfo() {
        var cardInfo = DataHelper.getSpaceCardInfo();
        var creditPage = startPage.CreditTour();
        creditPage.allFieldsFilled(cardInfo);
        creditPage.invalidFormat();
        creditPage.verifyRequiredField();
    }
}
