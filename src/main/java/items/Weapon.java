package items;

import items.Item;

public class Weapon extends Item {

    private double damage;

    public Weapon(String name, String description, double damage) {
        super(name, description);
        this.damage = damage;
    }

    public double getDamage(){
        return damage;
    }


}
