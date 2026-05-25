package Data;

public class GameSettings {
    private int startMoney;
    private int numberOfCustomers;

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

    @Override
    public String toString() {
        return "GameSettings{" +
                "startMoney=" + startMoney +
                ", numberOfCustomers=" + numberOfCustomers +
                '}';
    }
}
