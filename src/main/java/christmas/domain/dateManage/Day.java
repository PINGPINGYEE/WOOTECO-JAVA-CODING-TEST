package christmas.domain.dateManage;

import java.util.ArrayList;
import java.util.List;

public enum Day {
    금요일, 토요일, 일요일, 월요일, 화요일, 수요일, 목요일;

    private static List<Day> days = new  ArrayList<>(List.of(values()));

    public static Day calculateDay(int dayOfMonth) {
        int targetIndex = (dayOfMonth - 1) % days.size();
        return days.get(targetIndex);
    }
}
