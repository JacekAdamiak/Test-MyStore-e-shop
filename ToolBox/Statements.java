package MyStoreTest.ToolBox;


public class Statements {

//        Komunikat zwracany użytkownikowi w momencie przerwania działania programu z powodu
//        braku dostępności produktu do zamówienia

    public String getProductNotAvailableInfo () {
        String productNotAvailableInfo = "Test został przerwany z powodu:"+
                "\nTen rozmiar produktu nie jest aktualnie dostępny w sklepie lub"+
                "\nilość jaką chciałeś zamówić jest większa niż ilość dostępna do zamówienia."+
                "\nWybierz inny rozmiar lub zmniejsz ilość do zamówienia."+
                "\nDostępne rozmiary to S, M, L, XL";
        return productNotAvailableInfo;

    }

//        Komunikat zwracany użytkownikowi w momencie przerwania działania programu z powodu
//        niewłaściwego wyboru rozmiaru produktu
    public String getIncorrectProductSize () {
        String incorrectProductSize = "Test został przerwany z powodu:"+
                "\nWybrano niewłaściwy rozmiar produktu. Dostępne rozmiary to S, M, L, XL";
        return incorrectProductSize;

    }

}
