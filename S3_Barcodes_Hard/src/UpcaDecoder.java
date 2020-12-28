/**
 * A class that will convert a UPC-A into its product code
 * Will check to make sure that the UPC-A is valid
 * Will check to make sure the checksum is correct
 */
public class UpcaDecoder {
    public UpcaDecoder(String upca) {
        this.upca = upca;
    }

    public String upca;


    /**
     * Will deocode the barcode to the product code
     * @return a product code without checking the checksum
     */
    public String decode(){
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

        if(upca.length() != 95){
            System.out.println("Error, not 95 digits");
        }
        else{
            //will create two new strings consisting of important characters
            String d = upca.substring(3,45);
            String e = upca.substring(50,92);
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            String[] f ;
            //will spilt the string array into 7th
            f = d.split("(?<=\\G.......)");
            //will go though the first half of string and create the front of the product code
            for(String string : f){
                if(string.equals(Lzero)){a.append("0");}
                if(string.equals(Lone)){a.append("1");}
                if(string.equals(Ltwo)){a.append("2");}
                if(string.equals(Lthree)){a.append("3");}
                if(string.equals(Lfour)){a.append("4");}
                if(string.equals(Lfive)){a.append("5");}
                if(string.equals(Lsix)){a.append("6");}
                if(string.equals(Lseven)){a.append("7");}
                if(string.equals(Leight)){a.append("8");}
                if(string.equals(Lnine)){a.append("9");}
            }

            String[] g;
            g = e.split("(?<=\\G.......)");
            //will go though the second half of string and create the back of the product code
            for(String string : g){
                if(string.equals(Rzero)){ b.append("0");}
                if(string.equals(Rone)){ b.append("1");}
                if(string.equals(Rtwo)){ b.append("2");}
                if(string.equals(Rthree)){ b.append("3");}
                if(string.equals(Rfour)){ b.append("4");}
                if(string.equals(Rfive)){ b.append("5");}
                if(string.equals(Rsix)){ b.append("6");}
                if(string.equals(Rseven)){ b.append("7");}
                if(string.equals(Reight)){ b.append("8");}
                if(string.equals(Rnine)){ b.append("9");}
            }
            //adds back to front
            a.append(b);
            upca = a.toString();

        }
        return upca;
    }

    /**
     * checks the to make sure that product code has the correct checksum digit
     */
    public void check(){
        decode();
        //saves the last character
        String j = upca.substring(upca.length()-1);
        int checksum = Integer.parseInt(j);

        String upca2 = upca.substring(0,upca.length()-1);

        int odd = 0;
        for (int i = 0; i < upca2.length(); i += 2) {
            char c = upca2.charAt(i);
            int o = Integer.parseInt(String.valueOf(c));
            odd += o;
        }

        int even = 0;
        for (int i = 1; i < upca2.length(); i += 2) {
            char c = upca2.charAt(i);
            int e = Integer.parseInt(String.valueOf(c));
            even += e;
        }
        int total = (3 * odd) + even;
        if(checksum != 10 - (total%10)){
            System.out.println("Error, invalid UPC-A");
        }
        else{
            System.out.println("check digit - " + checksum + ", okay");
            System.out.println("Product code - " + upca2);
        }

    }

}
