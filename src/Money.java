public class Money {

    private long money = 0;

    public Money(String money) {
        validate(money);
    }

    private void validate(String money) {
        validateInputMoneyType(money);
    }

    private void validateInputMoneyType(String money) {
        if (!isNumber(money)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String money) {
        try {
            this.money = Long.parseLong(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private long getMoney() {
        return money;
    }
}
