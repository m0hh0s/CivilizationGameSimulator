public class SwordMan extends Soldier {


    public SwordMan(int ID, Army army, Location location) {
        super(ID, new Sword(), new IronArmor() , location);
        super.setHitpoints(5000);
        super.setArmy(army);
        super.setMovementDelay(2);
    }


    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy)) {
            enemy.takeDamage(getWeapon().getDamage());
            if (!enemy.isAlive()){
                this.location.setY(enemy.getLocation().getY());
                this.location.setX(enemy.getLocation().getX());
            }
            super.setAttackDelay(super.getAttackDelay() + 1);
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "SwordMan" + "," + getHitpoints() + "," + getLocation();

    }
}
