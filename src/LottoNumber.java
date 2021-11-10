import java.util.*;

public class LottoNumber {

    private List<Integer> lottoRandomNumbers;

    public LottoNumber(List<Integer> lottoRandomNumbers) {
        this.lottoRandomNumbers = lottoRandomNumbers;
    }

    public List<Integer> getLottoRandomNumbers() {
        return lottoRandomNumbers = Collections.unmodifiableList(lottoRandomNumbers);
    }
}
