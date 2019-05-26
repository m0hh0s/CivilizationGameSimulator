public class Sword extends Weapon {

    public Sword(Being owner) {
        super(2000 , 1 , owner);
    }

    @Override
    public boolean canHit(Soldier enemy) {
        boolean compareX = Math.abs( enemy.getLocation().getX() - owner.getLocation().getX() ) <= 1;
        boolean compareY = Math.abs( enemy.getLocation().getY() - owner.getLocation().getY() ) <= 1;
        return compareX && compareY;
    }
}
