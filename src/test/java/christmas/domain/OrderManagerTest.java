package christmas.domain;

import christmas.domain.menuManage.Menu;
import christmas.domain.menuManage.OrderHistory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderManagerTest {

    @Test
    public void discountShouldNotBeAppliedIfTotalIsLessThan10000() {
        OrderHistory order1 = new OrderHistory(Menu.MUSHROOM_SOUP, 1, 1);
        OrderHistory order2 = new OrderHistory(Menu.ZERO_COLA, 1, 1);

        OrderManager orderManager = new OrderManager(Arrays.asList(order1, order2), 1);

        OrderResult result = orderManager.processOrder();

        assertEquals(0, result.getTotalDiscount());
    }


}