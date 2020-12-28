import java.util.Scanner;
/**
 * Will execute the classes of UpcaEncoder and UpcaDecoder
 * Allows for the user to input a product code to be encoded to a UPC-A
 * and then allows for the user to input a UPC-a to be decoded to a product code
 */
public class UpcaDriver {
    public static void main(String[] args) {
        String exit = "-1";
        System.out.println("Enter Product code:  (To EXIT enter -1)");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        UpcaEncoder u = new UpcaEncoder(num);
        u.setUpca(num);
        u.encode();
        num = scan.nextLine();
        while(!num.equals(exit)){
            u.setUpca(num);
            u.encode();
            num = scan.nextLine();
        }
        System.out.println("Enter barcode to decode  (To EXIT enter -1)");
        String binary = scan.nextLine();
        UpcaDecoder p = new UpcaDecoder(binary);
        p.check();
        binary = scan.nextLine();
        while(!binary.equals(exit)){
            p.check();
            binary = scan.nextLine();
        }
    }
}
