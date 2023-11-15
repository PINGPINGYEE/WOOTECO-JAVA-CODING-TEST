package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Utils;
import christmas.domain.menuManage.Menu;
import christmas.domain.menuManage.MenuCategory;
import christmas.domain.menuManage.OrderHistory;

import java.util.ArrayList;
import java.util.List;

public class InputView {


    public int readDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String date = Console.readLine();
            return Utils.stringToIntConverting(date, "dateExcpetion");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return readDate();
        }
    }

    public List<OrderHistory> readMenuAndNumberOfOrders(int orderDate) {
        System.out.println("주문하실 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String orderQuantity = Console.readLine();

        try {
            List<OrderHistory> orders = parseOrderInput(orderQuantity, orderDate);
            if (areAllDrinks(orders)) throw new IllegalArgumentException("[ERROR] 음료수만 주문할 수 없습니다.");
            if (Utils.isTotalQuantityExceeded(orders))
                throw new IllegalArgumentException("[ERROR] 총 주문 수량은 20을 초과할 수 없습니다.");
            return orders;
        } catch (Exception ex) {
            return exceptionChecker(ex, orderDate);
        }
    }

    private List<OrderHistory> exceptionChecker(Exception ex, int orderDate) {
        if (ex instanceof NumberFormatException) {
            System.out.println("[ERROR] 유효하지 않은 주문 수량입니다. 다시 입력해 주세요.");
            return readMenuAndNumberOfOrders(orderDate);
        }
        if (ex instanceof IllegalArgumentException) {
            System.out.println(ex.getMessage());
            return readMenuAndNumberOfOrders(orderDate);
        }
        return null;
    }

    boolean areAllDrinks(List<OrderHistory> orders) {
        return orders.stream().allMatch(order -> order.getMenu().getCategory() == MenuCategory.DRINK);
    }

    private List<OrderHistory> parseOrderInput(String input, int orderDate) {
        String[] items = input.split(",");
        List<OrderHistory> orderItems = new ArrayList<>();
        List<String> menuNames = new ArrayList<>();

        return parserChecker(items, orderDate, orderItems, menuNames);
    }

    private List<OrderHistory> parserChecker(String[] items, int orderDate, List<OrderHistory> orderItems, List<String> menuNames) {
        for (String item : items) {
            String[] standards = item.split("-");
            if (standards.length != 2) throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            if (menuNames.contains(standards[0].trim())) throw new IllegalArgumentException("[ERROR] 메뉴는 중복될 수 없습니다.");
            menuNames.add(standards[0].trim());
            try {
                Menu menu = Menu.getByName(standards[0].trim());
                orderItems.add(new OrderHistory(menu, Utils.stringToIntConverting(standards[1].trim(), "quantityException"), orderDate));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        return orderItems;
    }
}