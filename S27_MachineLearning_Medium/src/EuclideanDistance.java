public class EuclideanDistance {
    /**
     * Will compute the euclidean distance given an array of doubles.
     * If the arrays are not the same size will print an error.
     * @param v1 will take in a array of doubles.
     * @param v2 will take in a array of doubles.
     * @return will return a double that will be the euclidean distance.
     */
    public double Euclidean (double[] v1, double[] v2){
        double Euclidean = 0.0;
        if(v1.length != v2.length){
            System.out.println("Error, the arrays are not the same size");

        }
        else{
            for(int i = 0; i < v1.length; i++){
                Euclidean = Euclidean + Math.pow((v1[i] - v2[i]),2.0);
            }
            //System.out.println(Math.sqrt(Euclidean));
        }
        return Math.sqrt(Euclidean);
    }
}
