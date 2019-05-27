public class Soldier extends Being {
    private Army army;
    private int hitpoints;
    private int movementDelay;
    private int attackDelay;

    public Soldier(int ID, Weapon weapon, Armor armor, Location location) {
        super(ID, weapon, armor, location);
        movementDelay += armor.getWeight();
        attackDelay = weapon.getLoadingTime();
    }

    public Army getArmy() {
        return army;
    }

    public int getMovementDelay() {
        return movementDelay;
    }

    public int getAttackDelay() {
        return attackDelay;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public void setMovementDelay(int movementDelay) {
        this.movementDelay = movementDelay;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }

    public boolean isAlive(){
        if (getHitpoints() <= 0)
            super.isAlive = false;
        return isAlive;
    }

    public void move(){
        if (army.getGroup().equals("group 1")){
            location.setY(location.getY() + 1);
        }
        else{
            location.setY(location.getY() - 1);
        }
    }

    public int getHitpoints() {
        return hitpoints;
    }


    public void takeDamage(int damageTaken){
        hitpoints -= ( (double)getArmor().getDamageReduction() / 100.0) * damageTaken;
    }

}
