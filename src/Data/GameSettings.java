package Data;

public class GameSettings {
    private int startMoney;
    private int numberOfCustomers;
    private int basePercentProd;
    private int MaxTotalShelves;
    private int MaxTotalStorage;
    private int chanceIncrease;
    private int currentDay;
    private int lowRandomCustomers;
    private int highRandomCustomers;
    private int upgrade100StoragePrice;
    private int upgrade100ShelvesPrice;
    private double priceMultiplier;

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public int getMaxTotalShelves() {
        return MaxTotalShelves;
    }

    public void setMaxTotalShelves(int maxTotalShelves) {
        MaxTotalShelves = maxTotalShelves;
    }

    public int getMaxTotalStorage() {
        return MaxTotalStorage;
    }

    public void setMaxTotalStorage(int maxTotalStorage) {
        MaxTotalStorage = maxTotalStorage;
    }

    public int getBasePercentProd() {
        return basePercentProd;
    }

    public void setBasePercentProd(int basePercentProd) {
        this.basePercentProd = basePercentProd;
    }

    public int getChanceIncrease() {
        return chanceIncrease;
    }

    public void setChanceIncrease(int chanceIncrease) {
        this.chanceIncrease = chanceIncrease;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getLowRandomCustomers() {
        return lowRandomCustomers;
    }

    public void setLowRandomCustomers(int lowRandomCustomers) {
        this.lowRandomCustomers = lowRandomCustomers;
    }

    public int getHighRandomCustomers() {
        return highRandomCustomers;
    }

    public void setHighRandomCustomers(int highRandomCustomers) {
        this.highRandomCustomers = highRandomCustomers;
    }

    public int getUpgrade100StoragePrice() {
        return upgrade100StoragePrice;
    }

    public void setUpgrade100StoragePrice(int upgrade100StoragePrice) {
        this.upgrade100StoragePrice = upgrade100StoragePrice;
    }

    public int getUpgrade100ShelvesPrice() {
        return upgrade100ShelvesPrice;
    }

    public void setUpgrade100ShelvesPrice(int upgrade100ShelvesPrice) {
        this.upgrade100ShelvesPrice = upgrade100ShelvesPrice;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    @Override
    public String toString() {
        return "GameSettings{" +
                "startMoney=" + startMoney +
                ", numberOfCustomers=" + numberOfCustomers +
                ", basePercentProd=" + basePercentProd +
                ", MaxTotalShelves=" + MaxTotalShelves +
                ", MaxTotalStorage=" + MaxTotalStorage +
                ", chanceIncrease=" + chanceIncrease +
                ", currentDay=" + currentDay +
                ", lowRandomCustomers=" + lowRandomCustomers +
                ", highRandomCustomers=" + highRandomCustomers +
                ", upgrade100StoragePrice=" + upgrade100StoragePrice +
                ", upgrade100ShelvesPrice=" + upgrade100ShelvesPrice +
                ", priceMultiplier=" + priceMultiplier +
                '}';
    }
}
