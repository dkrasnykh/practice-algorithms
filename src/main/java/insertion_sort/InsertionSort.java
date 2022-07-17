package insertion_sort;

import java.util.Arrays;

//Kormen, page 40
public class InsertionSort {
    public static int[] run(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};
        System.out.println(Arrays.toString(run(a)));
    }
}
