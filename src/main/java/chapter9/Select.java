package chapter9;

import java.util.Random;

public class Select {
    public static int randomizedPartition(int[] a, int p, int r) {
        Random generator = new Random();
        int i = p + generator.nextInt(r - p + 1);
        int temp = a[r];
        a[r] = a[i];
        a[i] = temp;
        return partition(a, p, r);
    }

    public static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        return i + 1;
    }

    public static int randomizedSelect(int[] a, int p, int r, int i) {
        if (p == r) {
            return a[p];
        }
        int q = randomizedPartition(a, p, r);
        int k = q - p + 1;
        if (i == k) {
            return a[q];
        } else if (i < k) {
            return randomizedSelect(a, p, q - 1, i);
        } else {
            return randomizedSelect(a, q + 1, r, i - k);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 7, 1, 2, 5, 6, 4};
                //[1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(randomizedSelect(a, 0, 7, 3));
    }

}
