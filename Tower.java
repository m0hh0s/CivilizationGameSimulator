public class Tower extends Being {
    private int hitpoints = 1000;

    public Tower(int ID, Location location) {
        super(ID, new Catapult(), new StoneArmor(), location);
        setMaxAttackDelay(getWeapon().getLoadingTime());
        setCurrentAttackDelay(getMaxAttackDelay());
    }

    @Override
    public void attack(Soldier enemy){
        if (getCurrentAttackDelay() > 0){
            setCurrentAttackDelay(getCurrentAttackDelay() - 1);
            //System.out.println("tower delay is    " + getCurrentAttackDelay());
        }
        else {
            System.out.println("tower Attacking...");
            if (getWeapon().canHit(enemy))
                enemy.takeDamage(getWeapon().getDamage());
            setCurrentAttackDelay(getMaxAttackDelay());
        }
    }

    @Override
    public String toString() {
        return "" + getID() + "," + "Tower" + "," + hitpoints + "," + getLocation();
    }
}
