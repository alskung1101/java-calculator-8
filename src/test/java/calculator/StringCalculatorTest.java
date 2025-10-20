package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("null 또는 빈 문자열을 입력하면 0을 반환한다.")
    void shouldReturnZeroForNullOrEmpty() {
        assertEquals(0, calculator.add(null));
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("숫자 하나만 입력할 경우 해당 숫자를 반환한다.")
    void shouldReturnTheNumberWhenSingleNumberIsInput() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열을 덧셈한다.")
    void shouldSumNumbersSeparatedByComma() {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(10, calculator.add("4,6"));
    }

    @Test
    @DisplayName("쉼표 또는 콜론으로 구분된 문자열을 덧셈한다.")
    void shouldSumNumbersSeparatedByCommaOrColon() {
        assertEquals(6, calculator.add("1,2:3"));
        assertEquals(10, calculator.add("5:5"));
    }

    // 분리 로직의 정확성을 검증하는 테스트
    @Test
    @DisplayName("커스텀 구분자 및 기본 구분자로 문자열 분리 배열을 정확하게 반환한다.")
    void shouldSupportCustomDelimiter() {
        // 커스텀 구분자 ';' 사용
        assertArrayEquals(new String[]{"1", "2", "3"}, StringCalculator.split("//;\n1;2;3"));
        // 커스텀 구분자 'k' 사용 및 기본 구분자 ':' 혼합
        assertArrayEquals(new String[]{"1", "5", "10", "20"}, StringCalculator.split("//k\n1:5k10:20"));
    }

    // [예외 처리] 숫자가 아닌 입력 시 예외 처리
    @Test
    @DisplayName("숫자가 아닌 문자열이 포함될 경우 IllegalArgumentException 발생")
    void shouldThrowExceptionForNonNumericInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,a:3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//;\n1;2;a");
        });
    }

    // [예외 처리] 음수 입력 시 예외 처리
    @Test
    @DisplayName("음수가 입력될 경우 IllegalArgumentException 발생")
    void shouldThrowExceptionForNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2:3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("//;\n-1;-2;3");
        });
    }
}