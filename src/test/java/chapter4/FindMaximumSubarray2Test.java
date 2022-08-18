package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindMaximumSubarray2Test {

    @Test
    public void findMaximumSubarray() {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] expected = {7, 10, 43};
        FindMaximumSubarray2 instance = new FindMaximumSubarray2();
        int[] actual = instance.findMaximumSubarray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findMaximumSubarrayNegativeValues(){
        int[] b = {-1, -3, -5, -7, -8, -13, -15};
        int[] expected = {0, 0, -1};
        FindMaximumSubarray2 instance = new FindMaximumSubarray2();
        int[] actual = instance.findMaximumSubarray(b);
        assertArrayEquals(expected, actual);
    }
}