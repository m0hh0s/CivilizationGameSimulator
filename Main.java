import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList<Being> beings = new ArrayList<>();

    public static void main(String[] args) {
        int mapSize = reader.nextInt();
        new Map(mapSize);
        int numberOfSoldiersTeam1 = reader.nextInt();
        int numberOfSoldiersTeam2 = reader.nextInt();
        reader.nextLine();
        Army team1 = new Army("group 1");
        Army team2 = new Army("group 2");
        teamCreator(numberOfSoldiersTeam1 ,team1 ,beings , reader);
        teamCreator(numberOfSoldiersTeam2 ,team2 ,beings , reader);
        String tempString = reader.nextLine();
        while (!tempString.equals("terminate")){
            tempString = tempString.replaceAll("tick " , "");
//            int tick = 0;
//            try {
//                tick = Integer.parseInt(tempString);
//            }catch (NumberFormatException e){
//                return;
//            }
            int tick = Integer.parseInt(tempString);
            Time.tick(tick , beings);
            printResult(beings);
            tempString = reader.nextLine();
        }
    }

    private static void teamCreator(int NumberOfSoldiers , Army currentArmy, ArrayList<Being> beings, Scanner reader){
        for (int i = 0 ; i < NumberOfSoldiers ; i++) {
            String tempString = reader.nextLine();
            String[] strings = tempString.split(",");
            int tempID = Integer.parseInt(strings[0]);
            String tempType = strings[1];
            int tempRow = Integer.parseInt(strings[2]);
            int tempColumn = Integer.parseInt(strings[3]);
            switch (tempType) {
                case "Tower": {
                    Being being = new Tower(tempID, new Location(tempColumn, tempRow));
                    being.setArmy(currentArmy);
                    beings.add(being);
                    break;
                }
                case "SwordMan": {
                    Being being = new SwordMan(tempID, currentArmy, new Location(tempColumn, tempRow));
                    beings.add(being);
                    break;
                }
                case "SpearMan": {
                    Being being = new SpearMan(tempID, currentArmy, new Location(tempColumn, tempRow));
                    beings.add(being);
                    break;
                }
            }
        }
    }

    private static void printResult(ArrayList<Being> beings){
        for (Being being : beings){
            System.out.println(being);
        }
    }
}
