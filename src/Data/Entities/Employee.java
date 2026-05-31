package Data.Entities;

import Data.Product;
import Logic.GameManager;

/**
 * Represents an employee working in the store.
 * Employees have specific roles (like RESTOCKER or ORDERER)
 * and a work capacity that limits how many actions they can do in one turn.
 */
public class Employee extends Human {

    private int instantPrice;
    private int salary;
    private int workCapacity;
    private EmployeeRole role;

    /**
     * Constructs a new Employee instance.
     * * @param name The display name of the employee.
     * @param id The unique identifier for this employee.
     * @param instantPrice The initial cost to hire the employee.
     * @param salary The amount of money paid to the employee every week.
     * @param workCapacity The number of items this employee can handle in one turn.
     * @param role The specific job assigned to this employee.
     */
    public Employee(String name, int id, int instantPrice, int salary, int workCapacity, EmployeeRole role) {
        super(name, id);
        this.instantPrice = instantPrice;
        this.salary = salary;
        this.workCapacity = workCapacity;
        this.role = role;
    }


    /**
     *
     * Updates the employee's daily tasks based on their specific role.
     * RESTOCKER moves products from storage to the store shelves.
     * ORDERER checks stock levels and buys missing products if there is enough money.
     *
     * @param gameManager The manager providing access to the store's current state.
     * @return true when the employee successfully finishes their actions for the turn.
     */
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
                    int inPending = gameManager.getStoreManager().getInOrder().getOrDefault(pName, 0);

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