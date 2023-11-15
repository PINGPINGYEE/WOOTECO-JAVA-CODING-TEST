package christmas.domain.discountManage;

import christmas.domain.dateManage.Day;
import christmas.domain.dateManage.StarDates;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class DiscountCalcuator {
    public static int calculateChristmasDdayDiscount(int date) {
        if (date > 25) {
            return 0;
        }
        return 1000 + 100 * (date - 1);
    }

    public static int calculateSpecialDiscount(int date) {
        if (StarDates.isSpecialDiscountDay(date)) {
            return 1000;
        }
        return 0;
    }

    public static int calculateWeekdayDiscount(Day day, List<OrderHistory> orders) {
        if (day.isWeekday()) {
            return orders.stream()
                    .filter(l -> l.getMenu().isDessertMenu())
                    .mapToInt(OrderHistory::getOrderQuantity)
                    .sum() * 2023;
        }
        return 0;
    }

    public static int calculateWeekendDiscount(Day day, List<OrderHistory> orders) {
        if (day.isWeekend()) {
            return orders.stream()
                    .filter(l -> l.getMenu().isMainMenu())
                    .mapToInt(OrderHistory::getOrderQuantity)
                    .sum() * 2023;
        }
        return 0;
    }
}