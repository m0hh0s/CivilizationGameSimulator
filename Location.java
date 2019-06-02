public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
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
        return "" + x + "," + y;
    }
}
