package christmas;

import christmas.domain.menuManage.Menu;
import christmas.domain.menuManage.OrderHistory;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int stringToIntConverting(String input) {
        try {
            int date = Integer.parseInt(input);

            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("[ERROR] 날짜는 1일에서 31일 사이의 정수여야 합니다.");
            }

            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력하세요.");
        }
    }

    public static List<OrderHistory> parseOrderInput(String input) {
        String[] items = input.split(",");
        List<OrderHistory> orderItems = new ArrayList<>();

        for (String item : items) {
            String[] standards = item.split("-");
            if (standards.length != 2) {
                throw new IllegalArgumentException("[ERROR] 잘못된 주문 형식입니다.");
            }

            String menuName = standards[0].trim();
            int orderQuantity = stringToIntConverting(standards[1].trim());

            Menu menu = Menu.getByName(menuName);
            orderItems.add(new OrderHistory(menu, orderQuantity));
        }

        return orderItems;
    }
}
