public class Money {

    private static final int LOTTO_PRICE = 1000;

    private long money = 0;

    public Money(String money) {
        validate(money);
    }

    private void validate(String money) {
        validateInputMoneyType(money);
    }

    private void validateInputMoneyType(String money) { //타입 불일치시 예외발생
        if (!isNumber(money)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String money) { //타입검사
        try {
            this.money = Long.parseLong(money);
            if (this.money < 1000) {
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
        return money / LOTTO_PRICE;
    }
}
