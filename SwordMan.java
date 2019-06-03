public class SwordMan extends Soldier {


    public SwordMan(int ID, Army army, Location location) {
        super(ID, new Sword(), new IronArmor() , location);
        setHitpoints(5000);
        setArmy(army);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
        setMaxMovementDelay(getArmor().getWeight());
        setCurrentMovementDelay(getMaxMovementDelay());    }

    @Override
    public void attack(Soldier enemy){
        if (getCurrentAttackDelay() > 0){
            setCurrentAttackDelay(getCurrentAttackDelay() - 1);
        }
        else {
            System.out.println("swordMan " + getID() + " Attacking...");
            if (getWeapon().canHit(enemy)) {
                enemy.takeDamage(getWeapon().getDamage());
                if (!enemy.isAlive()) {
                    getLocation().setY(enemy.getLocation().getY());
                    getLocation().setX(enemy.getLocation().getX());
                }
                setMaxAttackDelay(getMaxAttackDelay() + 1);
            }
            setCurrentAttackDelay(getMaxAttackDelay());
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "SwordMan" + "," + getHitpoints() + "," + getLocation();

    }
}
