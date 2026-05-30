package Data.Entities;

import Logic.GameManager;

public abstract class Human {

    protected String name;
    protected int id;

    public Human(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean update(GameManager gameManager);

}
