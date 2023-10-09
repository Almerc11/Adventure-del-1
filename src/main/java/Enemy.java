import items.Weapon;
public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

   /* Skal lige kigges på engang mere

   public void attack(Player player) {

        int damage = weapon.calculateDamage();
        player.hit(damage);
        System.out.println(name + "attack you with" + weapon.getName() + "for" + damage + "damage!");
    }

    public void hit(int damage) {
        if (damage > 0) {
            health -= damage;
            if (health <= 0) {
                die();

            }
        }
    }

    private void die() {
        System.out.println(name + " is defeated!");
        // Drop enemy's weapon in the current room
        getCurrentRoom().addItem(weapon);
        // Remove the enemy from the room's list of enemies
        getCurrentRoom().removeEnemy(this);
    }
private Room getCurrentRoom(){
     // implementeres i room klassen
}
}

    */

