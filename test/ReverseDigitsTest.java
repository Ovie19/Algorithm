import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseDigitsTest {

    @ParameterizedTest
    @CsvSource({
            "123, 321",
            "-123, -321",
            "120, 21",
            "-120, -21",
            "-2147483648, 0",
            "1534236469, 0"
    })
    void reverseDigitTest(int number, int expected) {
        assertEquals(expected, ReverseDigits.reverse(number));
    }
}