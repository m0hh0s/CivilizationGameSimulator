public class SpearMan extends Soldier{
    SpearMan(int ID, Army army, Location location) {
        super(ID, new Javelin(), new IronArmor(), location);
        setHitpoints(3000);
        setArmy(army);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
        setMaxMovementDelay(getArmor().getWeight() + 1);
        setCurrentMovementDelay(getMaxMovementDelay());
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
        return "" + getID() + "," + "SpearMan" + "," + getHitpoints() + "," + getLocation();
    }
}

