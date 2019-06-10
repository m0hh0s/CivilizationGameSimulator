public class AttackAction extends Action {
    private Soldier enemy;

    AttackAction(Being being, Soldier enemy) {
        super(being);
        this.enemy = enemy;
    }

    @Override
    public void takeAction() {
        being.attack(enemy);
    }
}
