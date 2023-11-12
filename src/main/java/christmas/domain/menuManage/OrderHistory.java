package christmas.domain.menuManage;

public class OrderHistory {
    private final Menu menu;
    private final int numberOfMenu;

    public OrderHistory(Menu menu, int numberOfMenu) {
        this.menu = menu;
        this.numberOfMenu = numberOfMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getNumberOfMenu() {
        return numberOfMenu;
    }
}
