package domain;

import view.Output;

import java.util.List;

public class LottoNumbers {

    private static final int MATCH_COUNT = 5;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers(Money money, ManualLottoCount manualLotto, LottoNumbers lottoNumbers) {
        this.numbers = createLottoNumberByMoney(money, manualLotto, lottoNumbers);
    }

    public List<LottoNumber> createLottoNumberByMoney(Money money, ManualLottoCount manualLotto, LottoNumbers lottoNumbers) {
        long autoLottoCount = money.calculateAutomaticLottoCount();
        Output.printLottoCount(manualLotto, money);
        for (int i = 0; i < autoLottoCount; i++) {
            lottoNumbers.numbers.add(LottoNumberFactory.createLottoRandomNumber());
        }
        for (LottoNumber lottoNumber : lottoNumbers.numbers) {
            Output.printLottoNumber(lottoNumber.getLottoNumbers());
        }
        return lottoNumbers.numbers;
    }

    public int compareResult(LottoWinningNumber lottoWinningNumber,
                             LottoWinningResults totalLottoRankingCount) {
        int totalAmount = 0;
        for (LottoNumber number : numbers) {
            int lottoNumberMatchCount = lottoWinningNumber.compareLottoNumbers(number);
            Ranking ranking = Ranking.findRanking(lottoNumberMatchCount, isBonusNumber(lottoWinningNumber, lottoNumberMatchCount));
            totalLottoRankingCount.addPrizeCount(ranking);
            totalAmount += ranking.getPrizeMoney();
        }
        return totalAmount;
    }

    private boolean isBonusNumber(LottoWinningNumber lottoWinningNumber, int lottoNumberMatchCount) {
        if (lottoNumberMatchCount == MATCH_COUNT) {
            return lottoWinningNumber.findBonusNumber();
        }
        return false;
    }

}
