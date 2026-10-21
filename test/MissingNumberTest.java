import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {
    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 5, 6}, new int[]{3, 2}),
                Arguments.of(new int[]{4, 5, 6, 8, 10}, new int[]{7, 3, 9, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void getMissingNumberAndItsIndexTest(int[] input, int[] expected) {
        int[] result = MissingNumber.getMissingNumberWithIndex(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void getMissingNumberTest() {
        int[] input = new int[]{1, 2, 4, 5, 6};
        Integer expected = 3;
        Integer actual = (Integer) MissingNumber.getMissingNumber(input);
        assertEquals(expected, actual);
    }

    @Test
    void getMissingNumberTestAgain() {
        int[] input = new int[]{4, 5, 6, 8, 10};
        int[] expected = new int[]{7, 9};
        int[] actual = (int[]) MissingNumber.getMissingNumber(input);
        assertArrayEquals(expected, actual);
    }
}