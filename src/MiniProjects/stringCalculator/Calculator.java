package MiniProjects.stringCalculator;

public class Calculator {
    private String tokens [];
    private int index;

    /**
     E -> T + E | T - E | T
     T -> F * T | F / T | M
     M -> -F | F
     F -> (E) | N
     */

    public static void main(String[] args) {
        String expr = "1 + ( 2 * ( 3 - 4 + 8 / 9 ) + 6 ) / 7";
        Calculator calculator = new Calculator(expr);
        System.out.println("My result: " + expr + "=" + calculator.calculate());
        System.out.println("Check: " + expr + "=" + (1 + ( 2 * ( 3 - 4 + 8 / 9.0 ) + 6 ) / 7.0));
    }

    public Calculator (String expr){
        this.tokens =  expr.split(" ");
        this.index = 0;
    }

    public double calculate () {
        double first = multiply();
        while (index < tokens.length) {
            String operator = tokens[index];
            if (!"+".equals(operator) && !"-".equals(operator)){
                break;
                //throw new IllegalArgumentException("Неизвестный оператор в методе " + Thread.currentThread().getStackTrace()[1].getMethodName());
            }else {
                index++;
            }
            double second = multiply();
            if ("+".equals(operator)){
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    public double multiply () {
        double first = factor();
        while (index < tokens.length) {
            String operator = tokens[index];
            if (!"*".equals(operator) && !"/".equals(operator)){
                break;
                //throw new IllegalArgumentException("Неизвестный оператор в методе " + Thread.currentThread().getStackTrace()[1].getMethodName());
            }else {
                index++;
            }
            double second = factor();
            if ("*".equals(operator)){
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    public double factor () {
        String next = tokens[index];
        double result;
        if ("(".equals(next)){
            index++;
            result = calculate();
            String closingBracket;
            if (index < tokens.length){
                closingBracket = tokens[index];
            } else {
                throw new IllegalArgumentException("Некорректное завершение выражения в методе " + Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            if (")".equals(closingBracket)){
                index++;
                return result;
            } else {
                throw new IllegalArgumentException("Не найден символ ) в методе " + Thread.currentThread().getStackTrace()[1].getMethodName());
            }
        }
        index++;
        return Double.parseDouble(next);
    }
}
