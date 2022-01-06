package domain;

public class WinningLottoAmount {

    private long winningLottoAmount;

    public WinningLottoAmount() {
        this(UserLottoNumberMatchingCount.DEFAULT_VALUE);
    }

    public WinningLottoAmount(long winningLottoAmount) {
        this.winningLottoAmount = winningLottoAmount;
    }

    public void add(Ranking ranking) {
        this.winningLottoAmount += ranking.getPrizeMoney();
    }

    public long getTotal() {
        return winningLottoAmount;
    }

}
