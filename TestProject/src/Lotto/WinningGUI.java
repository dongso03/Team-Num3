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
import java.awt.Font;
import java.awt.Color;

public class WinningGUI extends JFrame {
	FirstPage firstPage;
	private JLabel lblNewLabel_5;
	public JPanel pirntNumbersA;
	JPanel pirntNumbersB;
	JPanel pirntNumbersC;
	JPanel pirntNumbersD;
	JPanel pirntNumbersE;

	private PurchaseGUI purchaseGUI;
	public JPanel pnl;
	public List<Integer> uniqueList;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_6;
	JLabel lblNewLabel_7;
	JLabel result_1;
	JLabel result_2;
	JLabel result_3;
	JLabel result_4;
	JLabel result_5;
	JLabel result_6;
	JLabel result_7;
	Set<Integer> resultList;
	Set<Integer> uniqueNumbers;

	public WinningGUI(FirstPage firstPage) {

//       for(int i= 0; i< 8;i++) {
//            lblAs[i].setText("");
//       }
		setTitle("당첨확인");
		pnl = new JPanel();

		pnl.setLayout(null);
		JLabel lbl = new JLabel("당첨결과");
		lbl.setForeground(Color.RED);
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lbl.setBounds(210, 24, 84, 15);
		pnl.add(lbl);

		String[] list = new String[] { "", "1회차", "당첨된 것만 보기" };

		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		panel.setBounds(79, 65, 372, 64);
		pnl.add(panel);
		panel.setLayout(null);

		result_1 = new JLabel("");
		result_1.setBounds(12, 10, 28, 27);
		panel.add(result_1);

		result_2 = new JLabel("");
		result_2.setBounds(52, 10, 28, 27);
		panel.add(result_2);

		result_3 = new JLabel("");
		result_3.setBounds(92, 10, 28, 27);
		panel.add(result_3);

		result_4 = new JLabel("");
		result_4.setBounds(132, 10, 28, 27);
		panel.add(result_4);

		result_5 = new JLabel("");
		result_5.setBounds(171, 9, 28, 27);
		panel.add(result_5);

		result_6 = new JLabel("");
		result_6.setBounds(211, 9, 28, 27);
		panel.add(result_6);

		JLabel lblNewLabel_2_1_1 = new JLabel("+");
		lblNewLabel_2_1_1.setBounds(251, 10, 17, 27);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3 = new JLabel("당첨 번호");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(102, 39, 57, 15);
		panel.add(lblNewLabel_3);

		result_7 = new JLabel("");
		result_7.setBounds(292, 10, 28, 27);
		panel.add(result_7);

		JLabel lblNewLabel_4 = new JLabel("보너스");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBounds(292, 39, 57, 15);
		panel.add(lblNewLabel_4);

		Random ran = new Random();
		uniqueNumbers = new HashSet<>();

		// 중복되지 않는 6개의 난수 생성(보너스 숫자 포함x)
		while (uniqueNumbers.size() < 7) {
			int randomNumber = ran.nextInt(45) + 1;
			uniqueNumbers.add(randomNumber);
		}

		resultList = new TreeSet<>(uniqueNumbers);
		uniqueList = new ArrayList<>(resultList);
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
		purchaseNumber.setForeground(Color.BLUE);
		purchaseNumber.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		purchaseNumber.setBounds(131, 0, 191, 29);
		panel_1.add(purchaseNumber);

		JLabel winningResult = new JLabel("당첨 결과");
		winningResult.setForeground(Color.BLUE);
		winningResult.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		winningResult.setBounds(334, 0, 77, 29);
		panel_1.add(winningResult);

		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/시작화면돌아가기버튼3.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FirstPage.resetLottoList();
				pirntNumbersA.repaint();// 안먹힘
				firstPage.setVisible(true);
				dispose();

			}
		});

		btnNewButton.setBounds(273, 428, 178, 23);
		pnl.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/당첨규칙확인하기버튼2.png")));
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
		pirntNumbersA.setBounds(40, 195, 283, 34);
		pnl.add(pirntNumbersA);

		pirntNumbersB = new JPanel();
		pirntNumbersB.setBounds(40, 239, 283, 34);
		pnl.add(pirntNumbersB);

		pirntNumbersC = new JPanel();
		pirntNumbersC.setBounds(40, 283, 283, 34);
		pnl.add(pirntNumbersC);

		pirntNumbersD = new JPanel();
		pirntNumbersD.setBounds(40, 326, 283, 34);
		pnl.add(pirntNumbersD);

		pirntNumbersE = new JPanel();
		pirntNumbersE.setBounds(40, 370, 283, 34);
		pnl.add(pirntNumbersE);

		JPanel pirntResultA = new JPanel();
		pirntResultA.setBounds(359, 195, 92, 34);
		pnl.add(pirntResultA);

		lblNewLabel = new JLabel("");
		pirntResultA.add(lblNewLabel);

		JPanel pirntResultB = new JPanel();
		pirntResultB.setBounds(359, 239, 92, 34);
		pnl.add(pirntResultB);

		lblNewLabel_1 = new JLabel("");
		pirntResultB.add(lblNewLabel_1);

		JPanel pirntResultC = new JPanel();
		pirntResultC.setBounds(359, 283, 92, 34);
		pnl.add(pirntResultC);

		lblNewLabel_2 = new JLabel("");
		pirntResultC.add(lblNewLabel_2);

		JPanel pirntResultD = new JPanel();
		pirntResultD.setBounds(359, 326, 92, 34);
		pnl.add(pirntResultD);

		lblNewLabel_6 = new JLabel("");
		pirntResultD.add(lblNewLabel_6);

		JPanel pirntResultE = new JPanel();
		pirntResultE.setBounds(359, 370, 92, 34);
		pnl.add(pirntResultE);

		lblNewLabel_7 = new JLabel("");
		pirntResultE.add(lblNewLabel_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(484, 24, 449, 427);
		pnl.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/dddddd.gif")));
		lblNewLabel_8.setBounds(0, 0, 449, 427);
		panel_2.add(lblNewLabel_8);

		showGUI();
	}

	private void showGUI() {
		setSize(800, 499);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);
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