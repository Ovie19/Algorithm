public class HighestConsecutiveNumber {

    public static int getHighestConsecutiveNumber(int[] numbers) {
        int count = 1;
        int maximumCount = 1;

        for (int index = 0; index < numbers.length - 1; index++) {
            if (numbers[index + 1] - numbers[index] == 1) {
                count++;
            } else {
                maximumCount = Math.max(maximumCount, count);
                count = 1;
            }
        }
        maximumCount = Math.max(maximumCount, count);

        return maximumCount;
//        int count = 1;
//        for (int outerIndex = 0; outerIndex < numbers.length; outerIndex++) {
//            for (int innerIndex = outerIndex + 1; innerIndex < numbers.length; innerIndex++) {
//                if (numbers[innerIndex] - numbers[innerIndex - 1] == 1) {
//                    count++;
//
//                    if (innerIndex == numbers.length - 1) {
//                        if (maximumCount < count) maximumCount = count;
//                        return maximumCount;
//                    }
//                } else {
//                    if (maximumCount < count) maximumCount = count;
//                    count = 1;
//                    break;
//                }
//            }
//        }
    }
}
