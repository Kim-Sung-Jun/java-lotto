import java.util.List;

public class Output {

    public static void printLottoNumber(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printInputMsg(String msg) {
        System.out.println(msg);
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.println(lottoCount.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
