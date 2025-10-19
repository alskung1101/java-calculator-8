package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("null 또는 빈 문자열을 입력하면 0을 반환한다.")
    void shouldReturnZeroForNullOrEmpty() {
        // null 입력
        assertEquals(0, calculator.add(null), "null 입력 시 0을 반환해야 합니다.");

        // 빈 문자열 입력
        assertEquals(0, calculator.add(""), "빈 문자열 입력 시 0을 반환해야 합니다.");


    }


}