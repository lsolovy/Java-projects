/**
 * Class MergeSort will use the algorithm of mergesort to sort an array
 */
public class MergeSort {
    /**
     * The method mergehelper will create two sub arrays to be merged
     * @param arr array that is used for the process
     * @param low the smallest index
     * @param middle the middle index
     * @param high the greatest index
     */
    public void mergehelper(int[] arr,int low, int middle, int high){
        int a = middle - low + 1;
        int b = high - middle;
        int[] firsthalf = new int[a];
        int[] secondhalf = new int[b];

        for(int i = 0; i < a; i++){
            firsthalf[i] = arr[low + i];
        }

        for(int i = 0; i < b; i++){
            secondhalf[i] = arr[middle + 1 + i];
        }
        // merging arrays
        int i = 0 , j = 0;
        while(i < a && j < b){
            if(firsthalf[i] <= secondhalf[j]){
                arr[low] = firsthalf[i];
                i++;
            }
            else{
                arr[low] = secondhalf[j];
                j++;
            }
            low++;
        }
        while(i < a){
            arr[low] = firsthalf[i];
            i++;
            low++;
        }

        while(j < b){
            arr[low] = secondhalf[j];
            j++;
            low++;
        }
    }

    /**
     * Merging will merge the two sub arrays to be sorted.
     * Will call merging on first halve then second, and then use mergehelper to sort the two halves.
     * @param arr array that is used for the process
     * @param low smallest index
     * @param high greatest index
     */
    public void merging(int[] arr,int low, int high){
        if(low < high){
            int middle = (low + high)/2;
            merging(arr,low,middle);
            merging(arr,middle + 1, high);
            mergehelper(arr,low,middle,high);
        }
    }
}