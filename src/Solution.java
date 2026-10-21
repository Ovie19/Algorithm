import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    static void main() {
        System.out.println(isValid("([)]"));
//        System.out.println(
//            findMedianSortedArrays(
//                new int[]{1, 3},
//                new int[]{2}
//            )
//        );
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char ch = stack.pop();
                switch (ch) {
                    case '(' -> {
                        if (c != ')')
                            return false;
                    }
                    case '[' -> {
                        if (c != ']')
                            return false;
                    }
                    case '{' -> {
                        if (c != '}')
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int middle = length / 2;
        int[] sortedNumbers = new int[length];
        int numIndex1 = 0;
        int numIndex2 = 0;
        int index = 0;

//        while (numIndex1 < nums1.length || numIndex2 < nums2.length) {
//            if (numIndex1 < nums1.length && nums1[numIndex1] < nums2[numIndex2]) {
//                sortedNumbers[index++] = nums1[numIndex1++];
//            } else {
//                sortedNumbers[index++] = nums2[numIndex2++];
//            }
//            System.out.println(Arrays.toString(sortedNumbers));
//        }

        while (index < length) {
            if (numIndex1 == nums1.length) {
                sortedNumbers[index++] = nums2[numIndex2++];
            } else if (numIndex2 == nums2.length) {
                sortedNumbers[index++] = nums1[numIndex1++];
            } else if (nums1[numIndex1] < nums2[numIndex2]) {
                sortedNumbers[index++] = nums1[numIndex1++];
            }  else {
                sortedNumbers[index++] = nums2[numIndex2++];
            }
        }

        if (length % 2 == 0) {
            double sum = sortedNumbers[middle] + sortedNumbers[middle - 1];
            return sum / 2;
        } else return sortedNumbers[middle];
    }
}