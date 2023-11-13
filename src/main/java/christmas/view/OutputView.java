package christmas.view;

import christmas.domain.OrderResult;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class OutputView {
    public void displayOrderResult(OrderResult result, List<OrderHistory> orders) {
        System.out.println("12월 " + result.getOrderDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        System.out.println("<주문 메뉴>");
        for (OrderHistory order : orders) {
            System.out.println(order.getMenu().getName() + " " + order.getOrderQuantity() + "개");
        }

        System.out.println("<할인 전 총주문 금액>\n" + result.getFinalAmount() + "원");

        if (result.isGiftEvent()) {
            System.out.println("<증정 메뉴>\n샴페인 1개");
        }

        System.out.println("<할인 후 예상 결제 금액>\n" + (result.getFinalAmount() - result.getTotalDiscount()) + "원");
    }
}
