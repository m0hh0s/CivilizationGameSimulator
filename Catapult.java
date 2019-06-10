public class Catapult extends Weapon {
    Catapult() {
        super(2500, 10);
    }

    @Override
    public boolean canHit(Soldier enemy) {
        boolean compareX = Math.abs( enemy.getLocation().getX() - getOwner().getLocation().getX() ) <= 2;
        boolean compareY = Math.abs( enemy.getLocation().getY() - getOwner().getLocation().getY() ) <= 2;
        return compareX && compareY;
    }
}
