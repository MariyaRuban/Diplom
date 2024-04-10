package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private SelenideElement heading = $$("h2").find(Condition.text("Путешествие дня"));
    private SelenideElement payButton = $$("button span.button__text").find(exactText("Купить"));
    private SelenideElement creditButton = $$("button span.button__text").find(exactText("Купить в кредит"));

    public StartPage() {

        heading.shouldBe(visible);
    }

    public PaymentPage PayTour() {
        payButton.click();
        return new PaymentPage();
    }

    public CreditPage CreditTour() {
        creditButton.click();
        return new CreditPage();
    }
}