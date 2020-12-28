public class HammingDistance {
    /**
     * Will compute the hamming distance between two string consisting of 0's and 1's.
     * If the the strings aren't the same it will print and error statement.
     * @param first will take in a string of 0's and 1's.
     * @param second will take in a string of 0's and 1's.
     * @return will return an interger of the hamming distance
     * Hamming distance is the number of positions at which the corresponding symbols (0's and 1's) are different.
     */
    public int Hamming(String first, String second){
        int count = 0;
        if(first.length() != second.length()){
            System.out.println("Error, strings are not the same size");
        }
        else{
            for(int i = 0; i < first.length(); i++){
                if(first.charAt(i) != second.charAt(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
        return count;
    }
}
