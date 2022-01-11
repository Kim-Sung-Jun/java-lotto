package view;

import domain.LottoWinningResults;
import domain.ManualLottoCount;
import domain.Money;
import domain.Ranking;

import java.util.List;

public class Output {

    private static final int MIN_MATCH_LOTTO_NUMBER_COUNT = 0;

    public static void printLottoNumber(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoCount(ManualLottoCount manualLotto, Money money) {
        System.out.println("수동으로 " + manualLotto.getManualLottoPurchaseCount()
                + "장, " + "자동으로 " + money.calculateAutomaticLottoCount() + "개를 구매했습니다.");
    }

    public static void printRankingMsg() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printRanking(Ranking ranking, LottoWinningResults totalLottoRankingCount) {
        if (Ranking.SECOND == ranking) {
            System.out.println(ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking) + "개");
        } else if (ranking.getMatchCount() > MIN_MATCH_LOTTO_NUMBER_COUNT) {
            System.out.println(ranking.getMatchCount() + "개 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking) + "개");
        }
    }

    public static void printProfitsRate(int totalAmount, Money money) {
        System.out.println("총 수익률은 " + String.format("%.2f",
                ((double) totalAmount / (double) money.getAmount())) + "입니다.");
    }

}
