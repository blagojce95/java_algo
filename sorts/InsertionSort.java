package sorts;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        // call merge sort
        insertionSort(arr); 
        // print result
        System.out.println("Sorted array:"); 
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int array[]) {
        for(int i = 1; i < array.length; ++i) {
            // make the i-th element the key
            int key = array[i];
            // move every element that is larger than the key by one position
            int j = i - 1;
            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                --j;
            }
            // insert the key at the right place
            array[j+1] = key;
        }
    }
}