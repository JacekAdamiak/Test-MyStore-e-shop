package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę wyświetlającą potwierdzenie zamówienia
public class OrderConfirmationPage {
    private static WebDriver driver;

//    Numer zamówienia jako tekst wyświetlany na stronie
    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li")
    WebElement orderReferenceNumber;


    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Pobranie tekstu z numerem zamówienia i odcięcie prefixu "Order reference: " 17 znaków
    public String getOrderReferenceNumber() {
        return orderReferenceNumber.getText().substring(17);
    }

}
