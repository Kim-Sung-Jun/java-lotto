import java.util.List;

public class LottoWinningNumber extends LottoNumber {

    private final BonusNumber bonusNumber;

    public LottoWinningNumber(List<Integer> lottoWinningNumber, BonusNumber bonusNumber) {
        super(lottoWinningNumber);
        this.bonusNumber = bonusNumber;
    }

}
