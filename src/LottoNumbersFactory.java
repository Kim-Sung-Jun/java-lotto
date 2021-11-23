import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

    public static List<LottoNumber> createLottoNumberByMoney(LottoCount lottoCount) {  //클래스 따로 분리해주기
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
