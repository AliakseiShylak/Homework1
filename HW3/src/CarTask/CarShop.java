package CarTask;

public class CarShop {
    private final String NAME_OF_SHOP;
    private final CarService SERVICE_OF_SHOP;
    private Stock stockOfShop;

    public CarShop(String NAME_OF_SHOP, CarService SERVICE_OF_SHOP, Stock stockOfShop) {
        this.NAME_OF_SHOP = NAME_OF_SHOP;
        this.SERVICE_OF_SHOP = SERVICE_OF_SHOP;
        this.stockOfShop = stockOfShop;
    }

    public CarShop(String NAME_OF_SHOP, CarService SERVICE_OF_SHOP) {
        this.NAME_OF_SHOP = NAME_OF_SHOP;
        this.SERVICE_OF_SHOP = SERVICE_OF_SHOP;
        this.stockOfShop = null;
    }

    public String printStockOfShop() {
        return "\nStock of car shop " + this.NAME_OF_SHOP + this.stockOfShop.printStock();
    }

    public String getNAME_OF_SHOP() {
        return NAME_OF_SHOP;
    }

    public CarService getSERVICE_OF_SHOP() {
        return SERVICE_OF_SHOP;
    }

    public Stock getStockOfShop() {
        return stockOfShop;
    }

    public boolean addCarToStock(Car car) {
        return this.stockOfShop.addCarToStock(car);
    }
}
