package items;

public class RangedWeapon extends Weapon{
    private double damage;
    private double damageRange;
    private int maxAmmo;
    private int currentAmmo;

    public RangedWeapon(String name, String description, double damage, double damageRange, int maxAmmo) {
        super(name, description);
        this.damage = damage;
        this.damageRange = damageRange;
        this.maxAmmo = maxAmmo;
        this.currentAmmo = maxAmmo; //vi starter med max ammo
    }

    @Override
    public double getDamage() {
        return damage;
    }

    public double getDamageRange() {
        return damageRange;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public void reloadAmmo() {
        currentAmmo = maxAmmo;
    }

    public void useAmmo() {
      if (currentAmmo > 0) {
          currentAmmo--;
      }else{
          System.out.println("No ammo left");

          //prøvede at udskifte void i stedet for boolean
      }
    }
}
