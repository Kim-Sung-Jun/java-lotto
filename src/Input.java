import java.util.Scanner;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputMoney() {
        Output.printInputMsg("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputLottoWinningNumber() {
        Output.printInputMsg("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputBonusNumber() {
        Output.printInputMsg("보너스 볼을 입력해 주세요");
        return SCANNER.next();
    }
}
