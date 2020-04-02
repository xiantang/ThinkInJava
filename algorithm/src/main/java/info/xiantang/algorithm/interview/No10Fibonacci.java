package info.xiantang.algorithm.interview;

class No10Fibonacci {
    static int fibonacciRecursive(int i) {
        if (i <= 1) {
            return i;
        }

        return fibonacciRecursive(i - 1) + fibonacciRecursive(i - 2);
    }

    static int fibonacciIteration(int i) {
        int[] fib = new int[i + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int j = 2; j <= i; j++) {
            fib[j] = fib[j - 1] + fib[j - 2];
        }

        return fib[i];
    }
}
