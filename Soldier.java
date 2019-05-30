public abstract class Soldier extends Being {
    private Army army;
    private int hitpoints;
    private int movementDelay;
    private int attackDelay;
    private boolean isMovingUp;

    public Soldier(int ID, Weapon weapon, Armor armor, Location location) {
        super(ID, weapon, armor, location);
        movementDelay += armor.getWeight();
        attackDelay = weapon.getLoadingTime();
        if (army.getGroup().equals("group 1"))
            isMovingUp = true;
        else
            isMovingUp = false;
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

    private void moveRightOrLeft(){
        try {
            if (Map.getMap()[location.getX() + 1][location.getY()] == null){
                location.setX(location.getX() + 1);
                return;
            }
            if (Map.getMap()[location.getX() - 1][location.getY()] == null){
                location.setX(location.getX() - 1);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            if (Map.getMap()[location.getX() - 1][location.getY()] == null) {
                location.setX(location.getX() - 1);
            }
        }
    }

    public void move(){
        if (isMovingUp){
            if (location.getY() + 1 == Map.getSie()){
                isMovingUp = false;
                move();
            }
            else if(Map.getMap()[location.getX()][location.getY() + 1] instanceof Tower){
                moveRightOrLeft();

            }
            else{
                location.setY(location.getY() + 1);
            }
        }
        else{
            if (location.getY() == 0 ){
                isMovingUp = true;
                move();
            }
            else if(Map.getMap()[location.getX()][location.getY() + 1] instanceof Tower){
                moveRightOrLeft();
            }
            else{
                location.setY(location.getY() - 1);
            }
        }
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void takeDamage(int damageTaken){
        hitpoints -= ( (double)getArmor().getDamageReduction() / 100.0) * damageTaken;
    }

}
