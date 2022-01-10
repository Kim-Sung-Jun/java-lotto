package domain;

import java.util.Arrays;

public enum Ranking {

    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Ranking(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking findRanking(UserLottoNumberMatchingCount sameValueCount, boolean bonusNumber) {
        if (sameValueCount.getValueCount() == THIRD.matchCount && !bonusNumber) {
            return THIRD;
        }
        if (sameValueCount.getValueCount() < FIFTH.matchCount) {
            return NOTHING;
        }
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount == sameValueCount.getValueCount())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 matchCount 입니다,"));
    }

    public static Ranking printRanking(LottoWinningResults totalLottoRankingCount) {
        for (Ranking ranking : Ranking.values()) {
            return validateRanking(ranking, totalLottoRankingCount);
        }
    }

    public static Ranking validateRanking(Ranking ranking, LottoWinningResults totalLottoRankingCount) {
        if (Ranking.SECOND == ranking) {
            return
        } else if (ranking.getMatchCount() > UserLottoNumberMatchingCount.DEFAULT_VALUE) {
            return
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
