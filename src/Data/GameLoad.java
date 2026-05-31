package Data;

import Data.Entities.Employee;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/**
 * Handles loading game data from a JSON file.
 * It uses the Gson library to create products, employees, and settings.
 */
public class GameLoad {

    private GameSettings settings;
    private ArrayList<Product> products;
    private ArrayList<Employee> employees;

    /**
     * Loads all game data from the specified JSON file path.
     * * @param filePath The path to the JSON file inside the resources folder.
     * @return A GameLoad object containing all the loaded data.
     * @throws IllegalStateException If the JSON file cannot be found.
     * @throws RuntimeException If there is an error during JSON parsing.
     */
    public static GameLoad loadDataFromResource(String filePath) {
        Gson gson = new Gson();
        try (InputStream is = GameLoad.class.getResourceAsStream(filePath)) {
            if (is == null) {
                throw new IllegalStateException("Resource not found: " + filePath);
            }
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameLoad.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Error loading JSON: " + e.getMessage());
        }
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public void setSettings(GameSettings settings) {
        this.settings = settings;
    }
    /**
     * Prints a quick summary of the loaded data to the console.
     * Useful for debugging and checking if everything was loaded correctly.
     */
    public void loadDataInfo(){
        System.out.println("Products loaded: " + products.size());
        System.out.println("Employees loaded: " + employees.size());
        System.out.println("Settings loaded: " + settings);
    }
}