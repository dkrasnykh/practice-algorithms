package chapter6;

import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] a, int[] b, int k) {
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = 0;
        }
        for (int j = 0; j < a.length; j++) {
            c[a[j]] = c[a[j]] + 1;
        }
        //сейчас c[i] содержит количество элементов, равных i
        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }
        //сейчас c[i] содержит количество элементов, не превышающих i
        for (int j = a.length - 1; j >= 0; j--) {
            b[c[a[j]]-1] = a[j];
            c[a[j]] = c[a[j]] - 1;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] b = new int[8];
        sort(a, b, 6);
        System.out.println(Arrays.toString(b));
    }
}
