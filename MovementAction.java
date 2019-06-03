public class MovementAction extends Action {
    public MovementAction(Being being) {
        super(being);
    }

    @Override
    public void takeAction() {
        if (!(being instanceof Tower))
            ((Soldier) being).move();
        else {
            being.setCurrentAttackDelay(being.getCurrentAttackDelay() - 1);
        }
    }
}
