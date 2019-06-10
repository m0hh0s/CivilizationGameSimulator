class Map {
    private static int size;
    private static Being[][] map;

    Map(int size) {
        Map.size = size;
        map = new Being[size][size];
    }

    static Being[][] getMap() {
        return map;
    }

    static void setMap(Being[][] map1){
        map = map1;
    }

    static int getSize(){
        return size;
    }
}
