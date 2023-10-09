public class Food extends Item {

    private int health;
    public Food(String name, String description, int healthPoints) {
        super(name, description);
        this.health = healthPoints;
    }
    public int getHealth() {
        return health;
    }
}
