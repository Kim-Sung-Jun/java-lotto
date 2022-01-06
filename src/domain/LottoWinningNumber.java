package domain;

import java.util.List;

public class LottoWinningNumber {

    private final LottoNumber lottoNumber;
    private final BonusNumber bonusNumber;

    public LottoWinningNumber(List<Integer> lottoWinningNumber, BonusNumber bonusNumber) {
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
