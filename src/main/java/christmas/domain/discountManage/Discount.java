package christmas.domain.discountManage;

public enum Discount {
    CHRISTMAS_DDAY_DISCOUNT {
        @Override
        public int calculateDiscount(int dayOfMonth) {
            return calculateChristmasDdayDiscount(dayOfMonth);
        }
    },
    WEEKDAY_DISCOUNT {
        @Override
        public int calculateDiscount(int dayOfMonth) {
            // 평일 할인 계산 로직
            return 0; // 예시 값
        }
    },
    WEEKEND_DISCOUNT {
        @Override
        public int calculateDiscount(int dayOfMonth) {
            // 주말 할인 계산 로직
            return 0; // 예시 값
        }
    },
    SPECIAL_DISCOUNT {
        @Override
        public int calculateDiscount(int dayOfMonth) {
            // 특별 할인 계산 로직
            return 0; // 예시 값
        }
    };

    private static int calculateChristmasDdayDiscount(int dayOfMonth) {
        if (dayOfMonth > 25) {
            return 0;
        }
        return 1000 + 100 * (dayOfMonth - 1);
    }

    public abstract int calculateDiscount(int dayOfMonth);
}
