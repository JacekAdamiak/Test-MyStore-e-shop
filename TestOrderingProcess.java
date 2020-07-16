package MyStoreTest;

import MyStoreTest.Pages.*;
import MyStoreTest.ToolBox.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestOrderingProcess {
    private static WebDriver driver;

    LoginPage loginPage;
    Header header;
    MainPage mainPage;
    ProductPage productPage;
    BasketPage basketPage;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;
    MyAccountPage myAccountPage;
    HistoryOrdersPage historyOrdersPage;
    Statements statements;
    ToolBoxMethods toolBoxMethods;

//    Ustawienie wartości zmiennych: rozmiar koszulki - M oraz ilość sztuk do zamówienia - 5
//    Dopuszczalne rozmiary koszulek to S, M, L, XL
    String productSize = "M";
    int productQuantity = 2;

    @Before
    public void setUp(){
        // Uruchomienie przeglądarki Chrome i przejście na stronę logowania do sklepu "My Store"
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        loginPage = new LoginPage(driver);
        header = new Header(driver);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        historyOrdersPage = new HistoryOrdersPage(driver);
        statements = new Statements();
        toolBoxMethods = new ToolBoxMethods();
    }

    @Test
    public void testOrderingAndConfirmationProcess() {
//        Logowanie do sklepu jako użytkownik Janek Bury
        loginPage.loginAs("janek.bury@webowo.pl", "JanekBury");

//        Sprawdzenie czy zalogowano się na właściwe konto
        Assert.assertEquals("Janek Bury", header.getLogged());
        System.out.println("Zalogowany jako: " + header.getLogged());

//        Po zalogowaniu system przenosi użytkownika na stronę główną
//        Kliknięcie na wybrany produkt "Hummingbird Printed Sweater" (produkt nr 2 na liście)
        mainPage.chooseProductNumber(1);

//        Sprawdzenie czy prawidłowo został określony rozmiar koszulki. Można wybrać rozmiary S, M, L, XL
//        Jeżeli użytkownik wybrał inny rozmiar wykonywanie testu zostanie przerwane i wyświetli się
//        komunikat podający przyczynę zatrzymania testu
        if (!(productSize == "S" || productSize == "M" || productSize == "L" || productSize == "XL")) {
            System.out.println(statements.getIncorrectProductSize());
            return;
        }
//        Przejście na stronę produktu
//        Wybór rozmiaru
        productPage.setProductSize(productSize);

//        Wstrzymanie wykonywania programu - oczekiwanie na przeładowanie strony
        toolBoxMethods.giveMeFewSeconds(2);

//        Sprawdzenie czy został naliczony rabat
//        Pobranie cen ze strony w postaci string - odcięcie waluty - pierwszy znak
        String priceRegular = productPage.getProductPriceRegular().substring(1);
        String pricePromo = productPage.getProductPricePromo().substring(1);
//        Metoda getPromoIsGiven() zwraca wartość true - tak został naliczony, false - nie został naliczony
        Assert.assertTrue(toolBoxMethods.getPromoIsGiven(priceRegular, pricePromo));

//        Wprowadzenie ilości sztuk produktu do zakupu
        productPage.setProductQuantity(productQuantity);

//        Wstrzymanie wykonywania programu - oczekiwanie na przeładowanie strony
        toolBoxMethods.giveMeFewSeconds(4);

//        Sprawdzenie czy produkt jest dostępny
//        Możliwe przyczyny: - może nie byc dostępny w ogóle - zapas 0
//        lub stać sie niedostepny w momencie wprowadzenia zbyt dużej ilości do zamówienia
//        Jeżeli produkt jest niedostępny wykonywanie testu zostanie przerwane i wyświetli się
//        komunikat podający przyczynę zatrzymania testu
        if (!(productPage.isProductAvailable())) {
            System.out.println(statements.getProductNotAvailableInfo());
            return;
        }

//        Dodanie produktu do koszyka
        productPage.addProductToBasket();

//        Wstrzymanie wykonywania programu - oczekiwanie na przeładowanie strony
        toolBoxMethods.giveMeFewSeconds(2);

//        Dalsze procedowanie zakupu - przejście do strony koszyka
        productPage.proceedToCheckout();

//        Potwierdzenie zakupów - przejście do strony procedowania zamówienia
        basketPage.proceedToFinalCheckout();

//        Procedowanie zamówienia
        checkoutPage.confirmAddressFinalCheckout();
        checkoutPage.confirmDeliverOptionFinalCheckout();
        checkoutPage.confirmPaymentByCheckFinalCheckout();
        checkoutPage.confirmTermsOfServiceFinalCheckout();

//        Zakończenie procedowania zamówienia i przejście na stronę potwierdzenia zamówienia
        checkoutPage.confirmOrderWithAnObligationToPayFinalCheckout();

//        Pobranie numeru zamówienia ze strony potwierdzenia zamówienia
        String orderReferenceNumber = orderConfirmationPage.getOrderReferenceNumber();
        System.out.println("Zamówienie z potwierdzenia: "+orderReferenceNumber);

//        Wykonanie zrzutu ekranu i zapisaniu w postaci pliku "png" z numerem zamówienia w nazwie
//        Zrzut ekranu wykonuje metoda finalScreenShoot z parametrem, którym jest numer zamówienia
        try {
            finalScreenShoot(orderReferenceNumber);
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");
        }

//        Przejście do strony "User Information"
        header.goToUserInformationView();

//        Przejście do strony "Order History"
        myAccountPage.goToOrderHistoryPage();

//        Wyszukanie i pobranie numeru ostatniego zamówienia na stronie "Order History"
        String lastOrderFromHistoryList = historyOrdersPage.getLastOrderNumber();
        System.out.println("Zamówienie z historii: "+lastOrderFromHistoryList);

//        Sprawdzenie czy numer zamówienia z potwierdzenia oraz z listy zamówień
//        ze strony "Order History" są identyczne
        Assert.assertEquals(orderReferenceNumber, lastOrderFromHistoryList);
    }



//        Metoda wykonująca screenshota, którego zapisuje w pliku "png" na pulpicie
    public void finalScreenShoot(String orderFileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File("/home/jacek/Pulpit/"+orderFileName+".png"));
        System.out.println("Zrobiłem zdjęcie. Nazwa pliku: "+orderFileName+".png");
    }

    //        Zamknięcie przeglądarki
    @After
    public void tearDown() {driver.quit();}

}
