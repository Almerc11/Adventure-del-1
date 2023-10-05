package items;

public class MeleeWeapon extends Weapon{
    private double damage;
    private double damageRange;
    public MeleeWeapon(String name, String description, double damage, double damageRange) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    public double getDamageRange(){
        return damageRange;
    }
}
