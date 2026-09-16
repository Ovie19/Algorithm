import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "123a",
            "aabs",
            "a-bb",
            "1a1",
            "-+11",
            "123456789010203450607780990876715234124612"
    })
    void parse_invalidString_throwsIllegalArgumentException(String string) {
        assertThrows(
                IllegalArgumentException.class,
                () -> HugeInteger.parse(string)
        );
    }

    @Test
    void isEqualTo_sameNumericalValue_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("123");
        HugeInteger secondHugeInteger = HugeInteger.parse("000123");
        assertTrue(firstHugeInteger.isEqualTo(secondHugeInteger));
    }

    @Test
    void isNotEqualTo_differentNumericalValue_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("123");
        HugeInteger secondHugeInteger = HugeInteger.parse("1230");
        assertTrue(firstHugeInteger.isNotEqualTo(secondHugeInteger));
    }

    @Test
    void toString_returnsOriginalString() {
        HugeInteger firstHugeInteger = HugeInteger.parse("12300");
        String string = firstHugeInteger.toString();
        assertEquals("12300", string);
    }

    @Test
    void add_twoHugeIntegers_addsCorrectly() {
        HugeInteger firstHugeInteger = HugeInteger.parse("123");
        HugeInteger secondHugeInteger = HugeInteger.parse("321");

        HugeInteger expected = HugeInteger.parse("444");
        firstHugeInteger.add(secondHugeInteger);
        assertTrue(expected.isEqualTo(firstHugeInteger));
    }

    @Test
    void add_hugeIntegersWithDifferentLengths_addsCorrectly() {
        HugeInteger firstHugeInteger = HugeInteger.parse("3123");
        HugeInteger secondHugeInteger = HugeInteger.parse("321");

        HugeInteger expected = HugeInteger.parse("3444");
        firstHugeInteger.add(secondHugeInteger);
        assertTrue(expected.isEqualTo(firstHugeInteger));
    }

    @Test
    void add_hugeIntegersCausingCarry_addsCorrectly() {
        HugeInteger firstHugeInteger = HugeInteger.parse("123");
        HugeInteger secondHugeInteger = HugeInteger.parse("987");

        HugeInteger expected = HugeInteger.parse("1110");
        firstHugeInteger.add(secondHugeInteger);
        assertTrue(expected.isEqualTo(firstHugeInteger));
    }

    @Test
    void add_overflow_throwsIllegalArgumentException() {
        HugeInteger firstHugeInteger = HugeInteger.parse("9999999999999999999999999999999999999999");
        HugeInteger secondHugeInteger = HugeInteger.parse("1");
        assertThrows(IllegalArgumentException.class, () -> firstHugeInteger.add(secondHugeInteger));
    }

    @Test
    void isLessThan_smallerThanLarger_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("40000");
        HugeInteger secondHugeInteger = HugeInteger.parse("40001");
        assertTrue(firstHugeInteger.isLessThan(secondHugeInteger));
    }

    @Test
    void isLessThanOrEqualTo_smallerThanLarger_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("40000");
        HugeInteger secondHugeInteger = HugeInteger.parse("40001");
        assertTrue(firstHugeInteger.isLessThanOrEqualTo(secondHugeInteger));
    }

    @Test
    void isLessThanOrEqualTo_equalValues_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("40000");
        HugeInteger secondHugeInteger = HugeInteger.parse("40000");
        assertTrue(firstHugeInteger.isLessThanOrEqualTo(secondHugeInteger));
    }

    @Test
    void isGreaterThan_largerThanSmaller_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("41000");
        HugeInteger secondHugeInteger = HugeInteger.parse("40000");
        assertTrue(firstHugeInteger.isGreaterThan(secondHugeInteger));
    }

    @Test
    void isGreaterThanOrEqualTo_largerThanSmaller_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("41000");
        HugeInteger secondHugeInteger = HugeInteger.parse("40000");
        assertTrue(firstHugeInteger.isGreaterThanOrEqualTo(secondHugeInteger));
    }

    @Test
    void isGreaterThanOrEqualTo_equalValues_returnsTrue() {
        HugeInteger firstHugeInteger = HugeInteger.parse("4000");
        HugeInteger secondHugeInteger = HugeInteger.parse("4000");
        assertTrue(firstHugeInteger.isGreaterThanOrEqualTo(secondHugeInteger));
    }

    @Test
    void subtract_biggerFromSmaller_throwsIllegalArgumentException() {
        HugeInteger firstHugeInteger = HugeInteger.parse("123");
        HugeInteger secondHugeInteger = HugeInteger.parse("987");
        assertThrows(IllegalArgumentException.class, () -> firstHugeInteger.subtract(secondHugeInteger));
    }

    @Test
    void subtract_twoHugeIntegers_subtractsCorrectly() {
        HugeInteger firstHugeInteger = HugeInteger.parse("987");
        HugeInteger secondHugeInteger = HugeInteger.parse("123");

        HugeInteger expected = HugeInteger.parse("864");
        firstHugeInteger.subtract(secondHugeInteger);
        assertTrue(expected.isEqualTo(firstHugeInteger));
    }

    @Test
    void subtract_twoHugeIntegersRequiringBorrow_subtractsCorrectly() {
        HugeInteger firstHugeInteger = HugeInteger.parse("912");
        HugeInteger secondHugeInteger = HugeInteger.parse("167");

        HugeInteger expected = HugeInteger.parse("745");
        firstHugeInteger.subtract(secondHugeInteger);
        assertTrue(expected.isEqualTo(firstHugeInteger));
    }
}