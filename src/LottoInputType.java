public class LottoInputType {

    private long inputNumber = 0;

    public LottoInputType(String input) {
        validate(input);
    }

    private void validate(String input) {
        validateInputType(input);
    }

    private void validateInputType(String input) {
        if (!isStringLong(input)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isStringLong(String input) {
        try {
            inputNumber = Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private long getInputNumber() {
        return inputNumber;
    }

}
