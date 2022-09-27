package chapter4;

import java.util.Arrays;

public class FindMaximumSubarray {
    public static int[] findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int left_sum = -Integer.MAX_VALUE;
        int sum = 0;
        int max_left = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = -Integer.MAX_VALUE;
        sum = 0;
        int max_right = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        return new int[]{max_left, max_right, left_sum + right_sum};
    }

    public static int[] findMaximumSubarray(int[] a, int low, int high) {
        if (high == low) {
            //базовый случай: только один элемент
            return new int[]{low, high, a[low]};
        } else {
            int mid = (low + high) / 2;
            int[] left = findMaximumSubarray(a, low, mid);
            int[] right = findMaximumSubarray(a, mid + 1, high);
            int[] cross = findMaxCrossingSubarray(a, low, mid, high);
            int left_sum = left[2];
            int right_sum = right[2];
            int cross_sum = cross[2];
            if (left_sum >= right_sum && left_sum >= cross_sum) {
                return left;
            } else if (right_sum >= left_sum && right_sum >= cross_sum) {
                return right;
            } else {
                return cross;
            }
        }
    }

    public static void main(String[] args) {
        //int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] a = {-7, 2, -2, 7, -2};
        System.out.println(Arrays.toString(findMaximumSubarray(a, 0, a.length-1)));

        int[] b = {-1, -3, -5, -7, -8, -13, -15};
        System.out.println(Arrays.toString(findMaximumSubarray(b, 0, b.length-1)));
    }
}
