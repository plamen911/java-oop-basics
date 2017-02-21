package org.lynxlake._02Methods._06PrimeChecker;

class Number {
    public long number;
    public boolean prime;

    public Number(long number) {
        this.number = Math.abs(number);
        this.prime = this.isPrime(this.number);
    }

    public Number(long number, boolean prime) {
        this.number = Math.abs(number);
        this.prime = prime;
    }

    public Number getNextPrime() {
        long number = this.number;
        for (long i = this.number + 1; i < (this.number + 1) * 3; i++) {
            if (this.isPrime(i)) {
                number = i;
                break;
            }
        }

        return new Number(number, this.prime);
    }

    private boolean isPrime(long number) {
        boolean prime = true;
        for (int divider = 2; divider <= Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    @Override
    public String toString() {
        return String.format("%d, %b", this.number, this.prime);
    }
}
