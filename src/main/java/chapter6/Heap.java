package chapter6;

import java.util.Arrays;

/*
Пирамидальная сортировка
Кормен глава 6
*/
public class Heap {
    public static int parent(int i) {
        return i / 2;
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int l = left(i + 1) - 1;
        int r = right(i + 1) - 1;
        int largest;
        if (l < heapSize && a[l] > a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            maxHeapify(a, largest, heapSize);
        }
    }

    public static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }

    public static void heapsort(int[] a) {
        buildMaxHeap(a);
        System.out.println("построенная неубывающее дерево:");
        System.out.println(Arrays.toString(a));
        System.out.println("------------------------------------------");
        int heapSize = a.length;
        for (int i = a.length - 1; i >= 1; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSize--;
            maxHeapify(a, 0, heapSize);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        /*
        int[] a = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        maxHeapify(a, 1, a.length);
        System.out.println(Arrays.toString(a));
        */

        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapsort(a);
        System.out.println("------------------------------------------");
        System.out.println("Результат:");
        System.out.println(Arrays.toString(a));
    }
}
