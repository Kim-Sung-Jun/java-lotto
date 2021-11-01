public class LottoCount {

    private static final int LOTTO_PRICE = 1000;

    private long lottoCount = 0;

    public LottoCount(long inputMoney) {
        lottoCount = inputMoney / LOTTO_PRICE;
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
