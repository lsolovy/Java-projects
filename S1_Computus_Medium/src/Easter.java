import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * The class that includes main methods. One that will compute the day that
 * easter falls on. The second one will print the day that easter falls on.
 * And the third will compute and print the days that easter falls on in an
 * entire cycle.
 */
public class Easter {
    /**
     *
     */
    public Easter(int year) {
        this.year = year;
    }

    /**
     * used in the class to keep track of the month
     */
    private String month;
    /**
     * used in the class to keep track of the day
     */
    private int day ;
    /**
     * used in the class to keep track of the year
     */
    private int year;

    /**
     * will set the year to the year given
     */
    public void setYear (int year){
        this.year = year;
    }


    /**
     * Will compute the day that easter falls on using the algorithm
     * found by Meeus/Jones/Butcher Gregorian.
     */
    public void easterCalc (){
        int a,b,c,d,e,f,g,h,i,k,l,m,monthnum;
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b + 8) / 25;
        g = (b - f + 1) / 3;
        h = ((19*a) + b - d - g + 15) % 30;
        i = c / 4;
        k = c % 4;
        l = (32 + (2*e) + (2*i) - h - k) % 7;
        m = (a + (11*h) + (22*l)) / 451;
        monthnum = (h + l - (7*m) + 114) / 31;
        day = ((h + l - (7*m) + 114) % 31) + 1;

        if(monthnum < 3 || monthnum > 4){
            //throw new IllegalArgumentException("Error");
            System.out.println( "error");
        }
        else if(monthnum == 3){
            month = "March";
        }
        else if(monthnum == 4){
            month = "April";
        }
        //String month = (month == 3 ? "March" : "April");

    }

    /**
     * Will print out the day that easter is on.
     */
    public void printEaster(){
        System.out.println(month + " " + day + " , " + year);
    }

    /**
     * Will compute all the days that easter falls on in an entire cycle.
     * Will keep count of each day that easter falls on and print them out.
     * Uses a hashmap to keep track of the day and month.
     */
    public void cycle (){
        HashMap<Pair<Integer,Integer>, Integer> saveEaster = new HashMap<>();
        year = 0;
        for(int i = 0; i < 5700000; i++){
           easterCalc();
           Pair j = new Pair(day, month);
           if(saveEaster.containsKey(j)){
               saveEaster.replace(j,saveEaster.get(j)+1);
           }
           else{
               saveEaster.put(j,1);
           }
           year = year + 1;
        }
        for(Map.Entry<Pair<Integer,Integer>, Integer> medium: saveEaster.entrySet()){
            System.out.println(medium.getKey() + " " + medium.getValue());
        }

    }



}
