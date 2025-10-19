package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


 // StringCalculator 클래스에 대한 테스트 코드입니다.
 // 'null/빈 문자열 처리', '단일 숫자 반환', '쉼표 및 콜론 구분자 처리' 기능을 검증합니다.

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

    // 커스텀 구분자 및 예외 처리 테스트는 다음 단계에서 추가됩니다.
}