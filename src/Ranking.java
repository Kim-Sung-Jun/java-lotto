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

}
