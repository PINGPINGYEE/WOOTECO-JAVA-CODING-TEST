package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Utils;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readDate() {
        try {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String date = Console.readLine();
            return Utils.stringToIntConverting(date);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return readDate();
        }
    }

    public List<OrderHistory> readMenuAndNumberOfOrders(int orderDate) {
        System.out.println("주문하실 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String orderQuantity = Console.readLine();

        return Utils.parseOrderInput(orderQuantity, orderDate).stream()
                .map(order -> new OrderHistory(order.getMenu(), order.getOrderQuantity(), orderDate))
                .collect(Collectors.toList());
    }


}
