package christmas.domain.discountManage;

import christmas.domain.dateManage.Day;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

import static christmas.domain.discountManage.DiscountCalcuator.*;

public enum Discount {
    CHRISTMAS_DDAY_DISCOUNT {
        @Override
        public int calculateDateRelatedDiscount(int orderDate) {
            return calculateChristmasDdayDiscount(orderDate);
        }
        public int calculateDayRelatedDiscount(Day day, List<OrderHistory> orders) {
            return 0;
        }
    },

    WEEKDAY_DISCOUNT {
        public int calculateDateRelatedDiscount(int orderDate) {
            return 0;
        }
        public int calculateDayRelatedDiscount(Day day, List<OrderHistory> orders) {
            return calculateWeekdayDiscount(day, orders);
        }
    },
    WEEKEND_DISCOUNT {
        public int calculateDateRelatedDiscount(int orderDate) {
            return 0;
        }
        public int calculateDayRelatedDiscount(Day day, List<OrderHistory> orders) {
            return calculateWeekendDiscount(day, orders);
        }
    },
    SPECIAL_DISCOUNT {
        @Override
        public int calculateDateRelatedDiscount(int orderDate) {
            return calculateSpecialDiscount(orderDate);
        }
        public int calculateDayRelatedDiscount(Day day, List<OrderHistory> orders) {
            return 0;
        }
    }
    ;

    public abstract int calculateDateRelatedDiscount(int orderDate);
    public abstract int calculateDayRelatedDiscount(Day day, List<OrderHistory> orders);
}
