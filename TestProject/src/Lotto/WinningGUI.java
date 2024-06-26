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
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	public WinningGUI(FirstPage firstPage) {

		setTitle("당첨확인");
		pnl = new JPanel();
		pnl.setBackground(new Color(250, 250, 210));

		pnl.setLayout(null);
		JLabel lbl = new JLabel("당첨결과");
		lbl.setForeground(new Color(0, 0, 128));
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lbl.setBounds(193, 28, 84, 39);
		pnl.add(lbl);

		String[] list = new String[] { "", "1회차", "당첨된 것만 보기" };

		
		
		
		getContentPane().add(pnl);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setBounds(77, 77, 336, 64);
		pnl.add(panel);
		panel.setLayout(null);

		result_1 = new JLabel("");
		result_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_1.setBounds(12, 10, 28, 27);
		panel.add(result_1);

		result_2 = new JLabel("");
		result_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_2.setBounds(52, 10, 28, 27);
		panel.add(result_2);

		result_3 = new JLabel("");
		result_3.setFont(new Font("돋움체", Font.BOLD, 14));
		result_3.setBounds(92, 10, 40, 27);
		panel.add(result_3);

		result_4 = new JLabel("");
		result_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_4.setBounds(132, 10, 28, 27);
		panel.add(result_4);

		result_5 = new JLabel("");
		result_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_5.setBounds(171, 9, 28, 27);
		panel.add(result_5);

		result_6 = new JLabel("");
		result_6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_6.setBounds(211, 9, 28, 27);
		panel.add(result_6);

		JLabel lblNewLabel_2_1_1 = new JLabel("+");
		lblNewLabel_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(251, 10, 17, 27);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3 = new JLabel("당첨 번호");
		lblNewLabel_3.setForeground(new Color(165, 42, 42));
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(102, 39, 75, 25);
		panel.add(lblNewLabel_3);

		result_7 = new JLabel("");
		result_7.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		result_7.setBounds(292, 10, 28, 27);
		panel.add(result_7);
		
		JLabel lblNewLabel_4 = new JLabel("보너스");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(255, 140, 0));
		lblNewLabel_4.setBounds(273, 44, 57, 15);
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
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(40, 151, 411, 34);
		pnl.add(panel_1);
		panel_1.setLayout(null);

		JLabel purchaseNumber = new JLabel("구매 번호");
		purchaseNumber.setBackground(new Color(250, 250, 210));
		purchaseNumber.setForeground(new Color(0, 0, 128));
		purchaseNumber.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		purchaseNumber.setBounds(131, 0, 129, 29);
		panel_1.add(purchaseNumber);

		JLabel winningResult = new JLabel("당첨 결과");
		winningResult.setForeground(new Color(0, 0, 128));
		winningResult.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		winningResult.setBounds(322, 0, 77, 29);
		panel_1.add(winningResult);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/시작화면돌아가기버튼44.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FirstPage.resetLottoList();
				FirstPage.resetLottoList();
				clearLabels(pirntNumbersA);
				clearLabels(pirntNumbersB);
				clearLabels(pirntNumbersC);
				clearLabels(pirntNumbersD);
				clearLabels(pirntNumbersE);
				firstPage.setVisible(true);
				dispose();
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
//				JDialog dia = new WinningDialog();
//				dia.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(12, 428, 178, 23);
		pnl.add(btnNewButton_1);
		
		pirntNumbersA = new JPanel();
		pirntNumbersA.setBackground(new Color(255, 228, 181));
		pirntNumbersA.setBounds(40, 195, 283, 34);
		pnl.add(pirntNumbersA);

		pirntNumbersB = new JPanel();
		pirntNumbersB.setBackground(new Color(255, 228, 181));
		pirntNumbersB.setBounds(40, 239, 283, 34);
		pnl.add(pirntNumbersB);

		pirntNumbersC = new JPanel();
		pirntNumbersC.setBackground(new Color(255, 228, 181));
		pirntNumbersC.setBounds(40, 283, 283, 34);
		pnl.add(pirntNumbersC);

		pirntNumbersD = new JPanel();
		pirntNumbersD.setBackground(new Color(255, 228, 181));
		pirntNumbersD.setBounds(40, 326, 283, 34);
		pnl.add(pirntNumbersD);

		pirntNumbersE = new JPanel();
		pirntNumbersE.setBackground(new Color(255, 228, 181));
		pirntNumbersE.setBounds(40, 370, 283, 34);
		pnl.add(pirntNumbersE);

		JPanel pirntResultA = new JPanel();
		pirntResultA.setBackground(new Color(255, 248, 220));
		pirntResultA.setBounds(359, 195, 92, 34);
		pnl.add(pirntResultA);

		lblNewLabel = new JLabel("");
		pirntResultA.add(lblNewLabel);

		JPanel pirntResultB = new JPanel();
		pirntResultB.setBackground(new Color(255, 248, 220));
		pirntResultB.setBounds(359, 239, 92, 34);
		pnl.add(pirntResultB);

		lblNewLabel_1 = new JLabel("");
		pirntResultB.add(lblNewLabel_1);

		JPanel pirntResultC = new JPanel();
		pirntResultC.setBackground(new Color(255, 248, 220));
		pirntResultC.setBounds(359, 283, 92, 34);
		pnl.add(pirntResultC);

		lblNewLabel_2 = new JLabel("");
		pirntResultC.add(lblNewLabel_2);

		JPanel pirntResultD = new JPanel();
		pirntResultD.setBackground(new Color(255, 248, 220));
		pirntResultD.setBounds(359, 326, 92, 34);
		pnl.add(pirntResultD);

		lblNewLabel_6 = new JLabel("");
		pirntResultD.add(lblNewLabel_6);

		JPanel pirntResultE = new JPanel();
		pirntResultE.setBackground(new Color(255, 248, 220));
		pirntResultE.setBounds(359, 370, 92, 34);
		pnl.add(pirntResultE);

		lblNewLabel_7 = new JLabel("");
		pirntResultE.add(lblNewLabel_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 250, 210));
		panel_2.setBounds(484, 24, 449, 427);
		pnl.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBackground(new Color(250, 250, 210));
		lblNewLabel_8.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/dddddd.gif")));
		lblNewLabel_8.setBounds(0, 0, 449, 427);
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_9.setBounds(141, 28, 40, 39);
		pnl.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(WinningGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_10.setBounds(283, 28, 40, 39);
		pnl.add(lblNewLabel_10);
		
		showGUI();
	}
	private void clearLabels(JPanel panel) {
	       // 패널에 속한 모든 컴포넌트를 가져와서 제거
	       Component[] components = panel.getComponents();
	       for (Component component : components) {
	           if (component instanceof JLabel) {
	               panel.remove(component);
	           }
	       }
	       // 변경된 내용을 적용
	       panel.revalidate();
	       panel.repaint();
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

 class MyDialog extends JDialog{
	public MyDialog(JFrame parent) {
		super(parent);
		getContentPane().setBackground(new Color(250, 250, 210));
		getContentPane().setLayout(null);
		
		String labelText = "<html> 1등: 숫자 6개 일치.<br/>"
				+ " 2등: 숫자 5개 + 보너스 숫자 일치.<br/>"
				+ " 3등: 숫자 5개 일치.<br/>"
				+ " 4등: 숫자 4개 일치.<br/>"
				+ " 5등: 숫자 3개 일치.<br/>"
				+ "</html>";
		JLabel lblNewLabel = new JLabel(labelText);
		lblNewLabel.setBackground(new Color(244, 164, 96));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(111, 119, 383, 186);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MyDialog.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_1.setBounds(65, 103, 57, 59);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MyDialog.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_1_1.setBounds(288, 103, 57, 59);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("당첨 규칙 안내");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel_2.setBounds(111, 86, 180, 83);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MyDialog.class.getResource("/Image/페페전화기2.png")));
		lblNewLabel_3.setBounds(131, 262, 496, 338);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MyDialog.class.getResource("/Image/말풍선.png")));
		lblNewLabel_4.setBounds(26, 10, 393, 428);
		getContentPane().add(lblNewLabel_4);
		setTitle("당첨 규칙 확인");
//		showGUI();
		
		setSize(641, 612);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);
		setVisible(true);
	}
	
//	private void showGUI() {
//		setSize(641, 612);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setLocationRelativeTo(parent);
//		setVisible(true);
//	}
	
}
