import java.util.ArrayList;
import java.util.List;

public class LottoNumbersFactory {

    public static void createLottoNumberByMoney(LottoCount lottoCount) {  //클래스 따로 분리해주기
        List<LottoNumber> numbers = new ArrayList<>();
        LottoNumberFactory lottoNumberCreate = new LottoNumberFactory();
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberCreate.createLottoRandomNumber());
            Output.printLottoNumber(lottoNumber.getLottoRandomNumbers());
            numbers.add(lottoNumber);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(numbers); //매니저에서 얘를 써야하기 때문에 리턴 고려해봐야함
    }
}
