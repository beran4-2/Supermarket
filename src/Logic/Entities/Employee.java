package Logic.Entities;

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
    public void update() {

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