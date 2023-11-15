package christmas.domain;

import org.junit.jupiter.api.Test;

import static christmas.domain.discountManage.DiscountCalcuator.calculateChristmasDdayDiscount;
import static christmas.domain.discountManage.DiscountCalcuator.calculateSpecialDiscount;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DiscountCalcuatorTest {


    @Test
    void testCalculateChristmasDdayDiscount() {
        int discount = calculateChristmasDdayDiscount(20);
        assertEquals(2900, discount, "Correct is 2900");

        discount = calculateChristmasDdayDiscount(26);
        assertEquals(0, discount, "Correct is 0");
    }

    @Test
    void testCalculateSpecialDiscount() {

        // 특별 할인 날짜에 대한 할인이 적용되는 경우
        assertEquals(1000, calculateSpecialDiscount(3), "3 is special day");
        assertEquals(1000, calculateSpecialDiscount(10), "10 is special day");

        // 특별 할인 날짜가 아닌 경우
        assertEquals(0, calculateSpecialDiscount(4), "4 is not special day");
    }




}