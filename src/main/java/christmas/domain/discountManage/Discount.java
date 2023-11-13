package christmas.domain.discountManage;

import christmas.domain.menuManage.Menu;

import java.util.List;

import static christmas.domain.discountManage.DiscountCalcuator.*;

public enum Discount {
    CHRISTMAS_DDAY_DISCOUNT {
        @Override
        public int calculateDateRelatedDiscount(int orderDate) {
            return calculateChristmasDdayDiscount(orderDate);
        }
        @Override
        public int calculateMenuRelatedDiscount(int orderDate, List<Menu> orderMenus) {
            return 0;
        }
    },
    WEEKDAY_DISCOUNT {
        @Override
        public int calculateDateRelatedDiscount(int orderDate) {
            return 0;
        }
        @Override
        public int calculateMenuRelatedDiscount(int orderDate, List<Menu> orderMenus) {
            return calculateWeekdayDiscount(orderDate, orderMenus);
        }
    },
    SPECIAL_DISCOUNT {
        @Override
        public int calculateDateRelatedDiscount(int orderDate) {
            return calculateSpecialDiscount(orderDate);
        }
        @Override
        public int calculateMenuRelatedDiscount(int orderDate, List<Menu> orderMenus) {
            return 0;
        }
    };



    public abstract int calculateDateRelatedDiscount(int orderDate);

    public abstract int calculateMenuRelatedDiscount(int orderDate, List<Menu> orderMenus);
}
