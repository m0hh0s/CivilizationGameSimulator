public abstract class Being {
    private Location location;
    private Weapon weapon;
    private Armor armor;
    private boolean isAlive;

    public Being(Location location, Weapon weapon, Armor armor, boolean isAlive) {
        this.location = location;
        this.weapon = weapon;
        this.armor = armor;
        this.isAlive = isAlive;
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

    public boolean isAlive() {
        return isAlive;
    }

    public abstract void act();
}
