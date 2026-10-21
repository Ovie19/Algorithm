public class ShortestPalindrome {
    public static String getShortestPalindrome(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        int currentIndex = 0;

        while (!isPalindrome(stringBuilder.toString())) {
            stringBuilder.insert(input.length(), input.charAt(currentIndex++));
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String input) {
        return new StringBuilder(input).reverse().toString().equals(input);
    }
}
