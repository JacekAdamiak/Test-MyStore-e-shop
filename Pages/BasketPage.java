package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę koszyka
public class BasketPage {
    private static WebDriver driver;

//  Przycisk "PROCEED TO CHECKOUT"
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    WebElement proceedToFinalCheckout;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //  Kliknięcie przycisku "PROCEED TO CHECKOUT" - przejście do realizacji zamówienia
    public void proceedToFinalCheckout() {
        proceedToFinalCheckout.click();
    }





}
