package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.LottoWinningResults.DEFAULT;
import static domain.LottoWinningResults.INCREASED_VALUE;

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

    public int repeatLottoNumberCheck(LottoNumber lottoNumber) {
        int lottoNumberMatchCount = DEFAULT;
        for (int i : lottoNumber.lottoNumbers) {
            lottoNumberMatchCount = compareLottoNumber(i, lottoNumberMatchCount);
        }
        return lottoNumberMatchCount;
    }

    private int compareLottoNumber(int i, int lottoNumberMatchCount) {
        if (this.lottoNumbers.contains(i)) {
            return lottoNumberMatchCount + INCREASED_VALUE;
        }
        return lottoNumberMatchCount;
    }

    public boolean isBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isBonusNumber(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
