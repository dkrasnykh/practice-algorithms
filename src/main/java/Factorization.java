import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factorization {
    static boolean isPrime(int n) {
        //O(sqrt(n))
        if (n == 1) {
            return false;
        }
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    static Map<Integer, Integer> factorization1(int n) {
        //List<Integer> primes = Eratosfen.eratosfenPrimes((int) Math.sqrt(n));
        List<Integer> primes = Eratosfen.eratosfenPrimes(n);
        Map<Integer, Integer> divisors = new HashMap<>();
        for (Integer prime : primes) {
            if (n % prime == 0) {
                int power = 0;
                while (n % prime == 0) {
                    n /= prime;
                    power++;
                }
                divisors.put(prime, power);
            }
        }
        if (n > 1) {
            divisors.put(n, 1);
        }
        return divisors;
    }

    public static void main(String[] args) {
        System.out.println(factorization1(60));
        System.out.println(isPrime(10));
    }
}
