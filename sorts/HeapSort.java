package sorts;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        // call merge sort
        heapSort(arr); 
        // print result
        System.out.println("Sorted array:"); 
        System.out.println(Arrays.toString(arr));
    }
    
    public static void heapSort(int[] array) {
        // heapify array, starting from the last non-leaf node
        for(int i = (array.length/2)-1; i >= 0; --i) {
            heapify(array, i, array.length);
        }
        // sort array
        for(int i = array.length-1; i >= 0; --i) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            // heapify after removing the max
            heapify(array, 0, array.length);
        }
    }

    public static void heapify(int[] array, int i, int n) {
        int largest = i;
        // idx of left and right child
        int left = 2*i + 1;
        int right = 2*i + 2;
        // find the largest between the root and left or right child
        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;
        // if largest is not the root
        if (largest != i) {
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;
            // recursively heapify the affected sub-tree
            heapify(array, largest, n);
        }
    }
}