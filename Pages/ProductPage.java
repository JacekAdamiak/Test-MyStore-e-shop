package MyStoreTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Klasa opisująca stronę produktu
public class ProductPage {
    private static WebDriver driver;

//    Lista rozwijala "Size"
    @FindBy(id = "group_1")
    WebElement productSize;

//    Pole "Quantity" do wpisania ilości do zamówienia
    @FindBy(id = "quantity_wanted")
    WebElement productQuantity;

//    Przycisk dodania do koszyka "ADD TO CART"
    @FindBy(className = "add-to-cart")
    WebElement addProductToBasket;

//  Przycisk "PROCEED TO CHECKOUT"
//  Pojawia sie jako wyskakujące okienko po dodaniu produktu do koszyka
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    WebElement proceedToCheckout;

//    Cena standardowa wyświetlana jako tekst obok produktu
    @FindBy(className = "regular-price")
    WebElement productPriceRegular;

//    Cena promocyjna wyświetlana jako tekst obok produktu
    @FindBy(xpath = "//*[@class='current-price']/span")
    WebElement productPricePromo;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Wybór rozmiaru produktu, który jest podany jako parametr
    public void setProductSize(String productSize) {
        this.productSize.sendKeys(productSize);
    }

//    Pobranie rozmiaru produktu
    public String getProductSize() {
        return productSize.getAttribute("value");
    }

//    Wprowadzenie ilości produktu do zamówienia podane jako parametr
    public void setProductQuantity(int productQuantity) {
        this.productQuantity.clear();
        this.productQuantity.sendKeys(String.valueOf(productQuantity));
    }

//    Kliknięcie przycisku "ADD TO CART" dodania do koszyka
    public void addProductToBasket() {
        addProductToBasket.click();
    }

//    Kliknięci eprzycisku "PROCEED TO CHECKOUT" przejście do procedowania zamówienia
    public void proceedToCheckout() {
        proceedToCheckout.click();
    }

//  Pobranie jako tekst ceny standardowej produktu
    public String getProductPriceRegular() {
        return productPriceRegular.getText();
    }

//  Pobranie jako tekst ceny promocyjnej produktu
    public String getProductPricePromo() {
        return productPricePromo.getText();
    }

//    Sprawdzenie czy przycisk "ADD TO CART" jest aktywny jest to potwierdzenie możliwości zamówienia
    public boolean isProductAvailable() {
        return addProductToBasket.isEnabled();
    }




}
