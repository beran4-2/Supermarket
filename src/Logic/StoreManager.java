package Logic;

import Data.Product;

import java.util.HashMap;
import java.util.ArrayList;

public class StoreManager {

    private HashMap<String, Integer> shelves;
    private HashMap<String, Integer> storage;
    private HashMap<String, Integer> inOrder;

    private int maxTotalShelves;
    private int maxTotalStorage;

    public StoreManager(ArrayList<Product> availableProducts, GameManager gameManager) {
        shelves = new HashMap<>();
        storage = new HashMap<>();
        inOrder = new HashMap<>();

        this.maxTotalShelves = gameManager.getData().getSettings().getMaxTotalShelves();
        this.maxTotalStorage = gameManager.getData().getSettings().getMaxTotalStorage();

        for (int i = 0; i <availableProducts.size(); i++) {
            storage.put(availableProducts.get(i).getName(), availableProducts.get(i).getDefaultStorage());
            shelves.put(availableProducts.get(i).getName(), availableProducts.get(i).getDefaultShelves());
            inOrder.put(availableProducts.get(i).getName(), availableProducts.get(i).getDefaultOrder());
        }
    }

    public int getCurrentTotalShelves() {
        int total = 0;
        for (int amount : shelves.values()) {
            total += amount;
        }
        return total;
    }

    public int getCurrentTotalStorage() {
        int total = 0;
        for (Integer amount : storage.values()) {
            total += amount;
        }
        return total;
    }

    public boolean moveFromStorageToShelves(String productName, int amount) {
        int productInStorage = storage.getOrDefault(productName, 0);
        int productInShelves = shelves.getOrDefault(productName, 0);

        if (productInStorage >= amount) {
            if (getCurrentTotalShelves() + amount <= maxTotalShelves) {
                storage.put(productName, productInStorage - amount);
                shelves.put(productName, productInShelves + amount);
                return true;
            }
        }
        return false;
    }

    public boolean moveFromShelvesToStorage(String productName, int amount) {
        int productInStorage = storage.getOrDefault(productName, 0);
        int productInShelves = shelves.getOrDefault(productName, 0);

        if (productInShelves >= amount) {
            if (getCurrentTotalStorage() + amount <= maxTotalStorage) {
                shelves.put(productName, productInShelves - amount);
                storage.put(productName, productInStorage + amount);
                return true;
            }
        }
        return false;
    }

    public void addToOrder(String productName, int amount) {
        int currentAmount = inOrder.getOrDefault(productName, 0);
        inOrder.put(productName, currentAmount + amount);
    }

    public void addToStorage(String productName, int amount) {
        int currentAmount = storage.getOrDefault(productName, 0);
        storage.put(productName, currentAmount + amount);
    }

    public void processDeliveries() {
        for (String pName : inOrder.keySet()) {
            int amount = inOrder.get(pName);
            if (amount > 0) {
                addToStorage(pName, amount);
            }
        }
        for (String pName : inOrder.keySet()) {
            inOrder.put(pName, 0);
        }
    }


    public boolean sellOneFromShelves(String productName) {
        int procuctInShelves = shelves.get(productName);
        if (procuctInShelves > 0) {
            shelves.put(productName, procuctInShelves - 1);
            return true;
        }
        return false;
    }

    public HashMap<String, Integer> getShelves() { return shelves; }
    public HashMap<String, Integer> getStorage() { return storage; }
    public HashMap<String, Integer> getInOrder() { return inOrder; }
    public int getMaxTotalShelves() { return maxTotalShelves; }
    public int getMaxTotalStorage() { return maxTotalStorage; }

    public void setMaxTotalShelves(int maxTotalShelves) {
        this.maxTotalShelves = maxTotalShelves;
    }

    public void setMaxTotalStorage(int maxTotalStorage) {
        this.maxTotalStorage = maxTotalStorage;
    }
}
