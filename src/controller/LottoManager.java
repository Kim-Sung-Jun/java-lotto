package controller;

import domain.*;
import view.Input;
import view.Output;

public class LottoManager {

    public void proceed(Money money) {
        ManualLottoCount manualLotto = new ManualLottoCount(money, Input.inputManualLottoCount());
        LottoNumbers userInputLottoNumbers = manualLotto.createManualLottoByManualLottoCount();
        LottoNumbers lottoNumbers = new LottoNumbers(money, manualLotto, userInputLottoNumbers);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(LottoNumberFactory.createInputLottoNumber(
                Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));
        LottoWinningResults totalLottoRankingCount = new LottoWinningResults();
        int totalAmount = lottoNumbers.compareResult(lottoWinningNumber, totalLottoRankingCount);
        printResults(totalLottoRankingCount, totalAmount, money);
    }

    public void printResults(LottoWinningResults totalLottoRankingCount, int totalAmount, Money money) {
        Output.printRankingMsg();
        for (Ranking ranking : Ranking.values()) {
            Output.printRanking(ranking, totalLottoRankingCount);
        }
        Output.printProfitsRate(totalAmount, money);
    }

}
