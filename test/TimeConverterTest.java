import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeConverterTest {

    @ParameterizedTest
    @CsvSource({
            "12:01:00PM, 12:01:00",
            "12:01:00AM, 00:01:00",
            "07:05:45PM, 19:05:45",
            "07:05:45AM, 07:05:45",
            "08:05:45PM, 20:05:45",
            "09:05:45PM, 21:05:45",
    })
    void convertTimeTest(String input, String expected) {
        assertEquals(expected, TimeConverter.convert(input));
    }
}