package christmas.domain.menuManage;

public class OrderHistory {
    private final Menu menu;
    private final int orderQuantity;

    public OrderHistory(Menu menu, int numberOfMenu, int orderDate) {
        this.menu = menu;
        this.orderQuantity = numberOfMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int calculateBeforeDiscountPrice() {
        return menu.getPrice() * orderQuantity;
    }
}
