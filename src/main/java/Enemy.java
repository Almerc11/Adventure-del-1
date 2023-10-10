import items.Weapon;

public class Enemy {
    String name;
    String description;
    Weapon enemyEquippedWeapon;
    int health;

    public Enemy(String name, String description, int health, Weapon enemyEquippedWeapon){
        this.enemyEquippedWeapon = enemyEquippedWeapon;
        this.name = name;
        this. description = description;
        this.health = health;
    }

    public double attack(){
        return enemyEquippedWeapon.getDamage();
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getHealth(){
        return health;
    }
    public Weapon getEnemyEquippedWeapon(){
        return enemyEquippedWeapon;
    }
}
