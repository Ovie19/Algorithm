public class StringEncoder {

    public static String getEncodedString(String input) {
        StringBuilder sb = new StringBuilder();

        char alphabet = input.charAt(0);
        int count = 1;

        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == alphabet)
                count++;
            else {
                sb.append(alphabet);
                sb.append(count);
                alphabet = input.charAt(index);
                count = 1;
            }

            if (index == input.length() - 1) {
                sb.append(alphabet);
                sb.append(count);
            }
        }

        return sb.toString();
    }
}
