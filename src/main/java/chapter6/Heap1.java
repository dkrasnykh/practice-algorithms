package chapter6;

import java.util.Arrays;

public class Heap1 {
    public static class Structure {
        int[] a;
        int sizeHeap;
    }

    public static int parent(int i) {
        return i / 2;
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void maxHeapify(Structure heap, int i) {
        int l = left(i + 1) - 1;
        int r = right(i + 1) - 1;
        int largest;
        if (l < heap.sizeHeap && heap.a[l] > heap.a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heap.sizeHeap && heap.a[r] > heap.a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = heap.a[i];
            heap.a[i] = heap.a[largest];
            heap.a[largest] = temp;

            maxHeapify(heap, largest);
        }
    }

    public static void buildMaxHeap(Structure heap) {
        for (int i = heap.a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(heap, i);
        }
    }

    public static void heapsort(Structure heap) {
        buildMaxHeap(heap);
        System.out.println("построена неубывающая пирамида:");
        System.out.println(Arrays.toString(heap.a));
        System.out.println("------------------------------------------");

        for (int i = heap.a.length - 1; i >= 1; i--) {
            int temp = heap.a[0];
            heap.a[0] = heap.a[i];
            heap.a[i] = temp;
            heap.sizeHeap--;
            maxHeapify(heap, 0);
            System.out.println(Arrays.toString(heap.a));
        }
    }

    public static void main(String[] args) {
        Structure heap = new Structure();
        heap.a = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heap.sizeHeap = heap.a.length;

        heapsort(heap);
        System.out.println("------------------------------------------");
        System.out.println("Результат:");
        System.out.println(Arrays.toString(heap.a));
    }
}
