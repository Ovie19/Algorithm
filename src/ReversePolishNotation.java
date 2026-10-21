import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {

    public static int reverse(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "/" -> {
                    int number1 = stack.pop();
                    int number2 = stack.pop();
                    stack.push(number2 / number1);
                }
                case "*" -> {
                    int number1 = stack.pop();
                    int number2 = stack.pop();
                    stack.push(number1 * number2);
                }
                case "+" -> {
                    int number1 = stack.pop();
                    int number2 = stack.pop();
                    stack.push(number1 + number2);
                }
                case "-" -> {
                    int number1 = stack.pop();
                    int number2 = stack.pop();
                    stack.push(number2 - number1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
