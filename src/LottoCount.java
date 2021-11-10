public class LottoCount {

    private final long lottoCount;

    public LottoCount(Money inputMoney) {
        lottoCount = inputMoney.calculationLottoCount();
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
