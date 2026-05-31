package Data;
/**
 * Represents an item that can be bought, stored, and sold in the supermarket.
 */
public class Product {
    private String name;
    private String URL;
    private int purchasePrice;
    private int sellingPrice;
    private int defaultShelves;
    private int defaultStorage;
    private int defaultOrder;

    /**
     * Constructs a new Product with the specified details.
     * * @param name The name of the product.
     * @param URL The path to the product's image.
     * @param purchasePrice The cost from the supplier.
     * @param sellingPrice The price for the customers.
     * @param defaultShelves The initial amount on shelves.
     * @param defaultStorage The initial amount in storage.
     * @param defaultOrder The initial amount on order.
     */
    public Product(String name, String URL, int purchasePrice, int sellingPrice, int defaultShelves, int defaultStorage, int defaultOrder) {
        this.name = name;
        this.URL = URL;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.defaultShelves = defaultShelves;
        this.defaultStorage = defaultStorage;
        this.defaultOrder = defaultOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getDefaultShelves() {
        return defaultShelves;
    }

    public void setDefaultShelves(int defaultShelves) {
        this.defaultShelves = defaultShelves;
    }

    public int getDefaultStorage() {
        return defaultStorage;
    }

    public void setDefaultStorage(int defaultStorage) {
        this.defaultStorage = defaultStorage;
    }

    public int getDefaultOrder() {
        return defaultOrder;
    }

    public void setDefaultOrder(int defaultOrder) {
        this.defaultOrder = defaultOrder;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", URL='" + URL + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", defaultShelves=" + defaultShelves +
                ", defaultStorage=" + defaultStorage +
                ", defaultOrder=" + defaultOrder +
                '}';
    }
}