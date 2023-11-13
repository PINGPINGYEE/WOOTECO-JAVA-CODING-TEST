package christmas.domain;

public class OrderResult {
    private int finalAmount;
    private int totalDiscount;
    private boolean giftChampagne;
    private int orderDate;

    public OrderResult(int finalAmount, int totalDiscount, boolean giftChampagne, int orderDate) {
        this.finalAmount = finalAmount;
        this.totalDiscount = totalDiscount;
        this.giftChampagne = giftChampagne;
        this.orderDate = orderDate;
    }

    // Getter 메서드들
    public int getFinalAmount() {
        return finalAmount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public boolean isGiftEvent() {
        return giftChampagne;
    }

    public int getOrderDate() {
        return orderDate;
    }

}
