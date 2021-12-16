public class LottoDriver {

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        try {
            Money money = new Money(Input.inputMoney());
            lottoManager.proceed(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("문제가 생겨 종료하였습니다.");
        }
    }
}
