import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        // call radix sort
        radixSort(arr); 
        // print result
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] array) {
        // find the max value
        int max = array[0];
        for(int i = 0; i < array.length; ++i) {
            max = Math.max(array[i], max);
        }
        // call countSort as many time as there are digits in the max element
        for(int i = 1; max/i > 0; i*=10) {
            countSort(array, i);
        }
    }

    private static void countSort(int[] array, int exp) {
        // count the occurences
        int[] count = new int[10];
        for(int i = 0; i < array.length; ++i) {
            ++count[ (array[i]/exp)%10 ];
        }
        // get the last position in the result for every element
        for(int i = 1; i < 10; ++i)
            count[i] += count[i-1];
        // build the output array
        int[] output = new int[array.length];
        for(int i = array.length-1; i >= 0; --i) {
            output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            --count[ (array[i]/exp)%10 ];
        }
        // copy the result to array
        System.arraycopy(output, 0, array, 0, array.length);
    }
}