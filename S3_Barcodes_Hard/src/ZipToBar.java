/**
 * Will encode a ZIP code to a Bar code
 * Will first decode the ZIP to binary
 * Uses StringBuilder to creates an empty string that can append characters
 * Will compute the checksum and add it to the string
 */
public class ZipToBar {
    public void Zip(String num) {
        StringBuilder binary = new StringBuilder();
        StringBuilder bar = new StringBuilder();
        String zero = "11000";
        String one = "00011";
        String two = "00101";
        String three = "00110";
        String four = "01001";
        String five = "01010";
        String six = "01100";
        String seven = "10001";
        String eight = "10010";
        String nine = "10100";
        String o = "|";
        String z = ".";

        int checksum = 0;
        //replaces any "-" if there are any
        String num1 = num.replace("-","");
        // will go through the string and compute the first step for checksum by adding all the numbers
        for (int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(i);
            int a = Integer.parseInt(String.valueOf(c));
            checksum = checksum + a;

        }
        checksum = checksum % 10;
        checksum = 10 - checksum;
        num1 = num1 + checksum;
        //will go through the new ZIP with the checksum and add to a new string that creates the binary
        for (int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(i);
            if (c == '0') {
                binary.append(zero);
            }
            if (c == '1') {
                binary.append(one);
            }
            if (c == '2') {
                binary.append(two);
            }
            if (c == '3') {
                binary.append(three);
            }
            if (c == '4') {
                binary.append(four);
            }
            if (c == '5') {
                binary.append(five);
            }
            if (c == '6') {
                binary.append(six);
            }
            if (c == '7') {
                binary.append(seven);
            }
            if (c == '8') {
                binary.append(eight);
            }
            if (c == '9') {
                binary.append(nine);
            }
        }
        //will add a 1 to both ends
        binary.append("1");
        binary.insert(0, '1');
        //will go though binary string to create a new string of the barcode
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '0') {
                bar.append(z);
            } else {
                bar.append(o);
            }
        }
        System.out.println(bar);
    }
}


