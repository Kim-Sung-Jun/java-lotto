import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumber extends LottoNumber {

    private static final int LENGTH_DELIMITER = 6;

    private final List<Integer> lottoWinningNumbers;

    public LottoWinningNumber(String lottoWinningNumber, BonusNumber bonusNumber) {
        super(lottoRandomNumber);
        this.lottoWinningNumbers = new ArrayList<>(createLottoWinningNumbers(lottoWinningNumber));
    }

    private List<Integer> createLottoWinningNumbers(String lottoWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        lottoWinningNumber = lottoWinningNumber.trim().replace(" ", "");
        String[] lottoWinningNumbers = lottoWinningNumber.split(",");
        validateLength(lottoWinningNumbers);
        for (String number : lottoWinningNumbers) {
            validateLottoWinningNumberType(number, winningNumbers);
        }
        return winningNumbers;
    }

    private void validateLength(String[] lottoWinningNumbers) {
        if (lottoWinningNumbers.length < LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 모자릅니다.");
        }
        if (lottoWinningNumbers.length > LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 너무 많습니다.");
        }
    }

    private void validateLottoWinningNumberType(String number, List<Integer> winningNumbers) {
        try {
            winningNumbers.add(Integer.parseInt(number));
        } catch (NumberFormatException ignored) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    public List<Integer> getLottoWinningNumbers() {
        return Collections.unmodifiableList(lottoWinningNumbers);
    }
}
