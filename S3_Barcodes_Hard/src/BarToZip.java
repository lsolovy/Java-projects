/**
 * Will decode a barcode in the form of "|" and "." to the ZIP code
 * Will first decode the bar code into binary and then to ZIP
 * Uses StringBuilder to creates an empty string that can append characters
 * Checks the checksum to make sure that a valid barcode  was entered, if not an error message will send
 */
public class BarToZip {
    public void Bar(String bar) {
        StringBuilder binary = new StringBuilder();
        StringBuilder zip = new StringBuilder();
        String a = "1";
        String b = "0";
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
        //removes the first and last "|"  becasue they are irrelevant frame bars
        bar = bar.substring(1, bar.length() - 1);
        //goes through the barcode and will add to a string of the binary conversion
        for (int i = 0; i < bar.length(); i++) {
            char c = bar.charAt(i);
            if (c == '|') {
                binary.append(a);
            } else {
                binary.append(b);
            }
        }

        String[] f ;
        //will split the string array into 5ths
        f = binary.toString().split("(?<=\\G.....)");
        //will go through each 5th and append to a string consisting of the ZIP
        for(String string : f){
            if(string.equals(zero)){
                zip.append("0");
            }
            if(string.equals(one)){
                zip.append("1");
            }
            if(string.equals(two)){
                zip.append("2");
            }
            if(string.equals(three)){
                zip.append("3");
            }
            if(string.equals(four)){
                zip.append("4");
            }
            if(string.equals(five)){
                zip.append("5");
            }
            if(string.equals(six)){
                zip.append("6");
            }
            if(string.equals(seven)){
                zip.append("7");
            }
            if(string.equals(eight)){
                zip.append("8");
            }
            if(string.equals(nine)){
                zip.append("9");
            }


        }
        //will same the last character (the checksum element)
        String j = zip.substring(zip.length()-1);
        int checksum = 10-Integer.parseInt(j);
        zip.setLength(zip.length()-1);
        int sum = 0;
        //will go though the string without the last element to make sure the checksum is correct
        for(int i = 0; i < zip.length(); i++){
            char c = zip.charAt(i);
            int p = Integer.parseInt(String.valueOf(c));
            sum = sum + p;
        }
        if(sum%10 != checksum){
            System.out.println("Invalid");
        }else{
            if(zip.length() == 5){

                System.out.println(zip);
            }
            if(zip.length() == 9){
                zip.insert(5,"-");
                System.out.println(zip);
            }
            if(zip.length() >= 11){
                zip.insert(5,"-");
                zip.insert(10,"-");
                System.out.println(zip);
            }
        }


    }

}





