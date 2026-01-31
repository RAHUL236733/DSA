import java.util.*;

class Main {

    // Operator precedence
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    // Convert infix to postfix
    static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // Opening bracket
            else if (ch == '(') {
                st.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop(); // remove '('
            }
            // Operator
            else {
                while (!st.isEmpty() && precedence(ch) < precedence(st.peek())) {
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }

    // Convert infix to prefix
    static String infixToPrefix(String infix) {

        // Step 1: Reverse infix
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();

        // Step 2: Swap brackets
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }

        // Step 3: Infix to postfix
        String postfix = infixToPostfix(sb.toString());

        // Step 4: Reverse postfix
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String infix = "k+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}