import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Class Main is for demonstrating how mergesort works.
 * It will generate an array of 100 integers that are random from 0 -100.
 * Then will print the original array before calling mergesort.
 * Will then print the sorted array.
 */
public class Main {
    public static void main(String[] args) {
        SecureRandom randomNumber = new SecureRandom();
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            int value = randomNumber.nextInt(1001);
            arr[i] = value;

        }
        System.out.println(Arrays.toString(arr));
        MergeSort m = new MergeSort();
        m.merging(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
