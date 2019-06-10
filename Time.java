import java.util.ArrayList;

class Time {
    static void tick(int rounds, ArrayList<Being> beings) {
        mapUpdater(beings);
        for (int i = 0; i < rounds; i++) {
            ArrayList<Action> currentRoundActions = new ArrayList<>();
            for (Being being : beings) {
                if (being instanceof Tower || ((Soldier) being).isAlive())
                    currentRoundActions.add(being.act());
            }
            for (int j = currentRoundActions.size() - 1; j > -1; j--) {
                currentRoundActions.get(j).takeAction();
            }
            mapUpdater(beings);
        }
    }

    private static void mapUpdater(ArrayList<Being> beings) {
        Being[][] newMap = new Being[Map.getSize()][Map.getSize()];
        for (Being being : beings) {
            if (being instanceof Tower || ((Soldier) being).isAlive()) {
                try {
                    newMap[being.getLocation().getX()][being.getLocation().getY()] = being;
                } catch (Exception ignored) {
                }
            }

        }
        Map.setMap(newMap);
    }
}
