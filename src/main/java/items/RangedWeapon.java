package items;

public class RangedWeapon extends Weapon{
    private double damage;
    private int ammo;
    private double damageRange;
    public RangedWeapon(String name, String description, double damage, double damageRange, int ammo) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
        this.ammo = ammo;
    }
    public RangedWeapon(String name, String description, double damage, double damageRange) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
        this.ammo = 0;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    public double getDamageRange() {
        return damageRange;
    }

    public int getAmmo(){
        return ammo;
    }

}
