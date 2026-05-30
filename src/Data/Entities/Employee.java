package Data.Entities;

import Data.Product;
import Logic.GameManager;

import java.util.HashMap;

public class Employee extends Human {

    private int instantPrice;
    private int salary;
    private int workCapacity;
    private EmployeeRole role;

    public Employee(String name, int id, int instantPrice, int salary, int workCapacity, EmployeeRole role) {
        super(name, id);
        this.instantPrice = instantPrice;
        this.salary = salary;
        this.workCapacity = workCapacity;
        this.role = role;
    }

    @Override
    public boolean update(GameManager gameManager) {
        if (role == EmployeeRole.RESTOCKER) {

            int maxShelves = gameManager.getStoreManager().getMaxTotalShelves();
            int currentShelves = gameManager.getStoreManager().getCurrentTotalShelves();

            if (currentShelves >= maxShelves) {
                return true;
            }

            int capacity = workCapacity;
            boolean itemMoved = true;

            while (itemMoved && capacity > 0) {
                itemMoved = false;

                for (Product p : gameManager.getProducts()) {
                    if (capacity <= 0) {
                        break;
                    }

                    currentShelves = gameManager.getStoreManager().getCurrentTotalShelves();
                    if (currentShelves >= maxShelves) {
                        break;
                    }

                    String pName = p.getName();
                    int inStorage = gameManager.getStoreManager().getStorage().getOrDefault(pName, 0);

                    if (inStorage > 0) {
                        gameManager.getStoreManager().moveFromStorageToShelves(pName, 1);
                        capacity--;
                        itemMoved = true;
                    }
                }
            }
        }else if (role == EmployeeRole.ORDERER) {
            int maxStorage = gameManager.getStoreManager().getMaxTotalStorage();
            int currentStorage = gameManager.getStoreManager().getCurrentTotalStorage();

            int totalIncoming = 0;
            for (int amount : gameManager.getStoreManager().getInOrder().values()) {
                totalIncoming += amount;
            }

            if (currentStorage + totalIncoming >= maxStorage) return true;

            int capacity = workCapacity;
            boolean itemOrdered = true;

            while (itemOrdered && capacity > 0) {
                itemOrdered = false;
                for (Product p : gameManager.getProducts()) {
                    if (capacity <= 0) break;
                    currentStorage = gameManager.getStoreManager().getCurrentTotalStorage();
                    totalIncoming = 0;
                    for (int amount : gameManager.getStoreManager().getInOrder().values()) {
                        totalIncoming += amount;
                    }

                    if (currentStorage + totalIncoming >= maxStorage) break;

                    String pName = p.getName();
                    int inStorage = gameManager.getStoreManager().getStorage().get(pName);
                    int inShelves = gameManager.getStoreManager().getShelves().get(pName);
                    int inPending = gameManager.getStoreManager().getInOrder().get(pName);

                    if ((inStorage + inShelves + inPending) < 10) {
                        int price = p.getPurchasePrice();
                        if (gameManager.getCurrentBalance() >= price) {
                            gameManager.setCurrentBalance(gameManager.getCurrentBalance() - price);
                            gameManager.getStoreManager().getInOrder().put(pName, inPending + 1);
                            capacity--;
                            itemOrdered = true;
                        }
                    }
                }
            }
        }


        return true;
    }

    public int getInstantPrice() {
        return instantPrice;
    }

    public void setInstantPrice(int instantPrice) {
        this.instantPrice = instantPrice;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkCapacity() {
        return workCapacity;
    }

    public void setWorkCapacity(int workCapacity) {
        this.workCapacity = workCapacity;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }
}