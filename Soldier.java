public class Soldier extends Being {
    private Army army;
    private int hitpoints;
    private int movementDelay;
    private int attackDelay;

    public void move(){}
    public int getHitpoints() {
        return hitpoints;
    }
    public void attack(){}
    public void takeDamage(int damageTaken){
        hitpoints -= damageTaken;
    }








}
