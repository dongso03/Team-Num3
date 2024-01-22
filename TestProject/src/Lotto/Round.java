package Lotto;

// 구매할때마다 회차 생성해서 정보 저장하는 클래스

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;

public class Round {

    public static Map<Integer, List<JLabel[]>> lottoHistory = new HashMap<>();
    public static int currentRound = 1;


    // 사용자가 선택한 로또 번호를 받아오기
    public static JLabel[] yourSelectedLottoNumbers() {
    	PurchaseGUI.getSelectedNumbers();
        return new JLabel[currentRound];
    }

    // 사용자가 로또 번호를 선택할 때마다 회차를 생성하고 저장
    public static void selectLottoNumbers() {
        JLabel[] selectedNumbers = yourSelectedLottoNumbers();
        saveLottoNumbers(currentRound, selectedNumbers);
        currentRound++;
    }

    // 선택한 로또 번호를 지정된 회차에 저장
    public static void saveLottoNumbers(int round, JLabel[] selectedNumbers) {
        List<JLabel[]> roundNumbers = lottoHistory.getOrDefault(round, new ArrayList<>());
        roundNumbers.add(selectedNumbers);
        lottoHistory.put(round, roundNumbers);
    }

    // 저장된 로또 번호를 출력
    public static void printLottoHistory() {
        for (Map.Entry<Integer, List<JLabel[]>> entry : lottoHistory.entrySet()) {
            int round = entry.getKey();
            List<JLabel[]> roundNumbers = entry.getValue();

            System.out.println("Round " + round + " Lotto Numbers:");
            for (JLabel[] selectedNumbers : roundNumbers) {
                System.out.print("  Lotto Numbers: ");
                for (JLabel number : selectedNumbers) {
                    // 각 번호 출력 또는 다른 작업 수행
                    System.out.print(number.getText() + " ");
                }
                System.out.println();
            }
        }
    }
}

