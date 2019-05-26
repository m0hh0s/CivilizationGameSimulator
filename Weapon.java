public abstract class Weapon {
    private int damage;
    private int loadingTime;
    protected Being owner;

    public Weapon(int damage, int loadingTime, Being owner) {
        this.damage = damage;
        this.loadingTime = loadingTime;
        this.owner = owner;
    }

    public abstract boolean canHit(Soldier enemy);

}
