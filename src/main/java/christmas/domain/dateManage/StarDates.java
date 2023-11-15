package christmas.domain.dateManage;

import java.util.Arrays;

public enum StarDates {
    DATE_3(3), DATE_10(10), DATE_17(17), DATE_24(24), DATE_25(25), DATE_31(31);

    private final int StarDay;

    StarDates(int dayOfMonth) {
        this.StarDay = dayOfMonth;
    }

    public int getDayOfMonth() {
        return StarDay;
    }

    public static boolean isSpecialDiscountDay(int day) {
        return Arrays.stream(StarDates.values())
                .anyMatch(specialDay -> specialDay.getDayOfMonth() == day);
    }
}