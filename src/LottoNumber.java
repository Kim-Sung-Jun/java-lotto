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
        //사이즈
        for (int i = 0; i < lottoRandomNumber.size(); i++) { // 2021.12.16 해결하는중
            validateValueRange(lottoRandomNumber.get(i));
        }
    }

    private void validateValueRange(int number) {
        if (number > LottoNumberFactory.MAX_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 큽니다.");
        } else if (number < LottoNumberFactory.MIN_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 작습니다.");
        }
    }

    private void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 모자릅니다.");
        }
        if (lottoNumbers.size() > LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 너무 많습니다.");
        }
    }

    public void repeatLottoNumberCheck(LottoNumber lottoNumber, SameValueCount sameValueCount) {
        for (int i = 0; i < lottoNumber.getLottoNumbers().size(); i++) {
            compareLottoNumber(lottoNumber, i, sameValueCount);
        }
//        boolean bonusBall = false;
//        if (count == 5) {
//            bonusBall = compareBonusNumber(bonusNumber);
//        }
    }

    private void compareLottoNumber(LottoNumber lottoNumber, int i, SameValueCount sameValueCount) {
        if (this.lottoNumbers.contains(lottoNumber.getLottoNumbers().get(i))) {
            sameValueCount.plus();
        }
    }

    public boolean isBonusNumber(BonusNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber.getNumber());
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
