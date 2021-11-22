public class LottoCount {

    private final long lottoCount;

    public LottoCount(Money inputMoney) { //머니에서 검증해서 넘어옴
        lottoCount = inputMoney.calculationLottoCount();
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
