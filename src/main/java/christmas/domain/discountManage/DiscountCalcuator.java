package christmas.domain.discountManage;

import christmas.domain.dateManage.Day;
import christmas.domain.dateManage.StarDates;
import christmas.domain.menuManage.Menu;

import java.util.List;

public class DiscountCalcuator {
    public static int calculateChristmasDdayDiscount(int date) {
        if (date > 25) {
            return 0;
        }
        return 1000 + 100 * (date - 1);
    }

    public static int calculateWeekdayDiscount(int date, List<Menu> orderMenus) {
        Day day = Day.calculateDay(date);
        if (day.isWeekday()) {
            return (int) orderMenus.stream()
                    .filter(Menu::isDessertMenu)
                    .count() * 2023;
        }
        return 0;
    }

    public static int calculateWeekendDiscount(int date, List<Menu> orderMenus) {
        Day day = Day.calculateDay(date);
        if (day.isWeekend()) {
            return (int) orderMenus.stream()
                    .filter(Menu::isMainMenu)
                    .count() * 2023;
        }
        return 0;
    }

    public static int calculateSpecialDiscount(int date) {
        if (StarDates.isSpecialDiscountDay(date)) {
            return 1000;
        }
        return 0;
    }
}
