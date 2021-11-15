public class BonusNumber {

    private final int number;

    public BonusNumber(String bonusNumber) {
        this.number = validateBonusNumberType(bonusNumber);
    }

    private int validateBonusNumberType(String bonusNumber) {
        try {
            int number = Integer.parseInt(bonusNumber);
            validateNumberSize(number);
            return number;
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

    public int getNumber() {
        return number;
    }
}
