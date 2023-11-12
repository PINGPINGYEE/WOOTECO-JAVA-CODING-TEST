package christmas;

public class Utils {
    public static int stringToIntConverting(String input) {
        try {
            int date = Integer.parseInt(input);

            // 날짜가 1~31일 범위 내에 있는지 확인
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("[ERROR] 날짜는 1일에서 31일 사이의 정수여야 합니다.");
            }

            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력하세요.");
        }
    }
}
