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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        } else if (validationContext.equals("quantityException") && (number < 1 || number > maxOrderQuantity)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static IllegalArgumentException checkNumberFormatException(String validationContext) {
        if (validationContext.equals("dateException")) {
            return new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        } else if (validationContext.equals("quantityException")) {
            return new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }



    public static boolean isTotalQuantityExceeded(List<OrderHistory> orders) {
        int totalQuantity = orders.stream()
                .mapToInt(OrderHistory::getOrderQuantity)
                .sum();
        return totalQuantity > maxOrderQuantity;
    }

    public static boolean isGiftEvent(List<OrderHistory> orders) {
        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();
        return totalBeforeDiscount >= giftEventStandardPrice;
    }
}
