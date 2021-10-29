import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumber {

    private static final int MAX_LOTTO_TOTAL_NUMBER = 45;
    private static final int MIN_LOTTO_TOTAL_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER_LENGTH_INDEX = 5;
    private static final int MIN_LOTTO_NUMBER_LENGTH_INDEX = 0;

    private static final List<Integer> lottoNumbersStorage = new ArrayList<>();
    //Set을 활용?

    static {
        for (int i = MIN_LOTTO_TOTAL_NUMBER ; i < MAX_LOTTO_TOTAL_NUMBER; i++) {
            lottoNumbersStorage.add(i);
        }
    }

    public LottoRandomNumber() {
        lottoRandomNumberCreate();
    }

    private void lottoRandomNumberCreate() {
        Collections.shuffle(lottoNumbersStorage);
        List<Integer> lottoNumbers = new ArrayList<>(lottoNumbersStorage.subList(
                MIN_LOTTO_NUMBER_LENGTH_INDEX, MAX_LOTTO_NUMBER_LENGTH_INDEX));
        Collections.sort(lottoNumbers);
    }
}
