public class Money {

    private static final int LOTTO_PRICE = 1000;

    private long amount = 0;

    public Money(String amount) { //생성자는 항상 값을 초기화, 검증만 해준다
        validate(amount);
    }

    private void validate(String amount) {
        validateInputMoneyType(amount);
    }

    private void validateInputMoneyType(String amount) { //타입 불일치시 예외발생
        if (!isNumber(amount)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String amount) { //타입검사
        try {
            this.amount = Long.parseLong(amount);
            if (this.amount < LOTTO_PRICE) {
                validateMoney();
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateMoney() {
        throw new IllegalArgumentException("금액이 부족합니다.");
    }

    public long calculationLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public long getAmount() {
        return this.amount;
    }
}
