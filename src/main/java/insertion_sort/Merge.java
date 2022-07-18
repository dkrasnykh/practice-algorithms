package insertion_sort;

import java.util.Arrays;

public class Merge {
    public static int[] merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = a[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
        return a;
    }

    public static int[] mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 5, 7, 1, 2, 3, 6, 1,  0};
        //System.out.println(Arrays.toString(merge(a, 9, 12, 16)));
        System.out.println(Arrays.toString(mergeSort(a, 9, 17)));
    }
}
