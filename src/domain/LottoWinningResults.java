package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoWinningResults {

    private final Map<Ranking, RankingCount> lottoRankingCount;

    public LottoWinningResults() {
        this.lottoRankingCount = new HashMap<>();
        for (Ranking ranking : Ranking.values()) {
            lottoRankingCount.put(ranking, new RankingCount(UserLottoNumberMatchingCount.DEFAULT_VALUE));
        }
    }

    public void addPrizeCount(Ranking ranking) {
        this.lottoRankingCount.computeIfPresent(ranking, (Ranking key, RankingCount value) -> value.plus());
    }

    public Map<Ranking, RankingCount> getLottoRankingCount() {
        return Collections.unmodifiableMap(lottoRankingCount);
    }

}
