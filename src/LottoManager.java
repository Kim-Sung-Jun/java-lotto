
public class LottoManager {

    public void proceed(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        Output.printLottoCount(lottoCount);
        LottoNumbersFactory.createLottoNumberByMoney(lottoCount);

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                WinningNumberFactory.transformWinningNumber(
                        Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));
    }
}
