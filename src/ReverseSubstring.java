import java.util.*;

public class ReverseSubstring {
    public static String getReverseSubstring(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') stack.push(i);
            if (input.charAt(i) == ')') {
                int start = stack.pop();
                reverse(stringBuilder, start, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != '(' && stringBuilder.charAt(i) != ')') {
                sb.append(stringBuilder.charAt(i));
            }
        }

        return sb.toString();
    }

    private static void reverse(StringBuilder stringBuilder, int start, int end) {
        while (start < end) {
            char temp = stringBuilder.charAt(start);
            stringBuilder.setCharAt(start, stringBuilder.charAt(end));
            stringBuilder.setCharAt(end, temp);

            start++;
            end--;
        }
    }

//    public static String getReverseSubstring(String input) {
//        StringBuilder stringBuilder = new StringBuilder(input);
//
//        List<Integer> rightParenthesesIndexes = new ArrayList<>();
//        List<Integer> leftParenthesesIndexes = new ArrayList<>();
//        int parenthesesCount = 0;
//
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '(' || input.charAt(i) == ')') {
//                if (input.charAt(i) == '(') {
//                    leftParenthesesIndexes.add(i);
//                    parenthesesCount++;
//                }
//
//                if (input.charAt(i) == ')')
//                    rightParenthesesIndexes.add(i);
//            }
//        }
//
//        if (parenthesesCount == 0) return input;
//
//        int leftCount = leftParenthesesIndexes.size() - 1;
//        int rightCount = 0;
//        int difference = -1;
//
//        int start = leftParenthesesIndexes.get(leftCount);
//        int end = rightParenthesesIndexes.get(rightCount) - difference;
//
//        System.out.println(leftParenthesesIndexes);
//        System.out.println(rightParenthesesIndexes);
//        while (parenthesesCount > 0) {
//            System.out.println(stringBuilder.length());
//            String original = stringBuilder.substring(start, end);
//            String reversed = reverseParentheses(original);
//            stringBuilder.replace(start, end, reversed);
//
//            leftCount--;
//            rightCount++;
//            parenthesesCount--;
//
//           if (parenthesesCount > 0) {
//               difference += 2;
//               start = leftParenthesesIndexes.get(leftCount);
//               end = rightParenthesesIndexes.get(rightCount) - difference;
//           }
//        }
//
//        return stringBuilder.toString();
//    }
//
//    private static String reverseParentheses(String input) {
//        System.out.println(input);
//        StringBuilder sb = new StringBuilder();
//
//        int index = input.length() - 1;
//
//        while (index >= 0) {
//            if (input.charAt(index) != '(' && input.charAt(index) != ')') {
//                sb.append(input.charAt(index));
//            }
//            index--;
//        }
//
//        return sb.toString();
//    }
}
