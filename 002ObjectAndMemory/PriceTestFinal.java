class Price{
    final static Price INSTANCE = new Price(2.8);
    final static double initPrice = 20;
    double currentPrice;
    public Price(double discount){
        currentPrice = initPrice-discount;
    }
}

public class PriceTestFinal{
    public static void main(String [] args){
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2);
        System.out.println(p.currentPrice);
    }
}