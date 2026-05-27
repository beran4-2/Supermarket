package Logic;

import Data.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class StoreManager {

    private Map<String, Integer> shelves;
    private Map<String, Integer> storage;
    private Map<String, Integer> inOrder;

    private int maxTotalShelves;
    private int maxTotalStorage;
    private int maxTotalInOrder;

    public StoreManager(ArrayList<Product> availableProducts, GameManager gameManager) {
        shelves = new HashMap<>();
        storage = new HashMap<>();
        inOrder = new HashMap<>();

        this.maxTotalShelves = gameManager.getData().getSettings().getMaxTotalShelves();
        this.maxTotalStorage = gameManager.getData().getSettings().getMaxTotalStorage();
        this.maxTotalInOrder = maxTotalStorage - getCurrentTotalStorage();

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

    public boolean moveToOrder(String productName, int amount) {
        return true;
    }

    public boolean moveFromInOrderToStorage(String productName, int amount) {
        return true;
    }

    public boolean sellOneFromShelves(String productName) {
        int procuctInShelves = shelves.get(productName);
        if (procuctInShelves >= 0) {
            shelves.put(productName, procuctInShelves - 1);
            return true;
        }
        return false;
    }

    public Map<String, Integer> getShelves() { return shelves; }
    public Map<String, Integer> getStorage() { return storage; }
    public Map<String, Integer> getInOrder() { return inOrder; }
    public int getMaxTotalShelves() { return maxTotalShelves; }
    public int getMaxTotalStorage() { return maxTotalStorage; }
}
