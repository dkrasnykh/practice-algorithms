package chapter4;

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


    }
}
