package christmas.domain;
import christmas.domain.badgeManage.Badge;

public class OrderResult {
    private int totalDiscount;
    private boolean giftChampagne;
    private int orderDate;
    private int ddayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private Badge eventBadge;

    public OrderResult(int totalDiscount, boolean giftChampagne, int orderDate, int ddayDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount) {
        this.totalDiscount = totalDiscount;
        this.giftChampagne = giftChampagne;
        this.orderDate = orderDate;
        this.ddayDiscount = ddayDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
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
