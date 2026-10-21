import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPalindromeTest {
    @ParameterizedTest
    @CsvSource({
            "race, racecar",
            "ab, aba",
            "aace, aacecaa",
            "banana, bananab",
            "abcd, abcdcba",
            "aabbaa, aabbaa"
    })
    void shortestPalindromeTest(String input, String expected) {
        assertEquals(expected, ShortestPalindrome.getShortestPalindrome(input));
    }
}