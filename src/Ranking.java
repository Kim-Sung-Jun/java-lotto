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

    public Ranking 찾기(int matchCount) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchCount == matchCount) {
                return ranking;
            }
        }
        throw new IllegalArgumentException("찾을 수 없는 matchCount 입니다,");

//        Arrays.stream(Ranking.values())
//                .filter(ranking -> ranking.matchCount == matchCount)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 matchCount 입니다,"));
    }

    public int 곱하기() {
        return this.matchCount * this.prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
