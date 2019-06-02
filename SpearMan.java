public class SpearMan extends Soldier{

    public SpearMan(int ID, Army army, Location location) {
        super(ID, new Javelin(), new IronArmor(), location);
        super.setHitpoints(3000);
        super.setArmy(army);
        super.setMovementDelay(1);
    }

    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy)) {
            enemy.takeDamage(getWeapon().getDamage());
            if (!enemy.isAlive()){
                this.location.setY(enemy.getLocation().getY());
                this.location.setX(enemy.getLocation().getX());
            }
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "SpearMan" + "," + getHitpoints() + "," + getLocation();
    }
}

