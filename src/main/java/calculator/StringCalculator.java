package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 기본 구분자를 정규식 패턴으로 정의
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 커스텀 구분자를 추출하기 위한 패턴 정의
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = split(input);

        // 분리된 문자열을 검증하고 합산
        return calculateSumFromTokens(numbers);
    }

    // 모든 구분자를 통합하여 처리하는 분리 로직
    public static String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{};
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String regex = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
            String numbersToSplit = m.group(2);
            return numbersToSplit.split(regex);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    // 분리된 숫자 토큰들을 검증하고 합산하는 메서드 (예외 처리 포함)
    private int calculateSumFromTokens(String[] tokens) {
        int sum = 0;
        for (String numberString : tokens) {
            if (numberString.isEmpty()) {
                continue;
            }

            int number;
            try {
                // 숫자가 아닌 문자열이 포함될 경우 NumberFormatException 발생
                number = Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                // 숫자가 아닌 문자열 예외 처리
                throw new IllegalArgumentException("숫자가 아닌 문자열(" + numberString + ")이 포함되어 있습니다.");
            }

            // 음수일 경우 예외 처리
            if (number < 0) {
                throw new IllegalArgumentException("음수(" + number + ")는 입력할 수 없습니다.");
            }

            sum += number;
        }
        return sum;
    }
}