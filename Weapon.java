public abstract class Weapon {
    private int damage;
    private int loadingTime;
    protected Being owner;

    public Weapon(int damage, int loadingTime) {
        this.damage = damage;
        this.loadingTime = loadingTime;
    }

    public void setOwner(Being owner) {
        this.owner = owner;
    }

    public abstract boolean canHit(Soldier enemy);

    public int getDamage() {
        return damage;
    }

    public int getLoadingTime() {
        return loadingTime;
    }
}
