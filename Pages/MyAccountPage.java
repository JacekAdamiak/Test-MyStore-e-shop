package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę użytkownika "Your Account"
public class MyAccountPage {
    private static WebDriver driver;

//    Kafelek "INFORMATION"
    @FindBy(id = "identity-link")
    WebElement informationButton;

//    Kafelek "ADDRRESS"
    @FindBy(id = "addresses-link")
    WebElement addressesButton;

//    Kafelek "ORDER HISTORY AND DETAILS"
    @FindBy(id = "history-link")
    WebElement historyButton;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Kliknięcie w kafelek i przejście do strony "INFORMATION"
    public void goToInformationPageWar2() {
        informationButton.click();
    }

//    Kliknięcie w kafelek i przejście do strony "ADDRRESS"
    public void goToAddressPageWar2() {
        addressesButton.click();
    }

//    Kliknięcie w kafelek i przejście do strony "ORDER HISTORY AND DETAILS"
    public void goToOrderHistoryPage() {
        historyButton.click();
    }


}
