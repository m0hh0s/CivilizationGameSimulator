public abstract class Action {
    protected Being being;

    Action(Being being) {
        this.being = being;
    }

    public abstract void takeAction();
}
