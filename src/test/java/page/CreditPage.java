package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {

    private final SelenideElement headerCredit = $(byText("Кредит по данным карты"));
    private final SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $("[placeholder='08']");
    private final SelenideElement year = $("[placeholder='22']");
    private final SelenideElement holder = $(byText("Владелец")).parent().$(".input__control");
    private final SelenideElement cvc = $("[placeholder='999']");
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement successMessage = $(".notification_status_ok");

    private final SelenideElement errorMessage = $(".notification_status_error");
    private final SelenideElement wrongFormat = $(byText("Неверный формат"));
    private final SelenideElement cardExpirationIncorrect = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpired = $(byText("Истёк срок действия карты"));
    private final SelenideElement requiredField = $(byText("Поле обязательно для заполнения"));

    public CreditPage() {

        headerCredit.shouldBe(Condition.visible);
    }

    public void allFieldsFilled(DataHelper.CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        holder.setValue(cardInfo.getHolder());
        cvc.setValue(cardInfo.getCvc());
        continueButton.click();
    }

    public void successfulPayment() {

        successMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void refusalPurchaseOnCredit() {

        errorMessage.shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void invalidFormat() {

        wrongFormat.shouldBe(Condition.visible);
    }

    public void InvalidExpirationCard() {

        cardExpirationIncorrect.shouldBe(Condition.visible);
    }

    public void verifyCardExpired() {

        cardExpired.shouldBe(Condition.visible);
    }

    public void verifyRequiredField() {

        requiredField.shouldBe(Condition.visible);
    }

}
