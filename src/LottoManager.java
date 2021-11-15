import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public void proceed(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        Output.printLottoCount(lottoCount);
        calculation(lottoCount);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(Input.inputLottoWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(Input.inputBonusNumber());
    }

    public void calculation(LottoCount lottoCount) {
        List<LottoNumber> numbers = new ArrayList<>();
        LottoNumberFactory lottoNumberCreate = new LottoNumberFactory();
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberCreate.createLottoRandomNumber());
            Output.printLottoNumber(lottoNumber.getLottoRandomNumbers());
            numbers.add(lottoNumber);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    }
}
