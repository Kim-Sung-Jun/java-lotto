import java.util.HashSet;
import java.util.Set;

public class LottoNumber {

    private static final int MAX_LOTTO_TOTAL_NUMBER = 45;
    private static final int MIN_LOTTO_TOTAL_NUMBER = 1;

    private static final Set<Integer> LOTTO_NUMBERS_STORAGE = new HashSet<>();

    static {
        for (int i = MIN_LOTTO_TOTAL_NUMBER; i < MAX_LOTTO_TOTAL_NUMBER; i++) {
            LOTTO_NUMBERS_STORAGE.add(i);
        }
    }

    public LottoNumber() {

    }
}
