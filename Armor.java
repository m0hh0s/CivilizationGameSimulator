public class Armor {
    private int damageReduction;
    private int weight;

    public Armor(int damageReduction, int weight) {
        this.damageReduction = damageReduction;
        this.weight = weight;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public int getWeight() {
        return weight;
    }
}
