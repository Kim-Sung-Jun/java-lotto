import java.util.ArrayList;
import java.util.List;

public class WinningNumberFactory {

    public static List<Integer> transformWinningNumber(String winningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String[] lottoWinningNumbers = winningNumber.trim().replace(" ", "").split(",");
            for (String number : lottoWinningNumbers) { //여기서 IllegalArgumentException 발생하지 않음
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) { //입력값이 숫자가 아니면 잡아낸다
            throw new IllegalArgumentException("당첨 번호를 잘못 입력하셨습니다.");
        }
        return winningNumbers;
    }
}
