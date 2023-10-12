import items.Weapon;

public class Enemy {
    private String name;
    private String description;
    private Weapon enemyEquippedWeapon;
    private int health;

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
    public void enemyHealthDecrease(int damage){
        this.health = health - damage;
    }
    public Weapon getEnemyEquippedWeapon(){
        return enemyEquippedWeapon;
    }
}
