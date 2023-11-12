package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Utils;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String date = Console.readLine();

        return Utils.stringToIntConverting(date);
    }

    public List<OrderHistory> readMenuAndNumberOfOrders() {
        System.out.println("주문하실 메뉴와 개수를 알려주세요. (예: 티본스테이크-1,바비큐립-1)");
        String orderQuantity = Console.readLine();

        return Utils.parseOrderInput(orderQuantity);
    }


}
