package controller;

import domain.*;
import view.Input;
import view.Output;

import java.util.List;

public class LottoManager {

    public void proceed(Money money) { //22.1.2 순서, 구조 전부 다 다시하기
        AutomaticLottoCount lottoCount = new AutomaticLottoCount(money);
        Output.printLottoCount(lottoCount);
        List<LottoNumber> numbers = LottoNumbersFactory.createLottoNumberByMoney(lottoCount);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);           //위닝넘버팩토리에서 예외처리 해줘야함? 로또넘버에 예외처리가 있기 때문에 또 만들어줘야하는지 생각해봐야함
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(InputLottoNumberFactory.transformWinningNumber(
                Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));
        TotalLottoRankingCount totalLottoRankingCount = new TotalLottoRankingCount();
        TotalValue totalValue = lottoNumbers.compareResult(lottoWinningNumber, totalLottoRankingCount, new TotalValue());
        Output.printRanking(totalLottoRankingCount);
        Output.printProfitsRate(totalValue, money);
    }
}
