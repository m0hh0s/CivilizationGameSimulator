public abstract class Soldier extends Being {
    private boolean isAlive;
    private int hitpoints;
    private int maxMovementDelay;
    private int currentMovementDelay;
    private boolean isMovingUp;

    public Soldier(int ID, Weapon weapon, Armor armor, Location location) {
        super(ID, weapon, armor, location);
        maxMovementDelay += armor.getWeight();
        setAlive(true);
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void setArmy(Army army) {
        super.setArmy(army);
        isMovingUp = getArmy().getGroup().equals("group 1");
    }

    void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    boolean isAlive() {
        if (getHitpoints() <= 0) {
            getLocation().setX(-1);
            getLocation().setY(-1);
            setAlive(false);
        }
        return isAlive;
    }

    private void moveRightOrLeft() {
        try {
            if (Map.getMap()[getLocation().getX() + 1][getLocation().getY()] == null) {
                getLocation().setX(getLocation().getX() + 1);
                return;
            }
            if (Map.getMap()[getLocation().getX() - 1][getLocation().getY()] == null) {
                getLocation().setX(getLocation().getX() - 1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (Map.getMap()[getLocation().getX() - 1][getLocation().getY()] == null) {
                getLocation().setX(getLocation().getX() - 1);
            }
        }
    }

    void move() {
        setCurrentMovementDelay(getCurrentMovementDelay() - 1);
        if (getCurrentMovementDelay() <= 0) {
            if (isMovingUp) {
                if (getLocation().getY() + 1 == Map.getSize()) {
                    isMovingUp = false;
                    move();
                } else if (Map.getMap()[getLocation().getX()][getLocation().getY() + 1] instanceof Tower) {
                    moveRightOrLeft();
                    setCurrentAttackDelay(getCurrentAttackDelay() - 1);
                } else {
                    getLocation().setY(getLocation().getY() + 1);
                    setCurrentAttackDelay(getCurrentAttackDelay() - 1);
                }
            } else {
                if (getLocation().getY() == 0) {
                    isMovingUp = true;
                    move();
                } else if (Map.getMap()[getLocation().getX()][getLocation().getY() - 1] instanceof Tower) {
                    moveRightOrLeft();
                    setCurrentAttackDelay(getCurrentAttackDelay() - 1);
                } else {
                    getLocation().setY(getLocation().getY() - 1);
                    setCurrentAttackDelay(getCurrentAttackDelay() - 1);
                }
            }
            setCurrentMovementDelay(getMaxMovementDelay());
        }
    }

    int getHitpoints() {
        if (hitpoints < 0)
            return 0;
        return hitpoints;
    }

    void takeDamage(int damageTaken) {
        hitpoints -= ( (100 - (double) getArmor().getDamageReduction()) / 100.0) * damageTaken;
    }

    int getMaxMovementDelay() {
        return maxMovementDelay;
    }

    void setMaxMovementDelay(int maxMovementDelay) {
        this.maxMovementDelay = maxMovementDelay;
    }

    private int getCurrentMovementDelay() {
        return currentMovementDelay;
    }

    void setCurrentMovementDelay(int currentMovementDelay) {
        this.currentMovementDelay = currentMovementDelay;
    }

    boolean isMovingUp() {
        return isMovingUp;
    }
}
