package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriorityQueue {
    public static class Structure {
        //int[] a;
        int size;

        List<Integer> values = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
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
        if (l < heap.size && heap.values.get(l) > heap.values.get(i)) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heap.size && heap.values.get(r) > heap.values.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            int temp = heap.values.get(i);
            heap.values.set(i, heap.values.get(largest));
            heap.values.set(largest, temp);
            /*
            heap.a[i] = heap.a[largest];
            heap.a[largest] = temp;
            */
            maxHeapify(heap, largest);
        }
    }

    public static int heapMaximun(Structure heap) {
        return heap.values.get(0);
    }

    public static int heapExtractMax(Structure heap) {
        if (heap.size < 1) {
            return -1;
        }
        int max = heap.values.get(0);
        heap.values.set(0, heap.values.get(heap.size - 1));
        //heap.a[0] = heap.a[heap.size - 1];
        heap.size--;
        maxHeapify(heap, 0);
        return max;
    }

    public static void maxHeapInsert(Structure heap, int key) {
        heap.size++;
        heap.values.add(Integer.MIN_VALUE);
        heapIncreaseKey(heap, heap.size-1, key);
    }

    public static void heapIncreaseKey(Structure heap, int i, int key) {
        if (key < heap.values.get(i)) {
            //ошибка
            return;
        }
        heap.values.set(i, key);
        while ((i > 0) && (heap.values.get(parent(i + 1) - 1) < heap.values.get(i))) {
            int temp = heap.values.get(i);
            heap.values.set(i, heap.values.get(parent(i + 1) - 1));
            heap.values.set(parent(i + 1) - 1, temp);
            i = parent(i + 1) - 1;
        }
    }

    public static void main(String[] args) {
        /*
        Structure heap = new Structure();
        heap.values.addAll(Arrays.asList(4, 1, 3, 2, 16, 9, 10, 14, 8, 7));
        heap.size = heap.values.size();

         */
        /*
        //тестирование maxHeapify
        Structure heap = new Structure();
        heap.values.addAll(Arrays.asList(16, 4, 10, 14, 7, 9, 3, 2, 8, 1));
        heap.size = heap.values.size();
        maxHeapify(heap, 1);
        System.out.println(heap.values);
        //Результат должен быть: 16, 14, 10, 8, 7, 9, 3, 2, 4, 1
        */
        //тестирование heapIncreaseKey
        Structure heap = new Structure();
        heap.values.addAll(Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1));
        heap.size = heap.values.size();
        heapIncreaseKey(heap, 8, 15);
        System.out.println(heap.values);
        //Результат должен быть: 16, 15, 10, 14, 7, 9, 3, 2, 8, 1
        maxHeapInsert(heap, 25);
        System.out.println(heap.values);

    }
}
