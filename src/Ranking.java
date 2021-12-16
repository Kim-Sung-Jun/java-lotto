import java.util.Arrays;

public enum Ranking {

    FIRST(6, 2000000000),
    SECOND(5, 30000000), //보너스볼까지 맞아야함
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Ranking(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking getRanking(SameValueCount sameValueCount, boolean bonusNumber) {
        if (sameValueCount.getValueCount() == THIRD.matchCount && !bonusNumber) { //여기서 3등을 찾아냄
            return THIRD;
        }
        if (sameValueCount.getValueCount() < FIFTH.matchCount) {
            return NOTHING;
        }
        return Arrays.stream(Ranking.values())  //위에서 3등을 찾았기 때문에 여기서 2등을 찾아냄
                .filter(ranking -> ranking.matchCount == sameValueCount.getValueCount())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 matchCount 입니다,"));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
