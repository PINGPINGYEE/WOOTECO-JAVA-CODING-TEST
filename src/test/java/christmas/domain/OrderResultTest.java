package christmas.domain;

import christmas.domain.badgeManage.Badge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderResultTest {

    @Test
    void testGetTotalDiscount() {
        OrderResult result = new OrderResult(5000, true, 15, 1000, 2000, 1500, 500);
        assertEquals(5000, result.getTotalDiscount(), "총 할인 금액이 올바르지 않습니다.");
    }

    @Test
    void testIsGiftEvent() {
        OrderResult result = new OrderResult(5000, true, 15, 1000, 2000, 1500, 500);
        assertTrue(result.isGiftEvent(), "선물 이벤트 여부가 올바르지 않습니다.");
    }


    @Test
    void testGetOrderDate() {
        OrderResult result = new OrderResult(5000, true, 15, 1000, 2000, 1500, 500);
        assertEquals(15, result.getOrderDate(), "주문 날짜가 올바르지 않습니다.");
    }

    @Test
    void testGetDdayDiscount() {
        OrderResult result = new OrderResult(5000, true, 15, 1000, 2000, 1500, 500);
        assertEquals(1000, result.getDdayDiscount(), "D-day 할인 금액이 올바르지 않습니다.");
    }

    @Test
    void testGetEventBadge() {
        OrderResult result = new OrderResult(5000, true, 15, 1000, 2000, 1500, 500);
        // 이벤트 뱃지 설정 로직에 따라 테스트를 작성합니다.
        // 예를 들어, 일정 금액 이상일 경우 특정 뱃지를 반환하는 경우:
        result.getEventBadge(); // 뱃지 결정 로직 호출
        assertEquals(Badge.별, result.getEventBadge(), "이벤트 뱃지가 올바르지 않습니다.");
    }


}