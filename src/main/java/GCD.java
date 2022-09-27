public class GCD {
    //НОД
    private static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a >= b) {
            return gcd(a % b, b);
        } else {
            return gcd(a, b % a);
        }
    }

    private static int nok(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(25, 125));
        System.out.println(nok(25, 125));
    }
}
