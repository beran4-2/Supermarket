package Data.Entities;

import Data.Product;

import java.util.*;

public class Customer extends Human {


    private Map<String, Integer> productPreferences;
    private Random random;

    public Customer(String name, int id) {
        super(name, id);
        this.productPreferences = new HashMap<>();
        this.random = new Random();
    }

    public void generatedPreferences(ArrayList<Product> availableProducts) {
        for (int i = 0; i < availableProducts.size(); i++) {
            String product = availableProducts.get(i).getName();
            int chance = random.nextInt(101);
            productPreferences.put(product, chance);
        }
    }

    @Override
    public void update() {

    }
}