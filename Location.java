public class Location {
    private int x;
    private int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location tmp = (Location) obj;
            return (tmp.getX() == x && tmp.getY() == y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + y + "," + x;
    }
}
