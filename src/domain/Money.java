package domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private long amount = 0;

    public Money(String amount) {
        validate(amount);
    }

    private void validate(String amount) {
        validateInputMoneyType(amount);
    }

    private void validateInputMoneyType(String amount) {
        if (!isNumber(amount)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String amount) {
        try {
            this.amount = Long.parseLong(amount); //생성자에서 값을 초기화주는게 원래 맞는거임
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

    public long calculateAutomaticLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public void calculateAmountByManualLottoCount(long manualLottoPurchaseCount) {
        this.amount -= (manualLottoPurchaseCount * LOTTO_PRICE);
    }

    public void validateEnoughMoney() {
        if (this.amount < LOTTO_PRICE) {
            validateMoney();
        }
    }

    public long getAmount() {
        return this.amount;
    }

}
