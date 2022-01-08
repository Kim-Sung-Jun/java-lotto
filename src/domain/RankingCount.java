package domain;

public class RankingCount {

    private static final int VALUE_COUNT = 1;

    private final int lottoPrizeCount;

    public RankingCount() {
        this(UserLottoNumberMatchingCount.DEFAULT_VALUE);
    }

    public RankingCount(int lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }

    public RankingCount plus() {
        return new RankingCount(this.lottoPrizeCount + VALUE_COUNT);
    }

    public int getPrizeCount() {
        return lottoPrizeCount;
    }
    
}
