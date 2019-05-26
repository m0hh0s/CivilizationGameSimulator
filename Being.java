public abstract class Being {
    private int ID;
    protected Location location;
    private Weapon weapon;
    private Armor armor;
    protected boolean isAlive;

    public Being(int ID, Weapon weapon, Armor armor, Location location) {
        this.ID = ID;
        this.location = location;
        weapon.setOwner(this);
        this.weapon = weapon;
        this.armor = armor;
        this.isAlive = true;
    }

    public Location getLocation() {
        return location;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public abstract void attack(Soldier enemy);

}
