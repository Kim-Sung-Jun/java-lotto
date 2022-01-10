package domain;

import view.Input;
import view.Output;

import java.util.*;

public class LottoNumberFactory {

    public static final int MAX_LOTTO_TOTAL_NUMBER = 45;
    public static final int MIN_LOTTO_TOTAL_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER_LENGTH_INDEX = 6;
    private static final int MIN_LOTTO_NUMBER_LENGTH_INDEX = 0;

    private static final Set<Integer> LOTTO_NUMBERS_STORAGE = new HashSet<>();

    static {
        for (int i = MIN_LOTTO_TOTAL_NUMBER; i <= MAX_LOTTO_TOTAL_NUMBER; i++) {
            LOTTO_NUMBERS_STORAGE.add(i);
        }
    }

    public static LottoNumber createLottoRandomNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBERS_STORAGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = new ArrayList<>(lottoNumbers.subList(
                MIN_LOTTO_NUMBER_LENGTH_INDEX, MAX_LOTTO_NUMBER_LENGTH_INDEX));
        Collections.sort(lottoNumbers);
        return new LottoNumber(lottoNumbers);
    }

    public static LottoNumber createInputLottoNumber(String inputLottoNumber) {
        List<Integer> inputLottoNumbers = new ArrayList<>();
        try {
            String[] lottoWinningNumbers = inputLottoNumber.split(",");
            for (String number : lottoWinningNumbers) {
                inputLottoNumbers.add(Integer.parseInt(number.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력하셨습니다.");
        }
        return new LottoNumber(inputLottoNumbers);
    }

    public static LottoNumbers createManualLottoNumberByMoney(long manualLottoPurchaseCount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Output.printInputMsg("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoPurchaseCount; i++) {
            lottoNumbers.add(createInputLottoNumber(Input.inputLottoNumber()));
        }
        return new LottoNumbers(lottoNumbers);
    }

}

