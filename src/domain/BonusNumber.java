package domain;

import java.util.List;

public class BonusNumber {

    private final int number;

    public BonusNumber(String inputBonusNumber) {
        this.number = validate(inputBonusNumber);
    }

    public boolean isBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.number);
    }

    private int validate(String inputBonusNumber) {
        int bonusNumber = validateBonusNumberType(inputBonusNumber);
        validateNumberSize(bonusNumber);
        return bonusNumber;
    }

    private int validateBonusNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validateNumberSize(int number) {
        if (number > LottoNumberFactory.MAX_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 큽니다");
        }
        if (number < LottoNumberFactory.MIN_LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 작습니다");
        }
    }

}
