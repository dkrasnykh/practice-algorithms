package chapter4;

public class FindMaximumSubarray2 {
    public int[] findMaximumSubarray(int[] a) {
        int maxSum = a[0];
        int imaxLeft = 0;
        int imaxRight = 0;
        int currentSum;
        int iLeft;
        int iRight;
        for (int i = 0; i < a.length - 1; i++) {
            currentSum = a[i];
            iLeft = i;
            iRight = i;
            if(currentSum > maxSum){
                maxSum = currentSum;
                imaxLeft = iLeft;
                imaxRight = iRight;
            }
            for (int j = i + 1; j < a.length; j++) {
                currentSum += a[j];
                iRight = j;
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    imaxLeft = iLeft;
                    imaxRight = iRight;
                }
            }
        }
        return new int[]{imaxLeft, imaxRight, maxSum};
    }
}
