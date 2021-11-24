import java.util.List;

public class LottoWinningNumber extends LottoNumber {

    private final BonusNumber bonusNumber;

    public LottoWinningNumber(List<Integer> lottoWinningNumber, BonusNumber bonusNumber) {
        super(lottoWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public void 비교(LottoWinningNumber lottoWinningNumber, LottoNumber lottoNumber) { //이건 값을 보낸게 아님님
       //이 메소드가 계산기로 가야함

    }

}
