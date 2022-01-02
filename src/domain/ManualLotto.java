package domain;

public class ManualLotto {

    private final long manualLottoPurchaseCount;

    public ManualLotto(Money money, String manualLottoPurchaseCount) {
        this.manualLottoPurchaseCount = validate(money, manualLottoPurchaseCount);

    }

    private long validate(Money money, String manualLottoPurchaseCount) {
        validateManualLottoPurchaseCount(money);
        return validateInputType(manualLottoPurchaseCount);
    }

    private void validateManualLottoPurchaseCount(Money money) {
        money.calculateManualLottoCount(manualLottoPurchaseCount);
    }

    private long validateInputType(String manualLottoPurchaseCount) { //타입 불일치시 예외발생
        try {
            return Long.parseLong(manualLottoPurchaseCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public long getManualLottoPurchaseCount() {
        return this.manualLottoPurchaseCount;
    }

}
