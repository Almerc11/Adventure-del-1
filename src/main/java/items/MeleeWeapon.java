package items;

public class MeleeWeapon extends Weapon{
    private int damage;
    private double damageRange;
    public MeleeWeapon(String name, String description, int damage, double damageRange) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public double getDamageRange(){
        return damageRange;
    }
}
