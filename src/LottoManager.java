import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public void Proceed(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        Output.printLottoCount(lottoCount);
        calculation(lottoCount);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(Input.inputLottoWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(Input.inputBonusNumber());
    }

    public void calculation(LottoCount lottoCount) {
        List<LottoNumber> Numbers = new ArrayList<>();
        LottoNumberCreate lottoNumberCreate = new LottoNumberCreate();
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberCreate.createLottoRandomNumber());
            Output.printLottoNumber(lottoNumber.getLottoRandomNumbers());
            Numbers.add(lottoNumber);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(Numbers);
    }
}
