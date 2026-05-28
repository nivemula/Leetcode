class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // '+' sign
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }

            // '-' sign
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            // Opening bracket
            else if (ch == '(') {

                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Reset
                result = 0;
                sign = 1;
            }
            else if (ch == ')') {

                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * number;

        return result;
    }
}