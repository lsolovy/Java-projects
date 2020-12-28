
import java.io.*;

import java.util.*;


public class NearestNeighbor {


    /**Will open the csv file and add the data to an array of string arrays.
     * Will compute distance of the given data point between the points in the file using the EuclideanDistance class.
     * Then will look at the k nearest points while keeping track of the counts for class1 and class2.
     * Will print which class (class1 or class2 from the csv) has more points closest.
     * @param file an input of the csv file path in a string.
     * @param dataPt an array of doubles that consist of the new data point.
     * @param k a double of the k distance looked at.
     */
    public void knearest (String file, double [] dataPt, double k){
        //looked up how to read in a csv file into an array
        //https://www.baeldung.com/java-csv-file-array
        //declared a array of string arrays
        List<List<String>> r = new ArrayList<>();
        String path = file;
        String line = "";
        EuclideanDistance euc = new EuclideanDistance();
        //proccessed file into r

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                // separate each line into array by commas
                String[] values = line.split(",");
                r.add(Arrays.asList(values));

            }
            // if file not found
        }  catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        HashMap<Double,Integer> distance = new HashMap<>();
        /*
         * key is distance, value is the index
         * calculate the distance between every point
         * then adding distance to the hashmap, keeping track of index
         * i is index of the point
         * j is the index of the points parameters
         */
        for(int i = 0; i < r.size(); i++){

            double[] currPoint = new double[5];
            for(int j = 0; j < 5; j++){
                //will go through each point and get the 5 coordinates casting them to a double
                //casting - converting string to a double
                //https://www.geeksforgeeks.org/double-parsedouble-method-in-java-with-examples/
                currPoint[j] = Double.parseDouble(r.get(i).get(j));

            }
            //calc distance and adding to hashmap
            double dist = euc.Euclidean(dataPt,currPoint);
            distance.put(dist,i);

        }
        //sorts map by key, key is the distance
        //used a treemap because they are sorted
        //https://www.baeldung.com/java-hashmap-sort
        Map<Double, Integer> map = new TreeMap<>(distance);
        //converts the sorted keys into an array so can iterate through them
        //getting generic object array from mapvalues
        Object[] keys = map.values().toArray();
        int class1 = 0;
        int class2 = 0;
        // will give the k nearest points while keeping count of the class
        for(int i =0;i < k; i++){
            //c will hold the class name of point
            //looked up substring becasue need to create a new string without quotes
            // "class1" --> class1
            //casting java object to integer
            String c = r.get((Integer) keys[i]).get(5);
            //System.out.println(c);
            c = c.substring(1,c.length()-1);
            //System.out.println(map);
            if(c.equals("class1")){
                class1+= 1;
            }
            else{
                class2+= 1;
            }
            if(class1 == class2){
                k += 1;
            }
        }
        if(class1 > class2){
            System.out.println("New data point belongs to class1");
        } else{
            System.out.println("New data point belongs to class2");
        }

    }


}

