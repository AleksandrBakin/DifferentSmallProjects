package masa.java.homework.factorial;

import java.math.BigInteger;
import java.util.Date;
import java.util.Stack;

public class FactorialFor {

    FactorialFor(int n) {
        Date start = new Date();
        String result = count(n).toString();
        Date finish = new Date();
        System.out.println("Fact " + n + " = " + result);
        System.out.println("Runtime of fact count in cycle = " + ( finish.getTime() - start.getTime() ) + " ms");
    }

    private BigInteger count (int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 2; i < n + 1; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}

