import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseSubstringTest {

    @ParameterizedTest
    @CsvSource({
            "(abcd), dcba",
            "(u(love)i), iloveu",
            "(ed(et(oc))el), leetcode",
            "a(bcdefghijkl(mno)p)q, apmnolkjihgfedcbq",
            "yasstgs, yasstgs",
            "ta()usw((((a)))), tauswa"
    })
    void testReverseSubstring(String input, String expected) {
        assertEquals(expected, ReverseSubstring.getReverseSubstring(input));
    }
}