import java.util.*;

public class LottoRandomNumberCreate {

    private static final int MAX_LOTTO_NUMBER_LENGTH_INDEX = 5;
    private static final int MIN_LOTTO_NUMBER_LENGTH_INDEX = 0;

    private List<Integer> lottoNumbers;

    public LottoRandomNumberCreate(long count) {

    }

    public LottoRandomNumberCreate(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> createLottoRandomNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBERS_STORAGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = new ArrayList<>(lottoNumbers.subList(
                MIN_LOTTO_NUMBER_LENGTH_INDEX, MAX_LOTTO_NUMBER_LENGTH_INDEX));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
