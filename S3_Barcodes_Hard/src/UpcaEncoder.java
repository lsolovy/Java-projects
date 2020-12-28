/**
 * A class that will turn a product code into its UPC-A
 * Will check to make sure that the product code is valid
 * Will create the checksum digit and then endcode the product code to the UPC-A
 */
public class UpcaEncoder {
    public UpcaEncoder(String upca) {
        this.upca = upca;
    }

    public String upca;


    public void setUpca(String upca) {
        this.upca = upca;
    }

    /**
     * Will made sure that the product code if valid
     * WIll compute the checksum digit
     * @return the new product code with the checksum digit
     */
    public String check() {
        if (upca.length() != 11) {
            System.out.println("ERROR, not 11 digits, will compute wrong");
        } else {
            int odd = 0;
            for (int i = 0; i < upca.length(); i += 2) {
                char c = upca.charAt(i);
                int o = Integer.parseInt(String.valueOf(c));
                odd += o;
            }

            int even = 0;
            for (int i = 1; i < upca.length(); i += 2) {
                char c = upca.charAt(i);
                int e = Integer.parseInt(String.valueOf(c));
                even += e;
            }
            int total = (3 * odd) + even;
            int checksum = 10 - (total % 10);
            upca = upca + checksum;
            //System.out.println(upca);
        }
        return upca;
    }

    /**
     * Will encode process product code with the checksum digit into the UPC-A
     */
    public void encode() {

        check();
        String startend = "101";
        String Lzero = "0001101";
        String Lone = "0011001";
        String Ltwo = "0010011";
        String Lthree = "0111101";
        String Lfour = "0100011";
        String Lfive = "0110001";
        String Lsix = "0101111";
        String Lseven = "0111011";
        String Leight = "0110111";
        String Lnine = "0001011";
        String middle = "01010";
        String Rzero = "1110010";
        String Rone = "1100110";
        String Rtwo = "1101100";
        String Rthree = "1000010";
        String Rfour = "1011100";
        String Rfive = "1001110";
        String Rsix = "1010000";
        String Rseven = "1000100";
        String Reight = "1001000";
        String Rnine = "1110100";

        // create two new strings one consisting of the first half and the other with the second half
        String first = upca.substring(0, (upca.length() / 2));
        String second = upca.substring((upca.length() / 2));
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        //adds the front bar guard
        a.append(startend);
        // will loop through the first half of the product code and convert it to UPC-A
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            if (c == '0') {
                a.append(Lzero);
            }
            if (c == '1') {
                a.append(Lone);
            }
            if (c == '2') {
                a.append(Ltwo);
            }
            if (c == '3') {
                a.append(Lthree);
            }
            if (c == '4') {
                a.append(Lfour);
            }
            if (c == '5') {
                a.append(Lfive);
            }
            if (c == '6') {
                a.append(Lsix);
            }
            if (c == '7') {
                a.append(Lseven);
            }
            if (c == '8') {
                a.append(Leight);
            }
            if (c == '9') {
                a.append(Lnine);
            }
        }
        //adds middle guard bars
        a.append(middle);
        //will loop through the second half of the product code and convert it to UPC-A
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (c == '0') {
                b.append(Rzero);
            }
            if (c == '1') {
                b.append(Rone);
            }
            if (c == '2') {
                b.append(Rtwo);
            }
            if (c == '3') {
                b.append(Rthree);
            }
            if (c == '4') {
                b.append(Rfour);
            }
            if (c == '5') {
                b.append(Rfive);
            }
            if (c == '6') {
                b.append(Rsix);
            }
            if (c == '7') {
                b.append(Rseven);
            }
            if (c == '8') {
                b.append(Reight);
            }
            if (c == '9') {
                b.append(Rnine);
            }
        }
        //adds end guard bars
        b.append(startend);
        a.append(b);
        System.out.println(a);

    }
}





