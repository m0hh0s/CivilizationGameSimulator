public class Swordsman extends Soldier implements IAttack {


    public Swordsman(int ID, Army army, Location location) {
        super(ID, new Sword(), new IronArmor() , location);
        super.setHitpoints(5000);
        super.setArmy(army);
        super.setMovementDelay(2);
    }


    @Override
    public void attack(Soldier enemy){
        if (getWeapon().canHit(enemy)) {
            enemy.takeDamage(getWeapon().getDamage());
            super.setAttackDelay(super.getAttackDelay() + 1);
        }
    }
}