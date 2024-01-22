package Lotto;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class WinningGUI extends JFrame {
	FirstPage firstPage;
	private JLabel lblNewLabel_5;
	private JPanel pirntNumbersA;
	private JPanel pirntNumbersB;
	private JPanel pirntNumbersC;
	private JPanel pirntNumbersD;
	private JPanel pirntNumbersE;
	private JLabel[] lblAs;

	public WinningGUI(FirstPage firstPage) {
		setTitle("당첨확인");
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JLabel lbl = new JLabel("구매 내역: ");
		lbl.setBounds(73, 24, 84, 15);
		pnl.add(lbl);

		String[] list = new String[] { "", "1회차", "당첨된 것만 보기" };
		JComboBox comboBox = new JComboBox(list);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
//            if(comboBox.equals("1회차")) {
//               lblNewLabel_5.setText(FirstPage.customer.lottoList);
//            }
			}
		});
		comboBox.setBounds(169, 21, 178, 21);
		pnl.add(comboBox);

		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		panel.setBounds(79, 65, 372, 64);
		pnl.add(panel);
		panel.setLayout(null);

		// 당첨 숫자 라벨
		JLabel result_1 = new JLabel("");
		result_1.setBounds(12, 10, 28, 27);
		panel.add(result_1);

		JLabel result_2 = new JLabel("");
		result_2.setBounds(52, 10, 28, 27);
		panel.add(result_2);

		JLabel result_3 = new JLabel("");
		result_3.setBounds(92, 10, 28, 27);
		panel.add(result_3);

		JLabel result_4 = new JLabel("");
		result_4.setBounds(132, 10, 28, 27);
		panel.add(result_4);

		JLabel result_5 = new JLabel("");
		result_5.setBounds(171, 9, 28, 27);
		panel.add(result_5);

		JLabel result_6 = new JLabel("");
		result_6.setBounds(211, 9, 28, 27);
		panel.add(result_6);

		JLabel lblNewLabel_2_1_1 = new JLabel("+");
		lblNewLabel_2_1_1.setBounds(251, 10, 17, 27);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3 = new JLabel("당첨 번호");
		lblNewLabel_3.setBounds(102, 39, 57, 15);
		panel.add(lblNewLabel_3);

		JLabel result_7 = new JLabel("");
		result_7.setBounds(292, 10, 28, 27);
		panel.add(result_7);

		JLabel lblNewLabel_4 = new JLabel("보너스");
		lblNewLabel_4.setBounds(292, 39, 57, 15);
		panel.add(lblNewLabel_4);

		Random ran = new Random();
		// 숫자 7개를 랜덤으로 뽑아내는데 6개는 오름차순으로, 하나는 보너스
		// n1~n7까지 숫자가 중복안되게 수정 필요!!!!
		// ----------------------------
		Set<Integer> uniqueNumbers = new HashSet<>();

		// 중복되지 않는 6개의 난수 생성(보너스 숫자 포함x)
		while (uniqueNumbers.size() < 7) {
			int randomNumber = ran.nextInt(45) + 1;
			uniqueNumbers.add(randomNumber);
		}

		// List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);
		Set<Integer> resultList = new TreeSet<>(uniqueNumbers);
		List<Integer> uniqueList = new ArrayList<>(resultList);
		result_1.setText(String.valueOf(uniqueList.get(0)));
		result_2.setText(String.valueOf(uniqueList.get(1)));
		result_3.setText(String.valueOf(uniqueList.get(2)));
		result_4.setText(String.valueOf(uniqueList.get(4)));
		result_5.setText(String.valueOf(uniqueList.get(5)));
		result_6.setText(String.valueOf(uniqueList.get(6)));
		result_7.setText(String.valueOf(uniqueList.get(3)));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 162, 411, 23);
		pnl.add(panel_1);
		panel_1.setLayout(null);

		JLabel purchaseNumber = new JLabel("구매 번호");
		purchaseNumber.setBounds(131, 0, 191, 29);
		panel_1.add(purchaseNumber);

		JLabel winningResult = new JLabel("당첨 결과");
		winningResult.setBounds(334, 0, 77, 29);
		panel_1.add(winningResult);

		JButton btnNewButton = new JButton("처음 화면으로 돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstPage.setVisible(true);
				dispose();

			}
		});

		btnNewButton.setBounds(273, 428, 178, 23);
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("당첨규칙 확인하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그 만들기
				JDialog dia = new MyDialog(WinningGUI.this);
				dia.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(12, 428, 178, 23);
		pnl.add(btnNewButton_1);

		pirntNumbersA = new JPanel();
		pirntNumbersA.setBounds(64, 195, 283, 34);
		pnl.add(pirntNumbersA);

		lblAs = new JLabel[8];

		// "A"라벨을 패널에 추가
		lblAs[0] = new JLabel("A");
		pirntNumbersA.add(lblAs[0]);

		// 로또 번호를 패널에 추가
		if (FirstPage.customer.lottoList.containsKey(1)) {
			JLabel[] lottoNumbers = FirstPage.customer.lottoList.get(1);

			// lottoNumbers 배열이 null이 아닌지 확인
			if (lottoNumbers != null) {
				// pirntNumbersA.add(lottoNumbers[i - 1]);
				for (int i = 1; i < 8 && i <= lottoNumbers.length; i++) {
					lblAs[i] = lottoNumbers[i];
					pirntNumbersA.add(lblAs[i]);
				}
			}
		}

		pirntNumbersB = new JPanel();
		pirntNumbersB.setBounds(64, 239, 283, 34);
		pnl.add(pirntNumbersB);

		pirntNumbersC = new JPanel();
		pirntNumbersC.setBounds(64, 283, 283, 34);
		pnl.add(pirntNumbersC);

		pirntNumbersD = new JPanel();
		pirntNumbersD.setBounds(64, 326, 283, 34);
		pnl.add(pirntNumbersD);

		pirntNumbersE = new JPanel();
		pirntNumbersE.setBounds(64, 370, 283, 34);
		pnl.add(pirntNumbersE);

		JTextPane txtpnA = new JTextPane();
		txtpnA.setBounds(40, 195, 21, 34);
		pnl.add(txtpnA);
		txtpnA.setText("A");

		JTextPane txtpnB = new JTextPane();
		txtpnB.setText("B");
		txtpnB.setBounds(40, 239, 21, 34);
		pnl.add(txtpnB);

		JTextPane txtpnC = new JTextPane();
		txtpnC.setText("C");
		txtpnC.setBounds(40, 283, 21, 34);
		pnl.add(txtpnC);

		JTextPane txtpnD = new JTextPane();
		txtpnD.setText("D");
		txtpnD.setBounds(40, 326, 21, 34);
		pnl.add(txtpnD);

		JTextPane txtpnE = new JTextPane();
		txtpnE.setText("E");
		txtpnE.setBounds(40, 370, 21, 34);
		pnl.add(txtpnE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(359, 195, 92, 223);
		pnl.add(lblNewLabel);

		JPanel pirntResultA = new JPanel();
		pirntResultA.setBounds(359, 195, 92, 34);
		pnl.add(pirntResultA);

		JPanel pirntResultB = new JPanel();
		pirntResultB.setBounds(359, 239, 92, 34);
		pnl.add(pirntResultB);

		JPanel pirntResultC = new JPanel();
		pirntResultC.setBounds(359, 283, 92, 34);
		pnl.add(pirntResultC);

		JPanel pirntResultD = new JPanel();
		pirntResultD.setBounds(359, 326, 92, 34);
		pnl.add(pirntResultD);

		JPanel pirntResultE = new JPanel();
		pirntResultE.setBounds(359, 370, 92, 34);
		pnl.add(pirntResultE);

		showGUI();
	}

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		new WinningGUI(firstPage);
	}
}

class MyDialog extends JDialog {
	public MyDialog(JFrame parent) {
		super(parent);
		setTitle("당첨 규칙 확인");
		setModal(true);
		String labelText = "<html>* 로또는 온라인복권입니다.<br/>"
				+ "온라인복권이란 복권 발행시스템을 갖춘 중앙전산센터와 정보통신망으로 연결된 단말기를 통해 복권의 발행 및 판매가 이루어지는 복권으로 인터넷복권과는 다른 개념입니다.<br/>"
				+ "<br/>" + "* 자동, 반자동, 수동으로 고객이 선택하여 구입할 수 있습니다.<br/>"
				+ "“자동선택”을 선택하거나 판매인에게 요청하여 45개의 번호 중 6개 번호를 임의로 부여받는 방법, 1개~5개 번호 중 원하는 번호를 선택하고 나머지 번호는 임의로 부여받는 방법, 고객이 6개 번호를 모두 직접 선택하는 방법 중에서 원하는 대로 구입할 수 있습니다."
				+ "</html>";
		JLabel lblRule = new JLabel(labelText);
		add(lblRule);

		setSize(400, 400);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}