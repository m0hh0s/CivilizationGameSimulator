public abstract class Weapon {
    private int damage;
    private int loadingTime;
    private Being owner;

    Weapon(int damage, int loadingTime) {
        this.damage = damage;
        this.loadingTime = loadingTime;
    }

    void setOwner(Being owner) {
        this.owner = owner;
    }

    Being getOwner() {
        return owner;
    }

    int getDamage() {
        return damage;
    }

    int getLoadingTime() {
        return loadingTime;
    }

    public abstract boolean canHit(Soldier enemy);
}
