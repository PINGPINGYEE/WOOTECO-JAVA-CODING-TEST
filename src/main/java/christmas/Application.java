package christmas;

import christmas.domain.OrderManager;
import christmas.domain.OrderResult;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.domain.menuManage.OrderHistory;

import java.util.List;

import static christmas.domain.OrderManager.startOrder;

public class Application {
    public static void main(String[] args) {
        startOrder();
    }


}
