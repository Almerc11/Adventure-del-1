package items;

import items.Item;

public abstract class Weapon extends Item {

    public Weapon(String name, String description) {
        super(name, description);
    }

    public abstract double getDamage();
}
