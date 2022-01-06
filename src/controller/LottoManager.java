package controller;

import domain.*;
import view.Input;
import view.Output;

import java.util.List;

public class LottoManager {

    public void proceed(Money money) {
        ManualLotto manualLotto = new ManualLotto(money, Input.inputManualLottoCount());
        List<LottoNumber> userInputLottoNumbers = manualLotto.createManualLottoByManualLottoCount();
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
