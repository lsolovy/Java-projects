public class CosineSimilarity {
    /**
     * Will compute the cosine similarity two array of doubles from the given equation.
     * If the arrays are not the same size will print an error.
     * @param v1 will take in a array of doubles.
     * @param v2 will take in a array of doubles.
     * @return will return a double of the cosine similarity.
     */
    public double Cosine(double[] v1, double[] v2){

        double dotProduct = 0.0;
        double distance1 = 0.0;
        double distance2 = 0.0;
        double Cosine = 0.0;
        if(v1.length != v2.length){
            System.out.println("Error, arrays are not the same size");
        }
        else{
            for(int i = 0; i < v1.length; i++){
                dotProduct += v1[i] * v2[i];
                distance1 += Math.pow(v1[i], 2);
                distance2 += Math.pow(v2[i], 2);
            }
            distance1 = Math.sqrt(distance1);
            distance2 = Math.sqrt(distance2);

            if(distance1 != 0.0  ||  distance2 != 0.0){
                Cosine = dotProduct / (distance1*distance2);
            }
            else{
                Cosine = 0.0;
            }
            System.out.println(Cosine);
        }
        return Cosine;
    }
}
