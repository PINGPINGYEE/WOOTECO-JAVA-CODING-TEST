package christmas.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.menuManage.Menu;
import christmas.domain.menuManage.OrderHistory;

import java.util.Arrays;
import java.util.List;

public class InputViewTest {

    @Test
    public void testAreAllDrinks_OnlyDrinks() {
        InputView inputView = new InputView();
        List<OrderHistory> orders = Arrays.asList(
                new OrderHistory(Menu.RED_WINE, 1, 1),
                new OrderHistory(Menu.CHAMPAGNE, 2, 1)
        );

        assertTrue(inputView.areAllDrinks(orders));
    }

    @Test
    public void testAreAllDrinks_NotOnlyDrinks() {
        InputView inputView = new InputView();
        List<OrderHistory> orders = Arrays.asList(
                new OrderHistory(Menu.RED_WINE, 1, 1),
                new OrderHistory(Menu.TBONE_STEAK, 1, 1)
        );

        assertFalse(inputView.areAllDrinks(orders));
    }
}
