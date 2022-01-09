package domain;

import view.Output;

import java.util.List;

public class LottoNumbers {

    private static final int MATCH_COUNT = 5;

    private final List<LottoNumber> numbers;

    public LottoNumbers(Money money, ManualLottoCount manualLotto, List<LottoNumber> lottoNumbers) {
        this.numbers = createLottoNumberByMoney(money, manualLotto, lottoNumbers);
    }

    public List<LottoNumber> createLottoNumberByMoney(Money money, ManualLottoCount manualLotto, List<LottoNumber> lottoNumbers) {
        long autoLottoCount = money.calculateAutomaticLottoCount();
        Output.printLottoCount(manualLotto, money);
        for (int i = 0; i < autoLottoCount; i++) {
            LottoNumber lottoNumber = new LottoNumber(LottoNumberFactory.createLottoRandomNumber());
            lottoNumbers.add(lottoNumber);
        }
        for (LottoNumber lottoNumber : lottoNumbers) {
            Output.printLottoNumber(lottoNumber.getLottoNumbers());
        }
        return lottoNumbers;
    }

    public WinningLottoAmount compareResult(LottoWinningNumber lottoWinningNumber,
                                            LottoWinningResults totalLottoRankingCount, WinningLottoAmount totalValue) {
        for (LottoNumber number : numbers) {
            UserLottoNumberMatchingCount sameValueCount = new UserLottoNumberMatchingCount(); //수정해야댐
            lottoWinningNumber.compareLottoNumbers(number, sameValueCount);
            Ranking ranking = Ranking.getRanking(sameValueCount, isBonusNumber(lottoWinningNumber, sameValueCount));
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
