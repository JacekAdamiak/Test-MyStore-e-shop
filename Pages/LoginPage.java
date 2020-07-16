package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę logowania
public class LoginPage {
    private static WebDriver driver;

//    Pole do wpisania adresu e-mail
    @FindBy(name = "email")
    WebElement loginInput;

//    Pole do wpisania hasła
    @FindBy(name = "password")
    WebElement passwardInput;

//    Przycisk do logowania "SIGN IN"
    @FindBy(id = "submit-login")
    WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Wprowadzenie danych logowania i zatwierdzenie przyciskiem "SIGN IN"
    public void loginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwardInput.click();
        passwardInput.clear();
        passwardInput.sendKeys(password);

        signInButton.click();
    }
}
