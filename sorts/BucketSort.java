package sorts;
import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        double arr[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(double array[]) {
        int n = array.length;
        // create the buckets
        DLL[] buckets = new DLL[n];
        // put every element in the corresponding bucket
        for(int i = 0; i < n; ++i) {
            double tmp = n * array[i];
            int b_i = (int)tmp;
            if (buckets[b_i] == null)
                buckets[b_i] = new DLL();
            buckets[b_i].insertLast(array[i]);
        }
        // sort every bucket
        for(int i = 0; i < n; ++i)
            if(buckets[i] != null)
                buckets[i].insertionSort();
        // insert back the elements to the array
        int k = 0;
        for(int i = 0; i < n; ++i) {
            if (buckets[i] != null) {
                Node head = buckets[i].head;
                while(head != null) {
                    array[k] = head.element;
                    ++k;
                    head = head.succ;
                }
            }
        }
    }
}

class DLL {
    Node head;
    Node tail;

    public void insertLast(double element) {
        if (head != null) {
        Node tmp = new Node(null, tail, element);
        tail.succ = tmp;
        tail = tmp;
        } else {
            head = tail = new Node(null, null, element);
        }
    }

    public void insertFirst(double element) {
        if ( head != null) {
        Node tmp = new Node(head, null, element);
        head.pred = tmp;
        head = tmp;
        } else {
            head = tail = new Node(null, null, element);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = head;
        while(curr != null) {
            sb.append(curr.element);
            if (curr.succ != null)
                sb.append(", ");
            curr = curr.succ;
        }
        sb.append("]");
        return sb.toString();
    }

    public void insertionSort() {
        // if there is no, or one element in the list
        if (head == null || head.succ == null)
            return;
        // start sorting
        Node i = head.succ;
        while(i != null) {
            // get the key element
            double key = i.element;
            // find the right position for the key element
            Node j = i.pred;
            while(j != null && j.element > key) {
                j.succ.element = j.element;
                j = j.pred;
            }
            if(j == null) {
               head.element = key;
            } else {
                j.succ.element = key;
            }
            // go to next element
            i = i.succ;
        }
    }
}

class Node {
    double element;
    Node succ, pred;

    Node(Node succ, Node pred, double element) {
        this.succ = succ;
        this.pred = pred;
        this.element = element;
    }
}