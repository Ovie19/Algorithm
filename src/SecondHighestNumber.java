public class SecondHighestNumber {

    public static int getSecondHighestNumber(int[] input) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int number : input) {
            if (number > highest) {
                secondHighest = highest;
                highest = number;
            }
            else if (number > secondHighest) secondHighest = number;
        }

        return secondHighest;
    }
}
