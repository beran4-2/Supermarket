package Data;

import Data.Entities.Employee;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameLoad {

    private GameSettings settings;
    private ArrayList<Product> products;
    private ArrayList<Employee> employees;


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

    public void loadDataInfo(){
        System.out.println("Loading data info...");
        System.out.println("Products loaded: " + products.size());
        System.out.println("Employees loaded: " + employees.size());
        System.out.println("Settings loaded: " + settings);
    }
}