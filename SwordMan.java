public class SwordMan extends Soldier {
    SwordMan(int ID, Army army, Location location) {
        super(ID, new Sword(), new IronArmor() , location);
        setHitpoints(5000);
        setArmy(army);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
        setMaxMovementDelay(getArmor().getWeight() + 2);
        setCurrentMovementDelay(getMaxMovementDelay());    }

    @Override
    public void attack(Soldier enemy){
        setCurrentAttackDelay(getCurrentAttackDelay() - 1);
        if (getCurrentAttackDelay() <= 0){
            if (getWeapon().canHit(enemy) && enemy.isAlive()) {
                enemy.takeDamage(getWeapon().getDamage());
                setMaxAttackDelay(getMaxAttackDelay() + 1);
                setCurrentAttackDelay(getMaxAttackDelay());
                if (enemy.getHitpoints() <= 0) {
                    getLocation().setY(enemy.getLocation().getY());
                    getLocation().setX(enemy.getLocation().getX());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "SwordMan" + "," + getHitpoints() + "," + getLocation();
    }
}
