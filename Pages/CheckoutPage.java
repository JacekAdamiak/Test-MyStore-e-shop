package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę procedowania zamówienia
public class CheckoutPage {
    private static WebDriver driver;

//  Przycisk "CONTINUE"
    @FindBy(name = "confirm-addresses")
    WebElement confirmAddressFinalCheckout;

//  Przycisk "CONTINUE" - zaakceptowanie metody dostawy i przejście dalej
    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliverOptionFinalCheckout;

//  Pole wyboru "Pay by Check"
    @FindBy(id = "payment-option-1")
    WebElement confirmPaymentByCheckFinalCheckout;

//  Pole akceptacji regulaminu
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement confirmTermsOfServiceFinalCheckout;

//  Przycisk "ORDER WITH AN OBLIGATION TO PAY"
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    WebElement confirmOrderWithAnObligationToPayFinalCheckout;



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Kliknięcie przycisku "CONTINUE" - zaakceptowanie adresu dostawy i przejście dalej
    public void confirmAddressFinalCheckout() {
        confirmAddressFinalCheckout.click();
    }

//    Kliknięcie przycisku "CONTINUE" - zaakceptowanie metody wysyłki "Pick up in-store i przejście dalej
    public void confirmDeliverOptionFinalCheckout() { confirmDeliverOptionFinalCheckout.click(); }

//    Zaznaczenie pola wyboru "Pay by Check"
    public void confirmPaymentByCheckFinalCheckout() {
        confirmPaymentByCheckFinalCheckout.click();
    }

//    Zaznaczenie pola akceptacji regulaminu
    public void confirmTermsOfServiceFinalCheckout() {
        confirmTermsOfServiceFinalCheckout.click();
    }

//    Kliknięcie przycisku "ORDER WITH AN OBLIGATION TO PAY" i przejście na stronę potwierdzenia zamówienia
    public void confirmOrderWithAnObligationToPayFinalCheckout() {
        confirmOrderWithAnObligationToPayFinalCheckout.click();
    }



}
