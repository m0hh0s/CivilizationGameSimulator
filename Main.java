import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<Being> beings = new ArrayList<>();

    public static void main(String[] args) {
        int mapSize = reader.nextInt();
        Map map = new Map(mapSize);
        int numberOfSoldiersTeam1 = reader.nextInt();
        int numberOfSoldiersTeam2 = reader.nextInt();
        Army team1 = new Army("group 1");
        Army team2 = new Army("group 2");
        teamCreator(numberOfSoldiersTeam1 ,team1 ,beings , reader);
        teamCreator(numberOfSoldiersTeam2 ,team2 ,beings , reader);
        int tick = reader.nextInt();
        Time.tick(tick , beings);
    }

    private static void teamCreator(int NumberOfSoldiers , Army currentArmy, ArrayList<Being> beings, Scanner reader){
        for (int i = 0 ; i < NumberOfSoldiers ; i++){
            int tempID = reader.nextInt();
            reader.nextLine();
            String tempType = reader.nextLine();
            int tempRow = reader.nextInt();
            int tempColumn = reader.nextInt();
            if (tempType.equals("Tower")){
                Being being = new Tower(tempID , new Location(tempColumn , tempRow));
                being.setArmy(currentArmy);
                beings.add(being);
            }
            else if (tempType.equals("SwordMan")){
                Being being = new Swordsman(tempID, currentArmy , new Location(tempColumn , tempRow));
                beings.add(being);
            }
            else if (tempType.equals("SpearMan")){
                Being being = new Spearman(tempID, currentArmy , new Location(tempColumn , tempRow));
                beings.add(being);
            }
        }
    }
}
