package masa.java.hackerRancked;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String []argh) throws IOException {
        Scanner sc = new Scanner(new File("/Users/aleksandrbakin/Java/JavaProjects/DifferentProjects/src/masa/java/hackerRancked/TestFile"));
        Map<Character,Character> balance = new HashMap<>();
        balance.put('{', '}');
        balance.put('(', ')');
        balance.put('[', ']');

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            Stack<Character> myStack = new Stack<>();
            char[] nextString = input.toCharArray();
            for (char c : nextString) {
                if(myStack.isEmpty()) {
                    myStack.push(c);
                    continue;
                }
                if((balance.containsKey(myStack.peek())) && (c == balance.get(myStack.peek()))) {
                    myStack.pop();
                    continue;
                }
                myStack.push(c);
            }
            if(myStack.isEmpty()) System.out.println("true");
            else System.out.println("false");
        }

    }
}
