package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//  Klasa opisująca nagłówek strony
public class Header {
    private static WebDriver driver;

//  Link imię i nazwisko zalogowanego użytkownika
    @FindBy(xpath = "//a[@class='account']")
    WebElement userName;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Metoda pobiera wyświetlany napis imię i nazwisko użytkownika zalogowanego
    public String getLogged() {
        return userName.getText();
    }

//  Kliknięcie na link imię i nazwisko użytkownika i
//  przejście do strony "Your Account"
    public void goToUserInformationView() {
        userName.click();
    }

}
