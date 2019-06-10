class Armor {
    private int damageReduction;
    private int weight;

    Armor(int damageReduction, int weight) {
        this.damageReduction = damageReduction;
        this.weight = weight;
    }

    int getDamageReduction() {
        return damageReduction;
    }

    int getWeight() {
        return weight;
    }
}
