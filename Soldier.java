public class Soldier extends Being {
    private Army army;
    private int hitpoints;
    private int movementDelay;
    private int attackDelay;

    public Soldier(int ID, Weapon weapon, Armor armor, Location location) {
        super(ID, weapon, armor, location);
    }

    public boolean isAlive(){
        if (getHitpoints() <= 0)
            super.isAlive = false;
        return isAlive;
    }

    public void move(Location target){
        if(isAlive()){
            location.setX(target.getX());
            location.setY(target.getY());
        }
    }

    public int getHitpoints() {
        return hitpoints;
    }

    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy))
            enemy.takeDamage(getWeapon().getDamage());
    }

    public void takeDamage(int damageTaken){
        hitpoints -= ( (double)getArmor().getDamageReduction() / 100.0) * damageTaken;
    }

}
