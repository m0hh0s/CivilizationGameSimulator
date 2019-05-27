public abstract class Action {
    protected Being being;

    public Action(Being being) {
        this.being = being;
    }

    public abstract void takeAction();
}
