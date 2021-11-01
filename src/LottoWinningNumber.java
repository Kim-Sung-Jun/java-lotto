import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumber {

    private final List<Integer> lottoWinningNumbers = new ArrayList<>();

    public LottoWinningNumber(String lottoWinningNumber) {
        createLottoWinningNumbers(lottoWinningNumber);
    }

    private void createLottoWinningNumbers(String lottoWinningNumber) {
        String[] lottoWinningNumbers = lottoWinningNumber.trim().split(",");
        for (String number : lottoWinningNumbers) {
            validateLottoWinningNumberType(number);
        }
    }

    private void validateLottoWinningNumberType(String number) {
        try {
            this.lottoWinningNumbers.add(Integer.parseInt(number));
        } catch (NumberFormatException ignored) {
            Output.printExceptionMsg("숫자가 아닙니다.");
        }
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }
}
