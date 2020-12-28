
import java.util.HashMap;
/**
 * Class MorseToEng will decode morsecode into the equivalent english representation.
 * Uses a hashmap to locate the key and will get the value.
 * Uses a stringbuilder to create the result.
 */
public class MorseToEng {
    public void decode(String s){
        HashMap<String, Character> map = new HashMap<>();
        StringBuilder a = new StringBuilder();
        map.put(".-", 'A');
        map.put("-...", 'B');
        map.put("-.-.", 'C');
        map.put("-..", 'D');
        map.put(".", 'E');
        map.put("..-.", 'F');
        map.put("--.", 'G');
        map.put("....", 'H');
        map.put("..", 'I');
        map.put(".---", 'J');
        map.put("-.-", 'K');
        map.put(".-..", 'L');
        map.put("--", 'M');
        map.put("-.", 'N');
        map.put("---", 'O');
        map.put(".--.", 'P');
        map.put("--.-", 'Q');
        map.put(".-.", 'R');
        map.put("...", 'S');
        map.put("-", 'T');
        map.put("..-", 'U');
        map.put("...-", 'V');
        map.put(".--", 'W');
        map.put("-..-", 'X');
        map.put("-.--", 'Y');
        map.put("--..", 'Z');
        map.put("-----", '0');
        map.put(".----", '1');
        map.put("..---", '2');
        map.put("...--", '3');
        map.put("....-", '4');
        map.put(".....", '5');
        map.put("-....", '6');
        map.put("--...", '7');
        map.put("---..", '8');
        map.put("----.", '9');
        //split by word then letters
        String[] b = s.split("\\s{3}");
        for(String c :b ){
            for(String d : c.split("\\s")){
                if(map.containsKey(d)){
                    a.append(map.get(d));
                }
                else{
                    System.out.println("Error in Morsecode, symbol not defined");
                }
            }
            a.append(" ");
        }
        System.out.println(a.toString());
    }
}
