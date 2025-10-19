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

        // 모든 구분자가 통합된 로직을 사용하여 문자열을 분리합니다.
        String[] numbers = split(input);

        // 현재 단계는 분리 기능만 구현합니다.
        return 0;
    }

    // (커스텀 + 기본) 통합하여 처리하는 분리 로직
    public static String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{};
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (m.find()) {
            // 1. 커스텀 구분자 추출 및 통합 정규식 생성
            String customDelimiter = m.group(1);

            String regex = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);

            // 2. 숫자 문자열 추출 및 통합 정규식으로 분리
            String numbersToSplit = m.group(2);
            return numbersToSplit.split(regex);
        }

        // 3. 커스텀 패턴이 없을 경우, 기본 구분자로 분리
        return input.split(DEFAULT_DELIMITERS);
    }
}