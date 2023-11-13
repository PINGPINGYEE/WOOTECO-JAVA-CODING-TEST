package christmas.view;

import christmas.domain.OrderResult;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

import static christmas.domain.menuManage.Menu.CHAMPAGNE;

public class OutputView {
    public void displayOrderResult(OrderResult result, List<OrderHistory> orders) {
        System.out.println("12월 " + result.getOrderDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        System.out.println("<주문 메뉴>");
        for (OrderHistory order : orders) {
            System.out.println(order.getMenu().getName() + " " + order.getOrderQuantity() + "개");
        }

        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();

        System.out.println("<할인 전 총주문 금액>\n" + String.format("%,d원", totalBeforeDiscount));
        if (result.isGiftEvent()) {
            System.out.println("<증정 메뉴>\n샴페인 1개");
        }

        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: -" + String.format("%,d원", result.getDdayDiscount()));
        System.out.println("평일 할인: -" + String.format("%,d원", result.getWeekdayDiscount()));
        System.out.println("주말 할인: -" + String.format("%,d원", result.getWeekendDiscount()));
        System.out.println("특별 할인: -" + String.format("%,d원", result.getSpecialDiscount()));

        if (result.isGiftEvent()) {
            System.out.println("<증정 메뉴>\n샴페인 1개");
            System.out.println("증정 이벤트: -" + String.format("%,d원", CHAMPAGNE.getPrice()));
        }

        // 총혜택 금액 출력
        System.out.println("<총혜택 금액>\n-" + String.format("%,d원", result.getTotalDiscount()));

        // 할인 후 예상 결제 금액 출력
        int finalAmount = totalBeforeDiscount - result.getTotalDiscount();
        if (result.isGiftEvent()) {
            finalAmount += CHAMPAGNE.getPrice();
        }
        System.out.println("<할인 후 예상 결제 금액>\n" + String.format("%,d원", finalAmount));

    }
}
