import java.util.*;

public class LottoNumber {

    private static final int LENGTH_DELIMITER = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumber(List<Integer> lottoRandomNumber) {
        validate(lottoRandomNumber);
        this.lottoNumbers = new ArrayList<>(lottoRandomNumber);
    }

    private void validate(List<Integer> lottoRandomNumber) {
        validateLength(lottoRandomNumber);
    }

    private void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 모자릅니다.");
        }
        if (lottoNumbers.size() > LENGTH_DELIMITER) {
            throw new IllegalArgumentException("숫자가 너무 많습니다.");
        }
    }

    public void compare(LottoNumber lottoNumber, BonusNumber bonusNumber) {
        int count = 0;
        for (int i = 0; i < lottoNumber.getLottoNumbers().size(); i++) {
            count = compareLottoNumber(lottoNumber, i, count);
        }
        boolean bonusBall = false;
        if (count == 5) {
            bonusBall = compareBonusNumber(bonusNumber);
        }
        Ranking.getRanking(count, bonusBall);
    }

    private int compareLottoNumber(LottoNumber lottoNumber, int i, int count) {
        if (this.lottoNumbers.contains(lottoNumber.getLottoNumbers().get(i))) {
            count++;
        }
        return count;
    }

    private boolean compareBonusNumber(BonusNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber.getNumber());
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
