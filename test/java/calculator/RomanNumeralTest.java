package calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/romanToArabic.csv", delimiter = '=')
    void romanToArabic(String input, int expected) {
        assertEquals(expected, Solution.romanToArabic(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arabicToRoman.csv", delimiter = '=')
    void arabicToRoman(int input, String expected) {
        assertEquals(expected, Solution.arabicToRoman(input));
    }
}
