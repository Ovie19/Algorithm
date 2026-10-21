import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

    public static int[] getMissingNumberWithIndex(int[] input) {
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int index = 1; index < input.length; index++) {
            if (input[index] - input[index - 1] != 1) {
                result.add(input[index] - 1);
                result.add(index + count);
                count++;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static Object getMissingNumber(int[] input) {
        List<Integer> result = new ArrayList<>();

        for (int index = 1; index < input.length; index++) {
            if (input[index] - input[index - 1] != 1) {
                result.add(input[index] - 1);
            }
        }

        if (result.size() == 1) return result.getFirst();
        return result.stream().mapToInt(x -> x).toArray();
    }
}
