package christmas;

import christmas.domain.menuManage.OrderHistory;
import java.util.List;

public class Utils {
    public static final int maxOrderQuantity = 20;
    public static final int maxDate = 31;
    public static final int giftEventStandardPrice = 120000;

    public static int stringToIntConverting(String input, String validationContext) {
        try {
            int number = Integer.parseInt(input);
            isOkayNumber(number, validationContext);
            return number;
        } catch (NumberFormatException e) {
            throw checkNumberFormatException(validationContext);
        }
    }

    private static void isOkayNumber(int number, String validationContext) {
        if (validationContext.equals("dateException") && (number < 1 || number > maxDate)) {
            throw new IllegalArgumentException("[ERROR] 날짜는 1일에서 31일 사이의 정수여야 합니다.");
        } else if (validationContext.equals("quantityException") && (number < 1 || number > maxOrderQuantity)) {
            throw new IllegalArgumentException("[ERROR] 주문 수량은 1보다 크고 20보다 작아야 합니다.");
        }
    }

    private static IllegalArgumentException checkNumberFormatException(String validationContext) {
        if (validationContext.equals("dateException")) {
            return new IllegalArgumentException("[ERROR] 정수만 입력하세요.");
        } else if (validationContext.equals("quantityException")) {
            return new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }



    public static boolean isGiftEvent(List<OrderHistory> orders) {
        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();
        return totalBeforeDiscount >= giftEventStandardPrice;
    }

}
