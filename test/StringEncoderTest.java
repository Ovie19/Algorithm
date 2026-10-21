import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringEncoderTest {

    @ParameterizedTest
    @CsvSource({
            "aaaabbbccd, a4b3c2d1",
            "aaabbaa, a3b2a2"
    })
    void testEncodeString(String input, String expected) {
        assertEquals(expected, StringEncoder.getEncodedString(input));
    }
}