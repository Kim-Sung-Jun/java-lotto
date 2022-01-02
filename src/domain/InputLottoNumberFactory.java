package domain;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumberFactory { //얘가 보너스볼도 파라미터로 받아서 여가서 위닝넘버로 연결 // 리플레이스는 성능 개구지고 안좋음

    public static List<Integer> transformWinningNumber(String inputLottoNumber) { //여기가 제일 마음에 들지 않음
        List<Integer> inputLottoNumbers = new ArrayList<>();
        try {
            String[] lottoWinningNumbers = inputLottoNumber.trim().replace(" ", "").split(",");
            for (String number : lottoWinningNumbers) { //여기서 IllegalArgumentException 발생하지 않음
                inputLottoNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) { //입력값이 숫자가 아니면 잡아낸다
            throw new IllegalArgumentException("당첨 번호를 잘못 입력하셨습니다.");
        }
        return inputLottoNumbers; //22.1.2 수동넘버 위닝넘버 여기서 리스트로 만들어줌
    }

}
