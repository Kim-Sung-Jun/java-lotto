package domain;

import java.util.List;

public class ManualLotto {

    private final long manualLottoPurchaseCount;

    public ManualLotto(Money money, String manualLottoPurchaseCount) {
        this.manualLottoPurchaseCount = validate(money, manualLottoPurchaseCount);

    }

    public List<LottoNumber> createManualLottoByManualLottoCount() {
        return LottoNumberFactory.createManualLottoNumberByMoney(this.manualLottoPurchaseCount);
    }

    private long validate(Money money, String manualLottoPurchaseCount) {
        return validateInputType(money, manualLottoPurchaseCount);
    }

    private long validateInputType(Money money, String manualLottoPurchaseCount) {
        try {
            return validateManualLottoPurchaseCount(money, Long.parseLong(manualLottoPurchaseCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private long validateManualLottoPurchaseCount(Money money, long manualLottoPurchaseCount) {
        money.validateEnoughMoney();
        money.calculateAmountByManualLottoCount(manualLottoPurchaseCount);
        return manualLottoPurchaseCount;
    }

    public long getManualLottoPurchaseCount() {
        return this.manualLottoPurchaseCount;
    }

}
