public class Javelin extends Weapon {
    Javelin() {
        super(1500, 2);
    }

    @Override
    public boolean canHit(Soldier enemy) {
        if ( ((Soldier)getOwner()).isMovingUp() ) {
            boolean compareX = enemy.getLocation().getX() - getOwner().getLocation().getX() <= 1;
            boolean compareY = (enemy.getLocation().getY() - getOwner().getLocation().getY() > 0) && (enemy.getLocation().getY() - getOwner().getLocation().getY() < 3);
            return compareX && compareY;
        }else {
            boolean compareX = enemy.getLocation().getX() - getOwner().getLocation().getX() <= 1;
            boolean compareY = (enemy.getLocation().getY() - getOwner().getLocation().getY() < 0) && (enemy.getLocation().getY() - getOwner().getLocation().getY() > -3);
            return compareX && compareY;
        }
    }
}
