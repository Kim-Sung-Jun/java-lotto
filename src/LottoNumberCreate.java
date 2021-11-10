import java.util.*;

public class LottoNumberCreate {

    private static final int MAX_LOTTO_NUMBER_LENGTH_INDEX = 5;
    private static final int MIN_LOTTO_NUMBER_LENGTH_INDEX = 0;
    private static final int MAX_LOTTO_TOTAL_NUMBER = 45;
    private static final int MIN_LOTTO_TOTAL_NUMBER = 1;

    private static final Set<Integer> LOTTO_NUMBERS_STORAGE = new HashSet<>();

    static {
        for (int i = MIN_LOTTO_TOTAL_NUMBER; i < MAX_LOTTO_TOTAL_NUMBER; i++) {
            LOTTO_NUMBERS_STORAGE.add(i);
        }
    }

    public List<Integer> createLottoRandomNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBERS_STORAGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = new ArrayList<>(lottoNumbers.subList(
                MIN_LOTTO_NUMBER_LENGTH_INDEX, MAX_LOTTO_NUMBER_LENGTH_INDEX));
        Collections.sort(lottoNumbers);
        return lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }
}
