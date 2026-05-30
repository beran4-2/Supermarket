package Data.Entities;

import Data.Product;
import Logic.GameManager;

import java.util.*;

public class Customer extends Human {


    private HashMap<String, Integer> productPreferences;
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
    public boolean update(GameManager gameManager) {
        for (String product : productPreferences.keySet()) {
            int buyChance = productPreferences.get(product);
            int chance = random.nextInt(101);

            boolean bought = false;

            if (buyChance >= chance) {
                if (gameManager.getStoreManager().sellOneFromShelves(product)) {
                    for (Product p : gameManager.getProducts()){
                        if (p.getName().equals(product)) {
                            gameManager.setCurrentBalance(gameManager.getCurrentBalance() + p.getSellingPrice());
                            productPreferences.put(product, gameManager.getData().getSettings().getBasePercentProd());
                            bought = true;
                            break;
                        }
                    }
                } else return false;
            }

            if (!bought) {
                int chanceIncrease = productPreferences.get(product) + gameManager.getData().getSettings().getChanceIncrease();
                if (chanceIncrease > 100) {
                    chanceIncrease = 100;
                }
                productPreferences.put(product, chanceIncrease);
            }
        }
        return true;
    }
}