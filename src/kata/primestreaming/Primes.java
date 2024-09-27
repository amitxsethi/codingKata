package kata.primestreaming;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import static java.lang.Math.sqrt;

public class Primes {

    public static IntStream stream() {
        return IntStream.range(2, Integer.MAX_VALUE).filter(Primes::isPrime);
    }

    public static boolean isPrime(final int x) {
        if (x == 2 || x == 3) {
            return true;
        }


        if(x % 2 ==0 || x % 3 == 0) {
            return false;
        }


        for (int i = 5; i <= sqrt(x); i = i+6) {
            if (x % i == 0 || x % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }


}
