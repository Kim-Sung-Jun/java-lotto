package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private static final int LENGTH_DELIMITER = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumbers = new ArrayList<>(validate(lottoNumber));
    }

    private List<Integer> validate(List<Integer> lottoRandomNumber) {
        validateLength(lottoRandomNumber);
        for (Integer integer : lottoRandomNumber) {
            validateValueRange(integer);
        }
        return lottoRandomNumber;
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

    public void repeatLottoNumberCheck(LottoNumber lottoNumber, UserLottoNumberMatchingCount sameValueCount) {
        for (int i = 0; i < lottoNumber.lottoNumbers.size(); i++) {
            compareLottoNumber(lottoNumber, i, sameValueCount); //포이츠 쓸 것
        }
    }

    private void compareLottoNumber(LottoNumber lottoNumber, int i, UserLottoNumberMatchingCount sameValueCount) {
        if (this.lottoNumbers.contains(lottoNumber.lottoNumbers.get(i))) { //좋지않은방법임
            sameValueCount.plus();
        }
    }

    public boolean isBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isBonusNumber(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
