public class TotalValue {

    private long total;

    public TotalValue() {
        this(SameValueCount.DEFAULT_VALUE);
    }

    public TotalValue(long total) {
        this.total = total;
    }

    public void add(Ranking ranking) {
        this.total += ranking.getPrizeMoney();
    }

    public long getTotal() {
        return total;
    }

}
