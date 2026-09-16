import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondHighestNumberTest {

    @Test
    public void secondHighestNumber_allPositiveNumbersTest() {
        int[] input = {2, 7, 6, 8, 1};
        int actual = SecondHighestNumber.getSecondHighestNumber(input);
        assertEquals(7, actual);
    }

    @Test
    public void secondHighestNumber_allNegativeNumbersTest() {
        int[] input = {-2, -7, -6, -8, -1};
        int actual = SecondHighestNumber.getSecondHighestNumber(input);
        assertEquals(-2, actual);
    }

    @Test
    public void secondHighestNumber_positiveAndNegativeNumbersTest() {
        int[] input = {1, 2, -7, -6, -8, -1};
        int actual = SecondHighestNumber.getSecondHighestNumber(input);
        assertEquals(1, actual);
    }

    @Test
    public void test() {
        int[] input = {1, 0, -7, -6, -8, -1};
        int actual = SecondHighestNumber.getSecondHighestNumber(input);
        assertEquals(0, actual);
    }

    @Test
    public void testA() {
        int[] input = {2, 2, 2, 2, 2};
        int actual = SecondHighestNumber.getSecondHighestNumber(input);
        assertEquals(2, actual);
    }
}