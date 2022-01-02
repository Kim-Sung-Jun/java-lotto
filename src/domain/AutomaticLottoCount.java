package domain;

public class AutomaticLottoCount {

    private final long automaticLottoPurchaseCount;

    public AutomaticLottoCount(Money inputMoney) { //머니에서 검증해서 넘어옴
        automaticLottoPurchaseCount = inputMoney.calculateAutomaticLottoCount();
    }

    public long getLottoCount() {
        return automaticLottoPurchaseCount;
    }

}
