import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        // call merge sort
        mergeSort(arr, 0, n-1); 
        // print result
        System.out.println("Sorted array:"); 
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            // find the middle
            int m = (l+r)/2;
            // sort the sub-arrays
            mergeSort(array, l, m);
            mergeSort(array, m+1, r);
            // merge the sorted sub-array
            merge(array, l, m, r);
        }
    }

    // 0, 1, 2, 3, 4, 5, 6
    private static void merge(int[] array, int l, int m, int r) {
        // find the sizes of the sub-arrays
        int n1 = m-l+1;
        int n2 = r-m;
        // init tmp arrays
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        // copy the sub-arrays
        for(int i = 0; i < n1; ++i)
            arr1[i] = array[l+i];
        for(int i = 0; i < n2; ++i)
            arr2[i] = array[m+1+i];
        // finally merge them
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                array[k] = arr1[i];
                ++i;
            } else {
                array[k] = arr2[j];
                ++j;
            }
            ++k;
        }
        // if there are elements left from arr1
        while(i < n1) {
            array[k] = arr1[i];
            ++i;
            ++k;
        }
        // if there are elements left from arr2
        while(j < n2) {
            array[k] = arr2[j];
            ++j;
            ++k;
        }
    }
}