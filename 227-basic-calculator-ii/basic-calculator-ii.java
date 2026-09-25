import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char lastOperation = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // Process operator or when reaching the end of the string
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (lastOperation == '+') {
                    stack.push(currentNumber);
                } else if (lastOperation == '-') {
                    stack.push(-currentNumber);
                } else if (lastOperation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (lastOperation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                lastOperation = c;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}