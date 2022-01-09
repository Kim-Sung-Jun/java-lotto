package domain;

import java.util.List;

public class LottoWinningNumber {

    private final LottoNumber lottoNumber;
    private final BonusNumber bonusNumber;

    public LottoWinningNumber(List<Integer> lottoWinningNumber, BonusNumber bonusNumber) { //여기서 리스트를 받는건 이상함 객체를 받아야함
        this.lottoNumber = new LottoNumber(lottoWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public void compareLottoNumbers(LottoNumber lottoNumber, UserLottoNumberMatchingCount sameValueCount) {
        this.lottoNumber.repeatLottoNumberCheck(lottoNumber, sameValueCount);
    }

    public boolean findBonusNumber() {
        return lottoNumber.isBonusNumber(bonusNumber);
    }

}
