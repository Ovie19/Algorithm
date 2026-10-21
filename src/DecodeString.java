import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {


    public static String decodeString(String input) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int count = 0;

        for (char c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(current);
                current = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                int currentCount = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < currentCount; i++) {
                    previous.append(current);
                }
                current = previous;

            } else {
                current.append(c);
            }
        }

        return current.toString();
    }

//    public static String decodeString(String s) {
//        Deque<Integer> deque = new ArrayDeque<>();
//        StringBuilder sb = new StringBuilder(s);
//
//        for (int index = 0; index < sb.length(); index++) {
//            if (sb.charAt(index) == '[')
//                deque.push(index);
//
//            if (sb.charAt(index) == ']') {
//                int start = deque.pop();
//
//                int counterStart = start - 1;
//                StringBuilder counterBuilder = new StringBuilder();
//                while (counterStart >= 0 && Character.isDigit(sb.charAt(counterStart))) {
//                    counterBuilder.append(sb.charAt(counterStart));
//                    counterStart--;
//                }
//
//                int count = Integer.parseInt(counterBuilder.reverse().toString());
////                System.out.println(count);
////                multiplyString(sb, start - counterBuilder.length() + 1, index, count);
//                int digitStart = start - counterBuilder.length();
//                multiplyString(sb, digitStart, index, count);
//            }
//        }
//
//        if (!deque.isEmpty()) return decodeString(sb.toString());
//
//        return sb.toString();
//    }
//
////    private static void multiplyString(StringBuilder sb, int start, int end, int count) {
////        String sequence = sb.substring(start + 1, end);
////        StringBuilder result = new StringBuilder();
////
////        for (int i = 0; i < count; i++) {
////            result.append(sequence);
////        }
////
////        sb.replace(start - 1, end + 1, result.toString());
////    }
//    private static void multiplyString(StringBuilder sb, int digitStart, int end, int count) {
//        // digitStart is the first digit of the count
//        String sequence = sb.substring(digitStart + /* length of count */
//                String.valueOf(count).length() + 1, end);
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < count; i++) {
//            result.append(sequence);
//        }
//        sb.replace(digitStart, end + 1, result.toString());
//    }
}
