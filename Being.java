public  abstract class Being implements IAttack , IAct{
    private int ID;
    private Location location;
    private Weapon weapon;
    private Armor armor;
    private Army army;
    private int maxAttackDelay;
    private int currentAttackDelay;

    public Being(int ID, Weapon weapon, Armor armor, Location location) {
        this.ID = ID;
        this.location = location;
        weapon.setOwner(this);
        this.weapon = weapon;
        this.armor = armor;
    }

    int getMaxAttackDelay() {
        return maxAttackDelay;
    }

    void setMaxAttackDelay(int maxAttackDelay) {
        this.maxAttackDelay = maxAttackDelay;
    }

    int getCurrentAttackDelay() {
        return currentAttackDelay;
    }

    void setCurrentAttackDelay(int currentAttackDelay) {
        this.currentAttackDelay = currentAttackDelay;
    }

    int getID() {
        return ID;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    Army getArmy() {
        return army;
    }

    Location getLocation() {
        return location;
    }

    Weapon getWeapon() {
        return weapon;
    }

    Armor getArmor() {
        return armor;
    }

    @Override
    public Action act() {
        Soldier enemyToAttack = null;
        for (int i = 0; i < Map.getSize() ; i++) {
            for (int j = 0; j < Map.getSize() ; j++) {
                Being target = Map.getMap()[i][j];
                if (target != null) {
                    if (target.getArmy() != getArmy() && !(target instanceof Tower)) {
                        if (getWeapon().canHit((Soldier) target)) {
                            if (enemyToAttack != null) {
                                if (enemyToAttack.getID() > target.getID()) {
                                    enemyToAttack = (Soldier) target;
                                }
                            } else {
                                enemyToAttack = (Soldier) target;
                            }
                        }
                    }
                }
            }
        }
        if (enemyToAttack != null) {
            return new AttackAction(this, enemyToAttack);
        } else {
            return new MovementAction(this);
        }

    }
}
