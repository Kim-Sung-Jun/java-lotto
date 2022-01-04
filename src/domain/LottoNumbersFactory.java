package domain;

import view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

    public static List<LottoNumber> createLottoNumberByMoney(AutoLottoCount lottoCount) {
        List<LottoNumber> numbers = new ArrayList<>();
        LottoNumberFactory lottoNumberCreate = new LottoNumberFactory();
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberCreate.createLottoRandomNumber());
            Output.printLottoNumber(lottoNumber.getLottoNumbers());
            numbers.add(lottoNumber);
        }
        return numbers;
    }
}
