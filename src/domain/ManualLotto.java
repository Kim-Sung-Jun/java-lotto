package domain;

public class ManualLotto {

    private final long manualLottoPurchaseCount;

    public ManualLotto(Money money, String manualLottoPurchaseCount) {
        this.manualLottoPurchaseCount = validate(money, manualLottoPurchaseCount);

    }

    private long validate(Money money, String manualLottoPurchaseCount) {
        return validateInputType(money, manualLottoPurchaseCount);
    }

    private long validateInputType(Money money, String manualLottoPurchaseCount) { //타입 불일치시 예외발생
        try {
            return validateManualLottoPurchaseCount(money, Long.parseLong(manualLottoPurchaseCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private long validateManualLottoPurchaseCount(Money money, long manualLottoPurchaseCount) {
        money.calculateManualLottoCount(manualLottoPurchaseCount);
        return manualLottoPurchaseCount;
    }


    public long getManualLottoPurchaseCount() {
        return this.manualLottoPurchaseCount;
    }

}
