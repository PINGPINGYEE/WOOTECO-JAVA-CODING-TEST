package christmas;

import christmas.domain.menuManage.Menu;
import christmas.domain.menuManage.OrderHistory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testStringToIntConverting_isOkay() {
        assertEquals(10, Utils.stringToIntConverting("10", "dateException"), "Convert to 10");
    }

    @Test
    void testStringToIntConverting_isNotOkay() {
        assertThrows(IllegalArgumentException.class,
                () -> Utils.stringToIntConverting("invalid", "dateException"),
                "Throw IllegalArgumentException");
    }

    @Test
    void testIsTotalQuantityExceed() {
        List<OrderHistory> orders = Arrays.asList(
                new OrderHistory(Menu.MUSHROOM_SOUP, 10, 10),
                new OrderHistory(Menu.ICE_CREAM, 12, 10)
        );
        assertTrue(Utils.isTotalQuantityExceed(orders), "Total quantity exceeded should return true");
    }



    @Test
    void testIsGiftEvent() {
        List<OrderHistory> orders = Arrays.asList(
                new OrderHistory(Menu.MUSHROOM_SOUP, 5, 5),
                new OrderHistory(Menu.ICE_CREAM, 5, 5)
        );
        assertFalse(Utils.isGiftEvent(orders), "Should return false when the total before discount is less than the gift event standard price");
    }
}