public class Catapult extends Weapon {
    public Catapult() {
        super(2500, 10);

    }

    @Override
    public boolean canHit(Soldier enemy) {
        boolean compareX = Math.abs( enemy.getLocation().getX() - owner.getLocation().getX() ) <= 2;
        boolean compareY = Math.abs( enemy.getLocation().getY() - owner.getLocation().getY() ) <= 2;
        return compareX && compareY;
    }
}
