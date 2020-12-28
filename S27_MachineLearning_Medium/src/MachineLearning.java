/**
 * Will run the method of knearest in NearestNeighbor class.
 * sets the first parameter to the path of the csv file.
 * sets the second parameter to a new data point.
 * sets the third parameter to the distance looking for neighbors.
 */
public class MachineLearning {
    public static void main(String[] args){
        String path = "/iahome/l/ls/lsolovy/IdeaProjects/lsolovy_swd/oral_exam1/S27_MachineLearning_Medium/S27-MLMedium.csv";
        NearestNeighbor e = new NearestNeighbor();
        double[] point1 = {1.5,3.5,2,2,8};
        double[] point2 = {3,3,2,2,1};
        int k = 5;
        e.knearest(path,point1,k);
        e.knearest(path,point2,k);

    }
}

