package christmas.domain.badgeManage;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000);

    private final int standardDiscountPrice;

    Badge(int standardDiscountPrice) {
        this.standardDiscountPrice = standardDiscountPrice;
    }

    public static Badge getBadgeForDiscount(int totalDiscount) {
        if (totalDiscount >= 산타.standardDiscountPrice) {
            return 산타;
        } else if (totalDiscount >= 트리.standardDiscountPrice) {
            return 트리;
        } else if (totalDiscount >= 별.standardDiscountPrice) {
            return 별;
        }
        return null;
    }
}