public  abstract class Being implements IAttack , IAct{
    private int ID;
    protected Location location;
    private Weapon weapon;
    private Armor armor;
    protected boolean isAlive;
    private Army army;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Being(int ID, Weapon weapon, Armor armor, Location location) {
        this.ID = ID;
        this.location = location;
        weapon.setOwner(this);
        this.weapon = weapon;
        this.armor = armor;
        this.isAlive = true;

    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public Location getLocation() {
        return location;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    @Override
    public Action act() {
        Soldier enemyToAttack = null;
        for (int i = 0 ; i < Map.getSie() ; i++) {
            for (int j = 0 ; j < Map.getSie() ; j++) {
                Being target = Map.getMap()[i][j];
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
        if (enemyToAttack != null) {
            return new AttackAction(this, enemyToAttack);
        } else {
            return new MovementAction(this);
        }

    }

}
