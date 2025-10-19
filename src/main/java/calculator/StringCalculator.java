package calculator;

public class StringCalculator {

    // 입력된 문자열을 분석하여 결과를 반환합니다.
    // 현재는 빈 문자열 또는 null이면 0을 반환합니다.

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표(,) 또는 콜론(:)을 구분자로 사용하여 문자열을 분리합니다.
        String[] numbers = splitInput(input);


        return 0;
    }

    // 입력 문자열을 구분자(쉼표 또는 콜론) 기준으로 분리하는 메서드
    private String[] splitInput(String input) {
        // 정규표현식 ",|:"를 사용하여 쉼표 또는 콜론으로 문자열을 분리
        return input.split(",|:");
    }
}
