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

    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy))
            enemy.takeDamage(getWeapon().getDamage());
    }

    public void takeDamage(int damageTaken){
        hitpoints -= ( (double)getArmor().getDamageReduction() / 100.0) * damageTaken;
    }

}
