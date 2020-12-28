import java.util.HashMap;

import java.util.TreeMap;

/**
 * ArabicToRoman is a class with a method that will compute the roman numeral from an integer
 * AtoR will take in a string of the integer and will return a string of the roman numerals
 * AtoR creates a Hashmap with the equivalent roman numerals to their respective integer
 */

public class ArabicToRoman {
    public static String AtoR (String num){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        //use of treemap to sort out hashmap
        TreeMap<Integer, String> sortmap = new TreeMap<Integer, String>(map);
        sortmap.putAll(map);
        StringBuilder roman = new StringBuilder();
        int num1 = Integer.parseInt(num);
        while(num1 > 0){
            //https://www.geeksforgeeks.org/treemap-floorkey-in-java-with-examples/
            //floorkey return the greatest key less than or equal to given key from the parameter.
            int a = sortmap.floorKey(num1);
            roman.append(map.get(a));
            num1 = num1 - a;
        }
        return roman.toString();

    }
    /*public static void main(String[] args) {
       ArabicToRoman r = new ArabicToRoman();
        r.AtoR("123");
    }*/


}

