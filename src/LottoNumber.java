import java.util.*;

public class LottoNumber {

    private final List<Integer> lottoRandomNumber;

    public LottoNumber(List<Integer> lottoRandomNumber) {
        this.lottoRandomNumber = new ArrayList<>(lottoRandomNumber);
    }

    public List<Integer> getLottoRandomNumbers() {
        return Collections.unmodifiableList(lottoRandomNumber);
    }
}
