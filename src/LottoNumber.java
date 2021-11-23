import java.util.*;

public class LottoNumber {

    private static final int LENGTH_DELIMITER = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumber(List<Integer> lottoRandomNumber) {
        validate(lottoRandomNumber);
        this.lottoNumbers = new ArrayList<>(lottoRandomNumber);
    }

    private void validate(List<Integer> lottoRandomNumber) {
        validateLength(lottoRandomNumber);
    }

    private void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 모자릅니다.");
        }
        if (lottoNumbers.size() > LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 너무 많습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
