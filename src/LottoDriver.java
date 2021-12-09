public class LottoDriver {

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        Money money = new Money(Input.inputMoney());
        lottoManager.proceed(money);


    }
}
