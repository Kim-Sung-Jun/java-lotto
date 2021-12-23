import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MATCH_COUNT = 5;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    public TotalValue compareResult(LottoWinningNumber lottoWinningNumber,
                                    TotalLottoRankingCount totalLottoRankingCount, TotalValue totalValue) { //카운터를 찾는 메소드
        for (LottoNumber number : numbers) {
            SameValueCount sameValueCount = new SameValueCount();
            lottoWinningNumber.compareLottoNumbers(number, sameValueCount);
            Ranking ranking = Ranking.getRanking(sameValueCount, isBonusNumber(lottoWinningNumber, sameValueCount));
            totalLottoRankingCount.addPrizeCount(ranking);
            totalValue.add(ranking);
        }
        return totalValue;
    }

    private boolean isBonusNumber(LottoWinningNumber lottoWinningNumber, SameValueCount sameValueCount) {
        if (sameValueCount.getValueCount() == MATCH_COUNT) {
            return lottoWinningNumber.findBonusNumber();
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
