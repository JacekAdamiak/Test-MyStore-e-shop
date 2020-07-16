package MyStoreTest.ToolBox;



public class ToolBoxMethods {


    //    Metoda wstrzymije wykonanie programu na określoną ilość sekund
    public void giveMeFewSeconds(int howManySeconds) {
        try {
            Thread.sleep(howManySeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//        Metoda sprawdzająca czy naliczono rabat
//        Zwraca wartość true - tak został naliczony, false - nie został naliczony;
    public Boolean getPromoIsGiven(String priceRegular, String pricePromo) {
//        Zamiana String na double
        double priceRegularInt = Double. parseDouble(priceRegular);
        double pricePromoInt = Double. parseDouble(pricePromo);
//        Zdefiniowanie zmiannej typu Boolean
        Boolean promoIsGiven = false;
//        Sprawdzenie czy z podanych cen faktycznie wychodzi rabat około 20%
//        Jeżeli tak to zmiennej promoIsGiven nadawana jest wartość true
        if ((1-pricePromoInt/priceRegularInt) > 0.19) {promoIsGiven = true;}
        return promoIsGiven;
    }

}
