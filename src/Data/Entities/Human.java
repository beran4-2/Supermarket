package Data.Entities;

import Logic.GameManager;

/**
 * Abstract base class representing a human entity
 */
public abstract class Human {

    protected String name;
    protected int id;

    /**
     * onstructs a new Human entity.
     * @param name The display name of the human.
     * @param id The unique identifier for this human.
     */
    public Human(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Updates the state of the human entity.
     * This method is called during the game loop
     * @param gameManager The manager providing access to the store's current state.
     * @return
     */
    public abstract boolean update(GameManager gameManager);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
