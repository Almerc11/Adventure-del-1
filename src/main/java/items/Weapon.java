package items;

public abstract class Weapon extends Item {

    public Weapon(String name, String description) {
        super(name, description);
    }

    public abstract int getDamage();
}
