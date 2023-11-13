package christmas.domain;

import christmas.domain.badgeManage.Badge;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class OrderResult {
    private int finalAmount;
    private int totalDiscount;
    private boolean giftChampagne;
    private int orderDate;
    private int ddayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private Badge eventBadge;

    public OrderResult(int finalAmount, int totalDiscount, boolean giftChampagne, int orderDate, int ddayDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount) {
        this.finalAmount = finalAmount;
        this.totalDiscount = totalDiscount;
        this.giftChampagne = giftChampagne;
        this.orderDate = orderDate;
        this.ddayDiscount = ddayDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
    }

    public void displayOrderResult(OrderResult result, List<OrderHistory> orders) {
        this.finalAmount = finalAmount;
        this.totalDiscount = totalDiscount;
        this.giftChampagne = giftChampagne;
        this.orderDate = orderDate;
        this.ddayDiscount = ddayDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
    }

    // Getter 메서드들
    public int getFinalAmount() {
        return finalAmount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public boolean isGiftEvent() {
        return giftChampagne;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public int getDdayDiscount() {
        return ddayDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public Badge getEventBadge() {
        return eventBadge;
    }

    public void determineEventBadge() {
        this.eventBadge = Badge.getBadgeForDiscount(this.totalDiscount);
    }
}
