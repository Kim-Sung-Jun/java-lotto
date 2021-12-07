import java.util.List;

public class LottoManager {

    public void proceed(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        Output.printLottoCount(lottoCount);
        List<LottoNumber> numbers = LottoNumbersFactory.createLottoNumberByMoney(lottoCount);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                WinningNumberFactory.transformWinningNumber(
                        Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));


    }
}
