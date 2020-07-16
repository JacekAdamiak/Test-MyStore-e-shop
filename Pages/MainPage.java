package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//  Klasa opisująca stronę główną
public class MainPage {
    private static WebDriver driver;

//    Lista produktów na stronie głównej
    @FindBy(className = "product-thumbnail")
    List<WebElement> productList;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Zwraca liczbę produktów na stronie
    public int numberOfProductsWar2() {
        return productList.size();
    }

//    Klika w wybrany produkt - wskazanie wg numeru pozycji na liście
    public void chooseProductNumber(int productNumber) {
        productList.get(productNumber).click();
    }


}
