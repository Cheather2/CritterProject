import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Critter contestantOne;
        Critter contestantTwo;
        ArrayList<Critter> input = getInput();
        Collections.sort(input);

        for (Critter fighter : input) {
            System.out.println(fighter);
        }

        System.out.println("---------------------------------------------------");

        Collections.shuffle(input);

        int n = 1;

        while(input.size() != 1) {

            System.out.println("ROUND " + n + "!" );

            Collections.shuffle(input);

            for (int i = 0; i < input.size() - 1; i++) {

                contestantOne = input.get(i);
                contestantTwo = input.get(i + 1);

                System.out.println("---------FIGHT!!!----------");

                System.out.println(contestantOne.getName() + " vs. " + contestantTwo.getName());

                while (!Critter.isDead(contestantOne.getHealth()) && !Critter.isDead(contestantTwo.getHealth())) {

                    System.out.println(contestantOne.getName() + " " + contestantOne.attackMessage());

                    contestantTwo.acceptDamage(Critter.attackEffectiveness(contestantOne));

                    if (Critter.isDead(contestantTwo.getHealth())) {
                        System.out.println("-------" + contestantOne.getName() + " WINS!!!-------");
                        input.remove(contestantTwo);
                        continue;
                    }
                    if (!Critter.isDead(contestantOne.getHealth())) {
                        System.out.println(contestantTwo.getName() + " " + contestantTwo.attackMessage());
                        contestantOne.acceptDamage(Critter.attackEffectiveness(contestantTwo));

                        if (Critter.isDead(contestantOne.getHealth())) {
                            System.out.println("-------" + contestantTwo.getName() + " WINS!!!-------");
                            input.remove(contestantOne);
                        }
                    }
                }
            }
            n++;
        }
        System.out.println("No enemies remain, the winner is " + input);
    }

    public static ArrayList<Critter> getInput (){

        String fileName = "input.txt";

        ArrayList<Critter> participants = new ArrayList<>();
        try {

            Scanner input = new Scanner(new File(fileName));

            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                String [] arr = line.split(" ");
                if(arr[0].equalsIgnoreCase("W")&& arr.length == 2){
                    participants.add(new Warrior(arr[1]));
                }
                else if(arr[0].equalsIgnoreCase("S") && arr.length == 3){
                    participants.add(new Soldier(arr[1], Double.parseDouble(arr[2])));
                }
                else if(arr[0].equalsIgnoreCase("T") && arr.length == 6 && Double.parseDouble(arr[2]) > 0){
                    participants.add(new Scout(arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Double.parseDouble(arr[4]), Double.parseDouble(arr[5])));
                }
                else if(arr[0].equalsIgnoreCase("Z") && arr.length == 1){
                    participants.add(new Zombie());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }return participants;
    }
}
