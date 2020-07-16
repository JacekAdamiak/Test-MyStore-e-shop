package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//  Klasa opisująca stronę z historią zamówień "ORDER HISTORY AND DETAILS"
public class HistoryOrdersPage {
    private static WebDriver driver;

//  Lista numerów zamówień
    @FindBy(xpath = "//*[@scope='row']")
    List<WebElement> ordersListNumbers;

    public HistoryOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//  Metoda zwraca numer ostatniego zamówienia z listy zamówień
    public String getLastOrderNumber() {
        return ordersListNumbers.get(0).getText();
    }

}
