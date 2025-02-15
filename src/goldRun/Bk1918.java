package goldRun;

import java.util.*;
import java.io.*;

public class Bk1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] word = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(c);
            }


        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    public static int priority(char c) {
        if (c == '(' || c == ')') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (c == '/' || c == '*') {
            return 2;
        }
        return -1;
    }
}
