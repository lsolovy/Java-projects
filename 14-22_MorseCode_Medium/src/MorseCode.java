
import java.util.Scanner;
/**
 * Class MorseCode is the main class in the program that will run the encoding and decoding process.
 */
public class MorseCode {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        EngToMorse e = new EngToMorse();
        MorseToEng m = new MorseToEng();
        System.out.println("Enter English to be encoded in Morse");
        String input = scan.nextLine();
        e.encode(input);
        System.out.println("Enter Morse to be decoded into English");
        String input2 = scan.nextLine();
        m.decode(input2);
    }
}
