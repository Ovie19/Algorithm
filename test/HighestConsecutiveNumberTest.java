import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestConsecutiveNumberTest {

    @Test
    void consecutiveNumberIsThreeTest() {
        int[] numbers = {1, 2, 5, 6, 7, 9};
        assertEquals(3, HighestConsecutiveNumber.getHighestConsecutiveNumber(numbers));
    }

    @Test
    void consecutiveNumberIsFourTest() {
        int[] numbers = {5, 6, 1, 2, 3, 4};
        assertEquals(4, HighestConsecutiveNumber.getHighestConsecutiveNumber(numbers));
    }

    @Test
    void justTestThisNigga() {
        int[] numbers = {2, 2, 3, 5, 6, 7, 8};
        assertEquals(4, HighestConsecutiveNumber.getHighestConsecutiveNumber(numbers));
    }

    @Test
    void noConsecutiveNumber_returnsOneTest() {
        int[] numbers = {2, 4, 6, 8, 10};
        assertEquals(1, HighestConsecutiveNumber.getHighestConsecutiveNumber(numbers));
    }

    @Test
    void allNumbersAreConsecutiveTest() {
        int[] numbers = {6, 7, 8, 9, 10};
        assertEquals(5, HighestConsecutiveNumber.getHighestConsecutiveNumber(numbers));
    }
}