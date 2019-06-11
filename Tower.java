public class Tower extends Being {
    Tower(int ID, Location location) {
        super(ID, new Catapult(), new StoneArmor(), location);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
    }

    @Override
    public void attack(Soldier enemy) {
        setCurrentAttackDelay(getCurrentAttackDelay() - 1);
        if (getCurrentAttackDelay() <= 0){
            if (getWeapon().canHit(enemy)) {
                enemy.takeDamage(getWeapon().getDamage());
                setCurrentAttackDelay(getMaxAttackDelay());
            }
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "Tower" + "," + 1000 + "," + getLocation();
    }
}
