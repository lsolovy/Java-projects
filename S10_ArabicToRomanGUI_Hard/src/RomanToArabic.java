import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Arabic is a class with a method that will compute the Roman numeral to the Arabic integer
 * RtoA takes in a string of the roman numerals and will return a string of the Arabic integer
 * RtoA creates a map with the equivalent roman numerals to their respective integer
 * Will check to make sure the roman numeral that was entered is valid
 */
public class RomanToArabic {
    public String RtoA(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int last = map.get(roman.charAt(roman.length() - 1));
        System.out.println(last);
        //System.out.println(last);
        int current;
        int arabic = last;
        for(int i = roman.length()-2 ; i >= 0; i--) {
            System.out.println(i);
            current = map.get(roman.charAt(i));
            System.out.println(current);
            if (current < last) {
                arabic -= current;
            } else {
                arabic += current;
            }
            last = current;
        }
        //System.out.println(arabic);
        String arabic2 = Integer.toString(arabic);
        ArabicToRoman a = new ArabicToRoman();
        String compare = a.AtoR(arabic2);
        if(!roman.equals(compare)){
            System.out.println("Invalid");
            return "Invalid";
        }
        System.out.println(arabic2);
        return arabic2;

    }
    public static void main(String[] args) {
        RomanToArabic r = new RomanToArabic();
        r.RtoA("IV");
    }

}

