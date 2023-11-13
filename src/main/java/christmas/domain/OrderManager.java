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

    public OrderResult processOrder() {
        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();
        int totalDiscount = calculateTotalDiscount();
        boolean giftChampagne = Utils.isGiftEvent(orders);

        int finalAmount = totalBeforeDiscount - totalDiscount;
        return new OrderResult(finalAmount, totalDiscount, giftChampagne, orderDate); // orderDate 추가
    }

}
