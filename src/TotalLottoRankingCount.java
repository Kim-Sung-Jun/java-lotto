import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TotalLottoRankingCount {

    private final Map<Ranking, PrizeCount> lottoRankingCount;

    public TotalLottoRankingCount() {
        this.lottoRankingCount = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            lottoRankingCount.put(ranking, new PrizeCount(SameValueCount.DEFAULT_VALUE)); //초기값을 넣어놓고 나중에 초기화 해준다.
        }
    }

    public void addPrizeCount(Ranking ranking, PrizeCount prizeCount) {
        prizeCount.plus();
        this.lottoRankingCount.put(ranking, prizeCount);
    }

    public Map<Ranking, PrizeCount> getLottoRankingCount() {
        return Collections.unmodifiableMap(lottoRankingCount);
    }
}
