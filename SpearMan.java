public class SpearMan extends Soldier{

    public SpearMan(int ID, Army army, Location location) {
        super(ID, new Javelin(), new IronArmor(), location);
        setHitpoints(3000);
        setArmy(army);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
        setMaxMovementDelay(getArmor().getWeight());
        setCurrentMovementDelay(getMaxMovementDelay());
    }

    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy)) {
            enemy.takeDamage(getWeapon().getDamage());
            if (!enemy.isAlive()){
                this.getLocation().setY(enemy.getLocation().getY());
                this.getLocation().setX(enemy.getLocation().getX());
            }
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "SpearMan" + "," + getHitpoints() + "," + getLocation();
    }
}

