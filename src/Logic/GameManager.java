package Logic;

import Data.GameLoad;
import Data.Entities.Customer;
import Data.Entities.Employee;
import Data.Product;

import java.util.ArrayList;

public class GameManager {

    private GameLoad data;
    private StoreManager storeManager;

    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;
    private ArrayList<Employee> hiredEmployees;

    private int currentBalance;
    private int currentDay;

    private ArrayList<Product> products;

    public void gameInitialization(){
        data = GameLoad.loadDataFromResource("/gameData.json");
        employees = data.getEmployees();
        hiredEmployees = new ArrayList<>();
        products = data.getProducts();
        currentBalance = data.getSettings().getStartMoney();
        currentDay = data.getSettings().getCurrentDay();

        customers = new ArrayList<>();
        storeManager = new StoreManager(products, this);
        generateNewCustomers(data.getSettings().getNumberOfCustomers());
    }

    public void generateNewCustomers(int number) {
        for (int i = 0; i < number; i++) {
            Customer newCustomer = new Customer("Customer", customers.size());
            newCustomer.generatedPreferences(products);
            customers.add(newCustomer);
        }
    }

    public void nextTurn(){
        for (int i = customers.size() - 1; i >= 0; i--) {
            if (!customers.get(i).update(this)){
                customers.remove(i);
            }
        }

        for (Employee employee : hiredEmployees) {
            employee.update(this);

            if (currentDay > 0 && currentDay % 7 == 0) {
                currentBalance -= employee.getSalary();
            }
        }

        generateRandomCustomers(data.getSettings().getLowRandomCustomers(), data.getSettings().getHighRandomCustomers());

        storeManager.processDeliveries();

        currentDay++;
    }

    public boolean processRestock(java.util.HashMap<String, Integer> cart, int totalCost) {
        int totalItemsInCart = 0;
        for (int amount : cart.values()) {
            totalItemsInCart += amount;
        }

        int alreadyInStorage = storeManager.getCurrentTotalStorage();
        int alreadyOrdered = 0;
        for (int amount : storeManager.getInOrder().values()) {
            alreadyOrdered += amount;
        }

        int availableSpace = storeManager.getMaxTotalStorage() - alreadyInStorage - alreadyOrdered;

        if (currentBalance >= totalCost && totalItemsInCart <= availableSpace) {
            currentBalance -= totalCost;

            for (String pName : cart.keySet()) {
                int amount = cart.get(pName);
                if (amount > 0) {
                    storeManager.addToOrder(pName, amount);
                }
            }
            return true;
        }
        return false;
    }

    public void generateRandomCustomers(int lowRandom, int highRandom) {
        java.util.Random random = new java.util.Random();
        int count = random.nextInt((highRandom - lowRandom) + 1) + lowRandom;
        generateNewCustomers(count);
    }

    public boolean hireEmployee(Employee template) {
        if (currentBalance >= template.getInstantPrice()) {
            currentBalance -= template.getInstantPrice();
            Employee newEmployee = new Employee(
                    template.getName(),
                    (int)(Math.random() * 10000),
                    template.getInstantPrice(),
                    template.getSalary(),
                    template.getWorkCapacity(),
                    template.getRole()
            );
            hiredEmployees.add(newEmployee);
            return true;
        }
        return false;
    }

    public boolean upgradeStorage() {
        int currentPrice = data.getSettings().getUpgrade100StoragePrice();
        if (currentBalance >= currentPrice) {
            currentBalance -= currentPrice;

            int newMax = storeManager.getMaxTotalStorage() + 100;
            storeManager.setMaxTotalStorage(newMax);
            data.getSettings().setMaxTotalStorage(newMax);

            int nextPrice = (int) (currentPrice * data.getSettings().getPriceMultiplier());
            data.getSettings().setUpgrade100StoragePrice(nextPrice);

            return true;
        }
        return false;
    }

    public boolean upgradeShelves() {
        int currentPrice = data.getSettings().getUpgrade100ShelvesPrice();
        if (currentBalance >= currentPrice) {
            currentBalance -= currentPrice;

            int newMax = storeManager.getMaxTotalShelves() + 100;
            storeManager.setMaxTotalShelves(newMax);
            data.getSettings().setMaxTotalShelves(newMax);

            int nextPrice = (int) (currentPrice * data.getSettings().getPriceMultiplier());
            data.getSettings().setUpgrade100ShelvesPrice(nextPrice);

            return true;
        }
        return false;
    }

    public ArrayList<Employee> getHiredEmployees() {
        return hiredEmployees;
    }

    public GameLoad getData() {
        return data;
    }

    public StoreManager getStoreManager() {
        return storeManager;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}