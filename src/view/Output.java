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

    public static void printLottoCount(AutomaticLottoCount lottoCount) { //여기서 로또 카운트는 자동을 의미함 //자동 앞에 수동 만들어주기
        System.out.println("자동으로 " + lottoCount.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printRanking(TotalLottoRankingCount totalLottoRankingCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Ranking ranking : Ranking.values()) {
            validateRanking(ranking, totalLottoRankingCount);
        }
    }

    public static void validateRanking(Ranking ranking, TotalLottoRankingCount totalLottoRankingCount) {
        if (Ranking.SECOND == ranking) {
            System.out.println(ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().getOrDefault(ranking,
                            new PrizeCount(SameValueCount.DEFAULT_VALUE)).getPrizeCount() + "개"); //새로운 방법
        } else if (ranking.getMatchCount() > SameValueCount.DEFAULT_VALUE) {
            System.out.println(ranking.getMatchCount() + "개 일치 (" + ranking.getPrizeMoney() + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking).getPrizeCount() + "개");
        }
    }

    public static void printProfitsRate(TotalValue totalValue, Money money) {
        System.out.println("총 수익률은 " + String.format("%.2f",
                ((double) totalValue.getTotal() / (double) money.getAmount())) + "입니다.");
    }

}
