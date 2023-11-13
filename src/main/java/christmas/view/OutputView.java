package christmas.view;

import christmas.domain.OrderResult;
import christmas.domain.badgeManage.Badge;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

import static christmas.domain.menuManage.Menu.CHAMPAGNE;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    public void displayOrderResult(OrderResult result, List<OrderHistory> orders) {
        System.out.println("12월 " + result.getOrderDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        displayOrderMenu(orders);

        int totalBeforeDiscount = calculateTotalBeforeDiscount(orders);
        System.out.println("<할인 전 총주문 금액>"+ LINE_SEPARATOR + String.format("%,d원", totalBeforeDiscount));

        System.out.println("<증정 메뉴>"+ LINE_SEPARATOR + getGiftMenu(result));

        System.out.println("<혜택 내역>"+ LINE_SEPARATOR + getDiscountDetails(result));

        System.out.println("<총혜택 금액>"+ LINE_SEPARATOR + getFormattedTotalDiscount(result));

        System.out.println("<할인 후 예상 결제 금액>"+ LINE_SEPARATOR + getFormattedFinalAmount(totalBeforeDiscount, result));

        System.out.println("<12월 이벤트 배지>"+ LINE_SEPARATOR + getEventBadgeString(result.getEventBadge()));
    }

    private String getEventBadgeString(Badge badge) {
        if (badge != null) {
            return badge.name();
        }
        return "없음";
    }

    private void displayOrderMenu(List<OrderHistory> orders) {
        System.out.println("<주문 메뉴>");
        for (OrderHistory order : orders) {
            System.out.println(order.getMenu().getName() + " " + order.getOrderQuantity() + "개");
        }
    }

    private int calculateTotalBeforeDiscount(List<OrderHistory> orders) {
        return orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();
    }

    private String getGiftMenu(OrderResult result) {
        return result.isGiftEvent() ? "샴페인 1개" : "없음";  // 수정해야함!!
    }

    private String getDiscountDetails(OrderResult result) {
        if (result.getTotalDiscount() > 0) {
            return "크리스마스 디데이 할인: -" + String.format("%,d원", result.getDdayDiscount()) + LINE_SEPARATOR +
                    "평일 할인: -" + String.format("%,d원", result.getWeekdayDiscount()) + LINE_SEPARATOR +
                    "주말 할인: -" + String.format("%,d원", result.getWeekendDiscount()) + LINE_SEPARATOR +
                    "특별 할인: -" + String.format("%,d원", result.getSpecialDiscount());
        }
        return "없음";
    }

    private String getFormattedTotalDiscount(OrderResult result) {
        if (result.getTotalDiscount() > 0) {
            return "-" + String.format("%,d원", result.getTotalDiscount());
        }
        return String.format("%,d원", result.getTotalDiscount());
    }


    private String getFormattedFinalAmount(int totalBeforeDiscount, OrderResult result) {
        int finalAmount = totalBeforeDiscount - result.getTotalDiscount();
        if (result.isGiftEvent()) {
            finalAmount += CHAMPAGNE.getPrice();  // 샴페인 가격 추가
        }
        return String.format("%,d원", finalAmount);
    }

}
