import java.util.ArrayList;

public class Time {
    public static void tick(int rounds, ArrayList <Being> beings){
        mapUpdater(beings);
        for (int i = 0 ; i < rounds ; i++){
            ArrayList <Action> currentRoundActions = new ArrayList<>();
            for (Being being : beings){
                if (being instanceof Tower || ((Soldier)being).isAlive())
                    currentRoundActions.add(being.act());
            }
            for (Action action : currentRoundActions){
                action.takeAction();
            }
            mapUpdater(beings);
        }
    }

    private static void mapUpdater(ArrayList<Being> beings){
        Being[][] newMap = new Being[Map.getSize()][Map.getSize()];
        for (Being being : beings){
            if (being instanceof Tower || ((Soldier)being).isAlive())
                newMap[being.getLocation().getX()][being.getLocation().getY()] = being;
            //System.out.println(being);
        }
        Map.setMap(newMap);
    }
}
