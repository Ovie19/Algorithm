//Create a class HugeInteger which uses a 40-element array of digits to
//store integers as large as 40 digits each. Provide methods parse, toString, add and subtract. Method
//parse should receive a String, extract each digit using method charAt and place the integer
//equivalent of each digit into the integer array. For comparing HugeInteger objects, provide the following
//methods: isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo
//and isLessThanOrEqualTo. Each of these is a predicate method that returns true if the relationship
//holds between the two HugeInteger objects and returns false if the relationship does not hold. Provide a
//predicate method isZero. If you feel ambitious, also provide methods multiply, divide and
//remainder. [Note: Primitive boolean values can be output as the word “true” or the word “false” with
//format specifier %b.]

import java.util.Arrays;

public class HugeInteger {

    private final int[] numbers = new int[40];

    public static HugeInteger parse(String string){
        boolean isInvalidString = string == null || !string.matches("^[0-9]+$") || string.length() > 40;
        if (isInvalidString) throw new IllegalArgumentException("Invalid string");

        HugeInteger hugeInteger = new HugeInteger();
        int currentIndex = 39;

        for (int index = string.length() - 1; index >= 0; index--) {
            hugeInteger.numbers[currentIndex] = Character.getNumericValue(string.charAt(index));
            currentIndex--;
        }
        return hugeInteger;
    }

    public String toString(){
        int startIndex = 0;
        while (numbers[startIndex] == 0) startIndex++;

        StringBuilder builder = new StringBuilder();
        for (int index = startIndex; index < numbers.length; index++)
            builder.append(numbers[index]);

        return builder.toString();
    }

    public void add(HugeInteger hugeInteger){
        int remainder = 0;
        for (int index = numbers.length - 1; index >= 0; index--) {
            int sum = numbers[index] + hugeInteger.numbers[index] + remainder;
            numbers[index] = sum % 10;
            remainder = sum / 10;
        }
        if (remainder != 0) throw new IllegalArgumentException("Overflow Error");
    }

    public void subtract(HugeInteger hugeInteger){
        if (isLessThan(hugeInteger)) throw new IllegalArgumentException("Input is greater than the number");

        int carry = 0;
        for (int index = numbers.length - 1; index >= 0; index--) {
            int digitOne = numbers[index] - carry;
            int digitTwo = hugeInteger.numbers[index];

            if (digitOne < digitTwo) {
                digitOne += 10;
                carry = 1;
            } else carry = 0;

            numbers[index] = digitOne - digitTwo;
        }
    }

    public boolean isEqualTo(HugeInteger hugeInteger){
        return compareTo(hugeInteger) == 0;
    }

    public boolean isNotEqualTo(HugeInteger hugeInteger){
        return compareTo(hugeInteger) != 0;
    }

    public boolean isGreaterThan(HugeInteger hugeInteger){
        return compareTo(hugeInteger) > 0;
    }

    public boolean isLessThan(HugeInteger hugeInteger){
        return compareTo(hugeInteger) < 0;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger hugeInteger){
        return compareTo(hugeInteger) >= 0;
    }

    public boolean isLessThanOrEqualTo(HugeInteger hugeInteger){
        return compareTo(hugeInteger) <= 0;
    }

    private int compareTo(HugeInteger hugeInteger) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != hugeInteger.numbers[index])
                return numbers[index] - hugeInteger.numbers[index];
        }
        return 0;
    }
}
