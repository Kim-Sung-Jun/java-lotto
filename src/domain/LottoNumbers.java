package domain;

import view.Output;

import java.util.List;

public class LottoNumbers {

    private static final int MATCH_COUNT = 5;

    private List<LottoNumber> numbers;

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

    public WinningLottoAmount compareResult(LottoWinningNumber lottoWinningNumber,
                                            LottoWinningResults totalLottoRankingCount, WinningLottoAmount totalValue) {
        for (LottoNumber number : numbers) {
            UserLottoNumberMatchingCount sameValueCount = new UserLottoNumberMatchingCount(); //수정해야댐
            lottoWinningNumber.compareLottoNumbers(number, sameValueCount);
            Ranking ranking = Ranking.findRanking(sameValueCount, isBonusNumber(lottoWinningNumber, sameValueCount));
            totalLottoRankingCount.addPrizeCount(ranking);
            totalValue.add(ranking);
        }
        return totalValue;
    }

    private boolean isBonusNumber(LottoWinningNumber lottoWinningNumber, UserLottoNumberMatchingCount sameValueCount) {
        if (sameValueCount.getValueCount() == MATCH_COUNT) {
            return lottoWinningNumber.findBonusNumber();
        }
        return false;
    }

}
