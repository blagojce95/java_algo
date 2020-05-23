package sorts;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        // call quick sort
        sort(arr, 0, n-1);
        // print result
        System.out.println("Sorted array:"); 
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] array, int r, int l) {
        if (r < l) {
            // partition the array and find the index of the pivot
            int pivot_idx = partition(array, r, l);
            // Recursively sort
            sort(array, r, pivot_idx-1);
            sort(array, pivot_idx+1, l);
        }
    }

    public static int partition(int[] array, int r, int l) {
        int pivot = array[l];
        // idx of smallest element
        int i = r;
        for(int j = r; j < l; ++j) {
            // if the element is smaller than pivot, chase it to the front
            if(array[j] < pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                ++i;
            }
        }
        // put the pivot in the right spot
        int tmp = array[i];
        array[i] = array[l];
        array[l] = tmp;
        // return the index of the pivot
        return i;
    }
}