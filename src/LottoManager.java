import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public void proceed(Money money) {
        LottoCount lottoCount = new LottoCount(money);
        Output.printLottoCount(lottoCount);
        Calculate(lottoCount);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
                transformWinningNumber(Input.inputLottoWinningNumber()), new BonusNumber(Input.inputBonusNumber()));
    }

    private List<Integer> transformWinningNumber(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String[] lottoWinningNumbers = winningNumber.trim().replace(" ", "").split(",");
            for (String number : lottoWinningNumbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력하셨습니다.");
        }
        return winningNumbers;
    }

    private void Calculate(LottoCount lottoCount) {
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
