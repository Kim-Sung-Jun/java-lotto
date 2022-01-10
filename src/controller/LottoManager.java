package controller;

import domain.*;
import view.Input;
import view.Output;

public class LottoManager {

    public void proceed(Money money) {

    }

    public void proceed1(Money money) {
        ManualLottoCount manualLotto = new ManualLottoCount(money, Input.inputManualLottoCount());
        LottoNumbers userInputLottoNumbers = manualLotto.createManualLottoByManualLottoCount();
        LottoNumbers lottoNumbers = new LottoNumbers(money, manualLotto, userInputLottoNumbers);


        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(LottoNumberFactory.createInputLottoNumber(
                Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));
        LottoWinningResults totalLottoRankingCount = new LottoWinningResults();
        WinningLottoAmount totalValue = lottoNumbers.compareResult(lottoWinningNumber,
                totalLottoRankingCount, new WinningLottoAmount());
        Output.printRanking(totalLottoRankingCount);
        Output.printProfitsRate(totalValue, money);
    }

}
