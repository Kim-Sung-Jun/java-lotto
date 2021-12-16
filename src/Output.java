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

    public static void printRanking() {
        for (Ranking ranking : Ranking.values()) {
            validateRanking(ranking);
        }
    }

    public static void validateRanking(Ranking ranking) {
        if (Ranking.SECOND == ranking) {
            System.out.println(ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getPrizeMoney() + "원) - ");
        } else if (ranking.getMatchCount() > SameValueCount.DEFAULT_VALUE) { //상수처리
            System.out.println(ranking.getMatchCount() + "개 일치 (" + ranking.getPrizeMoney() + "원) - ");
        }
    }

    public static void printExceptionMsg(String msg) {
        System.out.println(msg);
    }
}
