package christmas.domain.badgeManage;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000);

    private final int standardPoint;

    Badge(int threshold) {
        this.standardPoint = threshold;
    }

    public static Badge getBadgeForDiscount(int totalDiscount) {
        if (totalDiscount >= 산타.standardPoint) {
            return 산타;
        } else if (totalDiscount >= 트리.standardPoint) {
            return 트리;
        } else if (totalDiscount >= 별.standardPoint) {
            return 별;
        }
        return null;
    }
}
