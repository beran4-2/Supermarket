package Data;

public class GameSettings {
    private int startMoney;
    private int numberOfCustomers;
    private int MaxTotalShelves;
    private int MaxTotalStorage;

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

    @Override
    public String toString() {
        return "GameSettings{" +
                "startMoney=" + startMoney +
                ", numberOfCustomers=" + numberOfCustomers +
                ", MaxTotalShelves=" + MaxTotalShelves +
                ", MaxTotalStorage=" + MaxTotalStorage +
                '}';
    }
}
