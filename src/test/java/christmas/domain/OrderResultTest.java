package christmas.domain;

import christmas.domain.badgeManage.Badge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderResultTest {
    private static final int TOTAL_DISCOUNT = 5000;
    private static final boolean GIFT_EVENT = true;
    private static final int ORDER_DATE = 15;
    private static final int DDAY_DISCOUNT = 1000;
    private static final int WEEKDAY_DISCOUNT = 2000;
    private static final int WEEKEND_DISCOUNT = 1500;
    private static final int SPECIAL_DISCOUNT = 500;

    @Test
    void testGetTotalDiscount() {
        OrderResult result = new OrderResult(TOTAL_DISCOUNT, GIFT_EVENT, ORDER_DATE, DDAY_DISCOUNT, WEEKDAY_DISCOUNT, WEEKEND_DISCOUNT, SPECIAL_DISCOUNT);
        assertEquals(5000, result.getTotalDiscount(), "total discount is not correct.");
    }

    @Test
    void testIsGiftEvent() {
        OrderResult result = new OrderResult(TOTAL_DISCOUNT, GIFT_EVENT, ORDER_DATE, DDAY_DISCOUNT, WEEKDAY_DISCOUNT, WEEKEND_DISCOUNT, SPECIAL_DISCOUNT);
        assertTrue(result.isGiftEvent(), "gift event is not correct.");
    }


    @Test
    void testGetOrderDate() {
        OrderResult result = new OrderResult(TOTAL_DISCOUNT, GIFT_EVENT, ORDER_DATE, DDAY_DISCOUNT, WEEKDAY_DISCOUNT, WEEKEND_DISCOUNT, SPECIAL_DISCOUNT);
        assertEquals(15, result.getOrderDate(), "order date is not correct.");
    }

    @Test
    void testGetDdayDiscount() {
        OrderResult result = new OrderResult(TOTAL_DISCOUNT, GIFT_EVENT, ORDER_DATE, DDAY_DISCOUNT, WEEKDAY_DISCOUNT, WEEKEND_DISCOUNT, SPECIAL_DISCOUNT);
        assertEquals(1000, result.getDdayDiscount(), "DDay Sale is not correct.");
    }

    @Test
    void testGetEventBadge() {
        OrderResult result = new OrderResult(TOTAL_DISCOUNT, GIFT_EVENT, ORDER_DATE, DDAY_DISCOUNT, WEEKDAY_DISCOUNT, WEEKEND_DISCOUNT, SPECIAL_DISCOUNT);
        result.getEventBadge();
        assertEquals(Badge.별, result.getEventBadge(), "Badge is not correct.");
    }
}