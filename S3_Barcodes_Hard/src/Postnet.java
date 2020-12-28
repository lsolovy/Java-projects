import java.util.Scanner;
/**
 * Will execute the classes of ZipToBar and BarToZip
 * Allows for user to input the ZIP code to be decoded into a Bar code
 * and then allows the user to input a Bar code to be decoded to a ZIP code
 */
public class Postnet {

    public static void main(String[] args) {
        System.out.println("Enter Zip:  (To EXIT enter -1)");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        String exit = "-1";
        ZipToBar n = new ZipToBar();
        n.Zip(num);
        num = scan.nextLine();
        while(!num.equals(exit)){
            n.Zip(num);
            num = scan.nextLine();
        }
        System.out.println("Enter barcode to decode (To EXIT enter -1)");
        String bar = scan.nextLine();
        BarToZip b = new BarToZip();
        b.Bar(bar);
        bar = scan.nextLine();
        while(!bar.equals(exit)){
            b.Bar(bar);
            bar = scan.nextLine();
        }

    }
}

