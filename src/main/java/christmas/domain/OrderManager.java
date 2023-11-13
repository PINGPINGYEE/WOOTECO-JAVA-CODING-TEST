package christmas.domain;

import christmas.Utils;
import christmas.domain.discountManage.Discount;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class OrderManager {
    private List<OrderHistory> orders;
    private int orderDate;

    public OrderManager(List<OrderHistory> orders, int orderDate) {
        this.orders = orders;
        this.orderDate = orderDate;
    }

    public int calculateTotalDiscount() {
        int totalDiscount = 0;

        for (OrderHistory order : orders) {
            totalDiscount += Discount.CHRISTMAS_DDAY_DISCOUNT.calculateDateRelatedDiscount(orderDate);
            totalDiscount += Discount.WEEKDAY_DISCOUNT.calculateMenuRelatedDiscount(orderDate, List.of(order.getMenu()));
            totalDiscount += Discount.SPECIAL_DISCOUNT.calculateDateRelatedDiscount(orderDate);
        }

        return totalDiscount;
    }

    // OrderManager 클래스 내부

    public OrderResult processOrder() {
        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();

        int ddayDiscount = Discount.CHRISTMAS_DDAY_DISCOUNT.calculateDateRelatedDiscount(orderDate);
        int weekdayDiscount = orders.stream()
                .filter(o -> o.getMenu().isDessertMenu())
                .mapToInt(o -> o.getOrderQuantity())
                .sum() * 2023;
        int weekendDiscount = 0; // 주말 할인은 이 경우 적용되지 않음
        int specialDiscount = Discount.SPECIAL_DISCOUNT.calculateDateRelatedDiscount(orderDate);

        int totalDiscount = ddayDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
        boolean giftChampagne = Utils.isGiftEvent(orders);

        if (giftChampagne) {
            totalDiscount += 25000; // 샴페인 가격 추가
        }

        int finalAmount = totalBeforeDiscount - totalDiscount;

        return new OrderResult(finalAmount, totalDiscount, giftChampagne, orderDate, ddayDiscount, weekdayDiscount, weekendDiscount, specialDiscount);
    }
}