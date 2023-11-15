package christmas.domain;

import christmas.Utils;
import christmas.domain.dateManage.Day;
import christmas.domain.menuManage.OrderHistory;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import static christmas.domain.discountManage.Discount.*;
import static christmas.domain.menuManage.Menu.CHAMPAGNE;

public class OrderManager {
    private final List<OrderHistory> orders;
    private final int orderDate;
    private final int saleBeginPrice = 10000;

    public OrderManager(List<OrderHistory> orders, int orderDate) {
        this.orders = orders;
        this.orderDate = orderDate;
    }

    public static void startOrder() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int orderDate = inputView.readDate();
        List<OrderHistory> orders = inputView.readMenuAndNumberOfOrders(orderDate);

        OrderManager orderManager = new OrderManager(orders, orderDate);
        OrderResult result = orderManager.processOrder();

        outputView.displayOrderResult(result, orders);
    }

    public OrderResult processOrder() {
        Day day = Day.calculateDay(orderDate);
        LastDiscountType discounts = new LastDiscountType(0, 0, 0, 0);
        boolean isGiftEvent = Utils.isGiftEvent(orders);

        int totalBeforeDiscount = orders.stream()
                .mapToInt(OrderHistory::calculateBeforeDiscountPrice)
                .sum();

        if (totalBeforeDiscount >= saleBeginPrice) { discounts = calculateDiscount(day, orderDate, orders); }

        return createOrderResult(discounts, isGiftEvent);
    }


    private LastDiscountType calculateDiscount(Day day, int orderDate, List<OrderHistory> orders) {
        int ddayDiscount = CHRISTMAS_DDAY_DISCOUNT.calculateDateRelatedDiscount(orderDate);
        int weekdayDiscount = WEEKDAY_DISCOUNT.calculateDayRelatedDiscount(day, orders);
        int weekendDiscount = WEEKEND_DISCOUNT.calculateDayRelatedDiscount(day, orders);
        int specialDiscount = SPECIAL_DISCOUNT.calculateDateRelatedDiscount(orderDate);

        return new LastDiscountType(ddayDiscount, weekdayDiscount, weekendDiscount, specialDiscount);
    }

    private OrderResult createOrderResult(LastDiscountType discounts, boolean isGiftEvent) {
        int totalDiscount = discounts.getTotalDiscount();
        if (isGiftEvent) totalDiscount += CHAMPAGNE.getPrice();

        return new OrderResult(totalDiscount, isGiftEvent, orderDate,
                discounts.getDdayDiscount(),
                discounts.getWeekdayDiscount(),
                discounts.getWeekendDiscount(),
                discounts.getSpecialDiscount());
    }

    private static class LastDiscountType {
        private final int ddayDiscount;
        private final int weekdayDiscount;
        private final int weekendDiscount;
        private final int specialDiscount;

        public LastDiscountType(int ddayDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount) {
            this.ddayDiscount = ddayDiscount;
            this.weekdayDiscount = weekdayDiscount;
            this.weekendDiscount = weekendDiscount;
            this.specialDiscount = specialDiscount;
        }

        public int getTotalDiscount() {
            return ddayDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
        }

        public int getDdayDiscount() { return ddayDiscount; }
        public int getWeekdayDiscount() { return weekdayDiscount; }
        public int getWeekendDiscount() { return weekendDiscount; }
        public int getSpecialDiscount() { return specialDiscount; }
    }
}