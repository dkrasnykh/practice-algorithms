public class BinaryExponentation {
    static long binPow(long base, long power) {
        if (power == 0) return 1;
        if (power % 2 == 0) {
            long half = binPow(base, power / 2);
            System.out.println("base: " + base + "; power: " + power);
            System.out.println("return half*half : " + half * half);
            return half * half;
        } else {
            long prev = binPow(base, power - 1);
            System.out.println("base: " + base + "; power: " + power);
            System.out.println("return prev*base : " + prev * base);
            return prev * base;
        }
    }

    static long binPow(long base, long power, long modulo){
        if (power == 0) return 1;
        if (power % 2 == 0) {
            long half = binPow(base, power / 2);
            System.out.println("base: " + base + "; power: " + power);
            System.out.println("return half * half % modulo : " + half * half % modulo);
            return half * half % modulo;
        } else {
            long prev = binPow(base, power - 1);
            System.out.println("base: " + base + "; power: " + power);
            System.out.println("return prev*base % modulo : " + prev * base % modulo);
            return prev * base % modulo;
        }
    }

    public static void main(String[] args) {
        long res = binPow(2, 8);
        System.out.println(res);
        long res1 = binPow(2, 8, 10);
        System.out.println(res1);
    }
}
