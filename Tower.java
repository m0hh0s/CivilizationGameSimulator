public class Tower extends Being {

    public Tower(int ID, Location location) {
        super(ID, new Catapult(), new StoneArmor(), location);
    }

    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy))
            enemy.takeDamage(getWeapon().getDamage());
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "Tower" + "," + getLocation();
    }
}
