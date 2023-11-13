package christmas.domain.discountManage;

import christmas.domain.dateManage.Day;
import christmas.domain.menuManage.Menu;

import java.util.List;

public class DiscountCalcuator {
    public static int calculateChristmasDdayDiscount(int dayOfMonth) {
        if (dayOfMonth > 25) {
            return 0;
        }
        return 1000 + 100 * (dayOfMonth - 1);
    }

    public static int calculateWeekdayDiscount(int dayOfMonth, List<Menu> orderedMenus) {
        Day day = Day.calculateDay(dayOfMonth);
        if (day.isWeekday()) {
            return (int) orderedMenus.stream()
                    .filter(Menu::isDessertMenu)
                    .count() * 2023;
        }
        return 0;
    }

    public static int calculateWeekendDiscount(int dayOfMonth, List<Menu> orderedMenus) {
        Day day = Day.calculateDay(dayOfMonth);
        if (day.isWeekend()) {
            return (int) orderedMenus.stream()
                    .filter(Menu::isMainMenu)
                    .count() * 2023;
        }
        return 0;
    }
}
