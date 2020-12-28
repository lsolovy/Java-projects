import java.util.HashMap;

/**
 * Class EngToMorse will encode an English word to MorseCode using a hashmap.
 * Will locate the letter in the map and give the value (in this case the morsecode).
 * Uses a stringbuilder to create the result.
 */
public class EngToMorse {
    public void encode (String s){
        StringBuilder a = new StringBuilder();
        HashMap<Character,String> map = new HashMap<>();
        map.put('A' , ".-");
        map.put('B', "-...");
        map.put('C',"-.-.");
        map.put('D', "-..");
        map.put('E',".");
        map.put('F', "..-.");
        map.put('G',  "--.");
        map.put('H', "....");
        map.put('I',   "..");
        map.put('J', ".---");
        map.put('K',   "-.");
        map.put('L', ".-..");
        map.put('M',   "--");
        map.put('N',   "-.");
        map.put('O',  "---");
        map.put('P', ".--.");
        map.put('Q', "--.-");
        map.put('R', ".-.");
        map.put('S',  "...");
        map.put('T',   "-");
        map.put('U',  "..-");
        map.put('V', "...-");
        map.put('W',  ".--");
        map.put('X', "-..-");
        map.put('Y', "-.--");
        map.put('Z', "--..");
        map.put('1', ".----");
        map.put('2',"..---");
        map.put('3', "...--");
        map.put('4', "....-");
        map.put('5', ".....");
        map.put('6', "-....");
        map.put('7', "--...");
        map.put('8', "---..");
        map.put('9', "----.");
        map.put('0', "-----");
        String b = s.toUpperCase();
        char[] chars = b.toCharArray();
        for(char ch : chars){
            if(map.containsKey(ch)){
                //adds a space between
                a.append(map.get(ch)).append(" ");
            }
            //if a space add 3 spaces between words of morsecode
            if(ch == ' '){
                a.append("   ");
            }


        }
        System.out.println(a.toString());
    }
}
