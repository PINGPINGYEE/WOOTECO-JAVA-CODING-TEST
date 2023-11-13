package christmas;

import christmas.domain.OrderManager;
import christmas.domain.OrderResult;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int orderDate = inputView.readDate();
        List<OrderHistory> orders = inputView.readMenuAndNumberOfOrders(orderDate);

        OrderManager orderManager = new OrderManager(orders, orderDate);
        OrderResult result = orderManager.processOrder();

        outputView.displayOrderResult(result, orders);
    }
}
