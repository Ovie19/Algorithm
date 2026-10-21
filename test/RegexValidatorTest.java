import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegexValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "p.nwakwo@native.semicolon.africa, true",
            "'p.nwakwo@native,semicolon,africa', false",
            "o.oladeji@semicolon.africa, false",
            "adetolabenjamin@gmail.com, false",
            "a.benjamin@native.semicolon.africa, true",
    })
    void validateEmailTest(String email, boolean expected) {
        assertEquals(expected, RegexValidator.isValidEmail(email));
    }

    @ParameterizedTest
    @CsvSource({
        "Password#1, true",
        "Pass#1, false",
        "Password1, false",
        "Password #1, false",
        "Password, false",
    })
    void validatePasswordTest(String password, boolean expected) {
        assertEquals(expected, RegexValidator.isValidPassword(password));
    }
}