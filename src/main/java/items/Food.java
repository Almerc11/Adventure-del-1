package items;

import items.Item;

public class Food extends Item {
    private int healthAddition;
    public Food(String name, String description, int healthAddition) {
        super(name, description);
        this.healthAddition = healthAddition;
    }

    public int getHealthAddition(){
        return healthAddition;
    }
}
