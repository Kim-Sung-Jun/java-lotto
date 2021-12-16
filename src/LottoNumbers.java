import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    public TotalValue compareResult(LottoWinningNumber lottoWinningNumber, TotalLottoRankingCount totalLottoRankingCount) { //카운터를 찾는 메소드
        TotalValue totalValue = new TotalValue(); //하는일이 너무 많음
        for (LottoNumber number : numbers) {
            SameValueCount sameValueCount = new SameValueCount();
            PrizeCount prizeCount = new PrizeCount();
            lottoWinningNumber.compareLottoNumbers(number, sameValueCount);
            Ranking ranking = Ranking.getRanking(sameValueCount, isBonusNumber(lottoWinningNumber, sameValueCount));
            totalLottoRankingCount.addPrizeCount(ranking, prizeCount);
            totalValue.add(ranking);
        }
        return totalValue;
    }

    private boolean isBonusNumber(LottoWinningNumber lottoWinningNumber, SameValueCount sameValueCount) {
        if (sameValueCount.getValueCount() == 5) {
            return lottoWinningNumber.findBonusNumber();
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
