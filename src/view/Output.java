package view;

import domain.*;

import java.util.List;

public class Output {

    public static void printLottoNumber(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printInputMsg(String msg) {
        System.out.println(msg);
    }

    public static void printLottoCount(ManualLottoCount manualLotto, Money money) {
        System.out.println("수동으로" + manualLotto.getManualLottoPurchaseCount()
                + "장, " + "자동으로" + money.calculateAutomaticLottoCount() + "개를 구매했습니다.");
    }

    public static void printRanking(LottoWinningResults totalLottoRankingCount) { //여기서 전달 받아 출력만 해주는게 맞는거임
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Ranking ranking : Ranking.values()) {
            validateRanking(ranking, totalLottoRankingCount);
        }
    }

    public static void validateRanking(Ranking ranking, LottoWinningResults totalLottoRankingCount) {
        if (Ranking.SECOND == ranking) {
            System.out.println(ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().getOrDefault(ranking,
                            new RankingCount(UserLottoNumberMatchingCount.DEFAULT_VALUE)).getPrizeCount() + "개");
        } else if (ranking.getMatchCount() > UserLottoNumberMatchingCount.DEFAULT_VALUE) {
            System.out.println(ranking.getMatchCount() + "개 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking).getPrizeCount() + "개");
        }
    }

    public static void printProfitsRate(WinningLottoAmount totalValue, Money money) {
        System.out.println("총 수익률은 " + String.format("%.2f",
                ((double) totalValue.getTotal() / (double) money.getAmount())) + "입니다.");
    }

}
