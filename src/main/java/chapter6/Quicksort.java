package chapter6;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
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

    public static int randomizedPartition(int[] a, int p, int r) {
        Random generator = new Random();
        int i = p + generator.nextInt(r - p + 1);
        int temp = a[r];
        a[r] = a[i];
        a[i] = temp;
        return partition(a, p, r);
    }

    public static void randomizedQuicksort(int[] a, int p, int r){
        if(p<r){
            int q = randomizedPartition(a, p, r);
            randomizedQuicksort(a, p, q-1);
            randomizedQuicksort(a, q+1, r);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
        /*
        partition(a, 0, 7);
        System.out.println(Arrays.toString(a));
        */
        randomizedQuicksort(a, 0, 7);
        System.out.println(Arrays.toString(a));
    }
}
