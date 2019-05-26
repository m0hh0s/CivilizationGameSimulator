public class Javalin extends Weapon {
    public Javalin() {
        super(1500, 2);
    }

    @Override
    public boolean canHit(Soldier enemy) {
        boolean compareX = enemy.getLocation().getX() - owner.getLocation().getX() <= 1;
        boolean compareY = ( enemy.getLocation().getY() - owner.getLocation().getY() > 0 ) && ( enemy.getLocation().getY() - owner.getLocation().getY() < 3 );
        return compareX && compareY;
    }
}
