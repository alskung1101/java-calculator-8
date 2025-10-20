package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // [최종] try-catch 블록이 없어야 합니다.
        // 예외가 발생하면 main 밖으로 던져져야 테스트가 성공합니다.
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add(input);

        // 성공한 경우에만 결과 출력
        System.out.println("결과 : " + result);
    }
}