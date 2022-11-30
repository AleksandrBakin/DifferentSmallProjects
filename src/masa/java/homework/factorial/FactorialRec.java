package masa.java.homework.factorial;

import java.math.BigInteger;
import java.util.Date;

public class FactorialRec {
    FactorialRec(int n) {
        Date start = new Date();
        String result = count(new BigInteger(String.valueOf(n))).toString();
        Date finish = new Date();
        System.out.println("Fact " + n + " = " + result);
        System.out.println("Runtime of fact count rec = " + ( finish.getTime() - start.getTime() ) + " ms");
    }

    private BigInteger count (BigInteger n) {
        if (n.equals(new BigInteger("1"))) {
            return new BigInteger("1");
        } else {
            return n.multiply(count(n.subtract(new BigInteger("1"))));
        }
    }
}
