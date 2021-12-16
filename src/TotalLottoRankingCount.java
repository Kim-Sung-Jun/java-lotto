import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TotalLottoRankingCount {

    private final Map<Ranking, PrizeCount> lottoRankingCount;

    public TotalLottoRankingCount() {
        this.lottoRankingCount = new HashMap<>();
    }

    public void addPrizeCount(Ranking ranking, PrizeCount prizeCount) {
        this.lottoRankingCount.put(ranking, prizeCount.plus());
    }

    public Map<Ranking, PrizeCount> getLottoRankingCount() {
        return Collections.unmodifiableMap(lottoRankingCount);
    }
}
