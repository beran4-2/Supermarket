package Data.Entities;

import Data.Product;
import Logic.GameManager;

import java.util.*;

/**
 * Represents a customer entity browsing and shopping in the store.
 * his class handles customer product selection
 *
 */
public class Customer extends Human {


    private HashMap<String, Integer> productPreferences;
    private Random random;

    /**
     * Constructs a new Customer instance.
     * @param name The display name of the customer.
     * @param id The unique identifier.
     */
    public Customer(String name, int id) {
        super(name, id);
        this.productPreferences = new HashMap<>();
        this.random = new Random();
    }


    /**
     * Generates initial purchase probabilities for all available products.
     * @param availableProducts The list of products currently offered in the store.
     */
    public void generatedPreferences(ArrayList<Product> availableProducts) {
        for (int i = 0; i < availableProducts.size(); i++) {
            String product = availableProducts.get(i).getName();
            int chance = random.nextInt(101);
            productPreferences.put(product, chance);
        }
    }


    /**
     * updates the customer's shopping behavior.
     * It tries to buy products based on their current interest.
     * If they don't buy, their interest increases for the next time.
     *
     * @param gameManager The manager providing access to the store's current state.
     * @return
     */
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