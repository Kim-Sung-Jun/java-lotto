public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumberType(bonusNumber);
    }


    private void validateBonusNumberType(String bonusNumber) {
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String bonusNumber) {
        try {
            this.bonusNumber = Integer.parseInt(bonusNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
