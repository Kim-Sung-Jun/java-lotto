public class Calculator {

    private static final int LOTTO_PRICE = 1000;

    public Calculator(long amount) {
        validate(amount);
    }

    public static long calculation(long amount) {
        long lottoCount = 0;
        while (LOTTO_PRICE < amount) {
            amount += LOTTO_PRICE;
            lottoCount++;
        }
        return lottoCount;
    }

    private void validate(long amount) {

    }

}
