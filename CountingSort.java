import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                    'r', 'g', 'e', 'e', 'k', 's'
                    };
        // call count sort
        countSort(arr);
        // print result
        System.out.println("Sorted array:"); 
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(char[] array) {
        int[] count = new int[256];
        // count the occurrences
        for(int i = 0; i < array.length; ++i) {
            count[array[i]]++;
        }
        // get the last position for every element
        for(int i = 1; i < 256; ++i)
            count[i] += count[i-1];
        // make a copy of the array
        char[] tmp = new char[array.length];
        System.arraycopy(array, 0, tmp, 0, array.length);
         // populate the result array
        for(int i = tmp.length-1; i >= 0; --i) {
            array[count[tmp[i]]-1] = tmp[i];
            --count[tmp[i]];
        }
    }
}