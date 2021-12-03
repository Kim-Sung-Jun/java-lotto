import java.util.List;

public class LottoWinningNumber extends LottoNumber {

    private final BonusNumber bonusNumber; //보너스볼을 받을때 위닝넘버가 위닝넘버리스트에 보너스볼이 중복인지 검사를 해서 다시 입력하게끔 해야함

    public LottoWinningNumber(List<Integer> lottoWinningNumber, BonusNumber bonusNumber) {
        super(lottoWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber getBonusNumber() {

        return bonusNumber;
    }

    public void 비교(LottoNumber lottoNumber) { //이건 값을 보낸게 아님님
        super.compare(lottoNumber); //보너스넘버는 위닝이 가지고 있다
    }
}
