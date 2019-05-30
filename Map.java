public class Map {
    private static int size;
    private static Being[][] map;

    public Map(int size) {
        this.size = size;
        map = new Being[size][size];
    }

    public static Being[][] getMap() {
        return map;
    }

    public static void setMap(Being[][] map1){
        map = map1;
    }

    public static int getSize(){
        return size;
    }
}
