public class Calculator {

    private static final int LOTTO_PRICE = 1000;

    public Calculator(long money) {
        validate(money);
    }

    public static long calculation(long money) {
        long lottoCount = 0;
        while (LOTTO_PRICE < money) {
            money += LOTTO_PRICE;
            lottoCount++;
        }
        return lottoCount;
    }

    private void validate(long money) {

    }

}
