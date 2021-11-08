public class LottoCount {

    private long lottoCount = 0;

    public LottoCount(Money inputMoney) {
        lottoCount = inputMoney.calculationLottoCount();
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
