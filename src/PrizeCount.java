public class PrizeCount {

    private static final int VALUE_COUNT = 1;

    private final int lottoPrizeCount;

    public PrizeCount() {
        this(SameValueCount.DEFAULT_VALUE);
    }

    public PrizeCount(int lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public PrizeCount plus() {
        return new PrizeCount(this.lottoPrizeCount + VALUE_COUNT);
    }

    public int getPrizeCount() {
        return lottoPrizeCount;
    }
}
