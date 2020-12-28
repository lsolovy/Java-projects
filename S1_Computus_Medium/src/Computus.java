import java.util.Scanner;

/**
 * Will print out the day that easter is on based on the users input. If
 * the user enters -1 the program will terminate. After the user decides
 * to exit the loop the day and month of each day that easter occurs on
 * will print out.
 */
public class Computus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a year:  (To EXIT enter -1) ");
        int year = scan.nextInt();
        Easter e = new Easter(year);
        while (year != -1) {
            e.setYear(year);
            e.easterCalc();
            e.printEaster();
            System.out.println("Enter a year:  (To EXIT enter -1)");
            year = scan.nextInt();
        }


        scan.close();
        e.cycle();
    }
}
