import java.util.ArrayList;

public class Time {
    public static void tick(int rounds, ArrayList <Being> beings){
        mapUpdater(beings);
        for (int i = 0 ; i < rounds ; i++){
            ArrayList <Action> currentRoundActions = new ArrayList<>();
            for (Being being : beings){
                currentRoundActions.add(being.act());
            }
            for (Action action : currentRoundActions){
                action.takeAction();
            }
            mapUpdater(beings);
        }
    }

    private static void mapUpdater(ArrayList<Being> beings){
        Being[][] newMap = new Being[Map.getSie()][Map.getSie()];
        for (Being being : beings){
            newMap[being.getLocation().getX()][being.getLocation().getY()] = being;
        }
        Map.setMap(newMap);
    }
}
