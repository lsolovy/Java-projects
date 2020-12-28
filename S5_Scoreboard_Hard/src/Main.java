import java.util.Scanner;
/**
 * Main class uses the sport classes the extend the abstract class Game to allow for the program to run
 * The user will be prompted how many games they would like to play, and then they will have options of which sport to play
 * When they are playing their game, it will print a menu of the options the user has
 * They will keep picking until the certain game runs out of periods
 * The score and menu will be prompted to the user each time its their turn
 * If they want to exit at the end of a game they have to enter -1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many games would you like to play");
        int games = scan.nextInt();
        for(int i = 0; i < games; i++){
            System.out.println("Select the type of Game");
            System.out.println("1. Football");
            System.out.println("2. Basketball");
            System.out.println("3. Soccer");
            System.out.println("4. Hockey");
            System.out.println("-1. EXIT");
            int sport = scan.nextInt();
            if(sport == 1){
                System.out.println("Enter Home team");
                String team1 = scan.next();
                System.out.println("Enter Away team");
                String team2 = scan.next();
                Team home = new Team(team1);
                Team away = new Team(team2);
                Game football = new Football(home,away);
                ScoringMethod[] arr = football.getScoreArray();
                while(!football.isGameOver()){
                    System.out.println("Menu");
                    for(int j = 0; j < arr.length; j++){

                        System.out.println(j + ". " + arr[j].teamName + ": " + arr[j].score);
                    }
                    System.out.println("10. End " + football.getPeriodName());
                    System.out.println(home.getName() + ": " + home.getScore());
                    System.out.println(away.getName() + ": " + away.getScore());
                    System.out.println("Current Quarter: " + football.getPeriod());
                    System.out.println("Enter option");
                    int option = scan.nextInt();
                    football.updateScore(option);
                }
                System.out.println("Game Over");
                System.out.println(home.getName() + ": " + home.getScore());
                System.out.println(away.getName() + ": " + away.getScore());
            }
            if(sport == 2){
                System.out.println("Enter Home team");
                String team1 = scan.next();
                System.out.println("Enter Away team");
                String team2 = scan.next();
                Team home = new Team(team1);
                Team away = new Team(team2);
                Game basketball = new Basketball(home,away);
                ScoringMethod[] arr = basketball.getScoreArray();
                while(!basketball.isGameOver()){
                    System.out.println("Menu");
                    for(int k = 0; k < arr.length; k++){

                        System.out.println(k + ". " + arr[k].teamName + ": " + arr[k].score);
                    }
                    System.out.println("6. End " + basketball.getPeriodName());
                    System.out.println(home.getName() + ": " + home.getScore());
                    System.out.println(away.getName() + ": " + away.getScore());
                    System.out.println("Current Quarter: " + basketball.getPeriod());
                    System.out.println("Enter option");
                    int option = scan.nextInt();
                    basketball.updateScore(option);
                }
                System.out.println("Game Over");
                System.out.println(home.getName() + ": " + home.getScore());
                System.out.println(away.getName() + ": " + away.getScore());
            }
            if(sport == 3){
                System.out.println("Enter Home team");
                String team1 = scan.next();
                System.out.println("Enter Away team");
                String team2 = scan.next();
                Team home = new Team(team1);
                Team away = new Team(team2);
                Game soccer = new Soccer(home,away);
                ScoringMethod[] arr = soccer.getScoreArray();
                while(!soccer.isGameOver()){
                    System.out.println("Menu");
                    for(int p = 0; p < arr.length; p++){

                        System.out.println(p + ". " + arr[p].teamName + ": " + arr[p].score);
                    }
                    System.out.println("4. End " + soccer.getPeriodName());
                    System.out.println(home.getName() + ": " + home.getScore());
                    System.out.println(away.getName() + ": " + away.getScore());
                    System.out.println("Current Half: " + soccer.getPeriod());
                    System.out.println("Enter option");
                    int option = scan.nextInt();
                    soccer.updateScore(option);
                }
                System.out.println("Game Over");
                System.out.println(home.getName() + ": " + home.getScore());
                System.out.println(away.getName() + ": " + away.getScore());
            }
            if(sport == 4){
                System.out.println("Enter Home team");
                String team1 = scan.next();
                System.out.println("Enter Away team");
                String team2 = scan.next();
                Team home = new Team(team1);
                Team away = new Team(team2);
                Game hockey = new Hockey(home,away);
                ScoringMethod[] arr = hockey.getScoreArray();
                while(!hockey.isGameOver()){
                    System.out.println("Menu");
                    for(int h = 0; h < arr.length; h++){

                        System.out.println(h + ". " + arr[h].teamName + ": " + arr[h].score);
                    }
                    System.out.println("4. End " + hockey.getPeriodName());
                    System.out.println(home.getName() + ": " + home.getScore());
                    System.out.println(away.getName() + ": " + away.getScore());
                    System.out.println("Current Period: " + hockey.getPeriod());
                    System.out.println("Enter option");
                    int option = scan.nextInt();
                    hockey.updateScore(option);
                }
                System.out.println("Game Over");
                System.out.println(home.getName() + ": " + home.getScore());
                System.out.println(away.getName() + ": " + away.getScore());
            }
            if(sport == -1){
                i = games;
            }

        }

    }
}
