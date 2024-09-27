package kata.primestreaming;

import java.util.concurrent.Callable;

public class PrimeCalculator implements Callable<Boolean> {

    private final Integer i;

    public PrimeCalculator(Integer i) {
        this.i = i;
    }

    @Override
    public Boolean call() {
        return Primes.isPrime(i);
    }
}
