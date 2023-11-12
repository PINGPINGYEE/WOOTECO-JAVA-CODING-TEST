package christmas.domain.menuManage;

public class OrderHistory {
    private final Menu menu;
    private final int orderQuantity;

    public OrderHistory(Menu menu, int numberOfMenu) {
        this.menu = menu;
        this.orderQuantity = numberOfMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public int calculateTotalPrice() {
        return menu.getPrice() * orderQuantity;
    }
}
