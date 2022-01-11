package domain;

public class LottoWinningNumber {

    private final LottoNumber lottoNumber;
    private final BonusNumber bonusNumber;

    public LottoWinningNumber(LottoNumber lottoWinningNumber, BonusNumber bonusNumber) {
        this.lottoNumber = lottoWinningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int compareLottoNumbers(LottoNumber lottoNumber) {
        return this.lottoNumber.repeatLottoNumberCheck(lottoNumber);
    }

    public boolean findBonusNumber() {
        return lottoNumber.isBonusNumber(bonusNumber);
    }

}
