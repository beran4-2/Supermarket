package Logic;

import Data.GameLoad;
import Data.Entities.Customer;
import Data.Entities.Employee;
import Data.Product;

import java.util.ArrayList;

public class GameManager {


    private GameLoad data;
    private Customer customer;
    private StoreManager storeManager;


    private ArrayList<Customer> customers;
    private ArrayList<Employee> employees;


    private int currentBalance;

    private ArrayList<Product> products;

    public void gameInitialization(){
        data = GameLoad.loadDataFromResource("/gameData.json");
        employees = data.getEmployees();
        products = data.getProducts();
        currentBalance = data.getSettings().getStartMoney();

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
        for (Customer customer : customers) {
            customer.update();
        }
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

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}
