package items;

public class RangedWeapon extends Weapon{
    private int damage;
    private final int maxAmmo;
    private double damageRange;
    private int currentAmmo = 0;
    public RangedWeapon(String name, String description, int damage, double damageRange, int maxAmmo) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
        this.maxAmmo = maxAmmo;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public double getDamageRange() {
        return damageRange;
    }

    public int getmaxAmmo(){
        return maxAmmo;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public void reloadAmmo() {
        currentAmmo = maxAmmo;
    }

    public void useAmmo() {
        currentAmmo--;
    }
}
