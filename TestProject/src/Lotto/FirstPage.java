package Lotto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.sun.prism.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;

public class FirstPage extends JFrame {
	private JButton btnCharge;
	private JButton btnPuchase;
	private JButton btnWinning;
	private ChargeGUI chargGUI;
	private WinningGUI winningGUI;
	public static Customer customer;
	private JPanel panel;
	static int nowPrice = 0;
	List<Integer> uniqueList;
	int[] uniqueArray;

	private PurchaseGUI purchaseGUI;
	private List<PurchaseGUI> purchaseGUIList;
	private int currentPurchaseGUIIndex;
	
	Set<Integer> resultList;
	Set<Integer> uniqueNumbers;


	public FirstPage() {
		customer = new Customer(10000, 1);
		chargGUI = new ChargeGUI(this);
		winningGUI = new WinningGUI(this);
		purchaseGUI = new PurchaseGUI(this, chargGUI);

		ImageIcon icon = new ImageIcon("Image/캡처.PNG");
		uniqueList = winningGUI.uniqueList;
		uniqueArray = uniqueList.stream().mapToInt(Integer::intValue).toArray();

		purchaseGUIList = new ArrayList<>();
		purchaseGUIList.add(new PurchaseGUI(this, chargGUI)); // 0번째 PurchaseGUI
		purchaseGUIList.add(new PurchaseGUI(this, chargGUI)); // 1번째 PurchaseGUI
		purchaseGUIList.add(new PurchaseGUI(this, chargGUI));
		purchaseGUIList.add(new PurchaseGUI(this, chargGUI));
		purchaseGUIList.add(new PurchaseGUI(this, chargGUI));
		

		currentPurchaseGUIIndex = 0;

		extracted();
		btnCharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				chargGUI.setVisible(true);
				// chargGUI.lblNewLabel.setText(text);

			}
		});

		btnPuchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 현재 PurchaseGUI를 숨기고, 다음 PurchaseGUI를 보여줌
				purchaseGUIList.get(currentPurchaseGUIIndex).setVisible(false);

				// 다음 PurchaseGUI 인덱스로 이동
				currentPurchaseGUIIndex++;

				// 인덱스가 리스트 크기를 벗어나면 처음으로 돌아감
				if (currentPurchaseGUIIndex >= purchaseGUIList.size()) {
					currentPurchaseGUIIndex = 0;
				}

				// 새로운 PurchaseGUI를 보여줌
				purchaseGUIList.get(currentPurchaseGUIIndex).setVisible(true);
				purchaseGUIList.get(currentPurchaseGUIIndex).lblNewLabel_10
						.setText("(현재 잔액: " + (FirstPage.customer.getAmount() - nowPrice) + "원)");
			}
		});
		btnWinning.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Random ran = new Random();
				uniqueNumbers = new HashSet<>();

				// 중복되지 않는 6개의 난수 생성(보너스 숫자 포함x)
				while (uniqueNumbers.size() < 7) {
					int randomNumber = ran.nextInt(45) + 1;
					uniqueNumbers.add(randomNumber);
				}

				resultList = new TreeSet<>(uniqueNumbers);
				uniqueList = new ArrayList<>(resultList);
			   
				winningGUI.result_1.setText(String.valueOf(uniqueList.get(0)));
				winningGUI.result_2.setText(String.valueOf(uniqueList.get(1)));
				winningGUI.result_3.setText(String.valueOf(uniqueList.get(2)));
				winningGUI.result_4.setText(String.valueOf(uniqueList.get(4)));
				winningGUI.result_5.setText(String.valueOf(uniqueList.get(5)));
				winningGUI.result_6.setText(String.valueOf(uniqueList.get(6)));
				winningGUI.result_7.setText(String.valueOf(uniqueList.get(3)));
			      
			      
				for (int i = 0; i < 8; i++) {
					winningGUI.pirntNumbersA.add(customer.lottoList.get(1)[i]);
				}
				for (int i = 0; i < 8; i++) {
					winningGUI.pirntNumbersB.add(customer.lottoList.get(2)[i]);
				}
				for (int i = 0; i < 8; i++) {
					winningGUI.pirntNumbersC.add(customer.lottoList.get(3)[i]);
				}
				for (int i = 0; i < 8; i++) {
					winningGUI.pirntNumbersD.add(customer.lottoList.get(4)[i]);
				}
				for (int i = 0; i < 8; i++) {
					winningGUI.pirntNumbersE.add(customer.lottoList.get(5)[i]);
				}

				// 각 숫자를 문자열로 변환하여 일치 여부 체크하여 당첨, 낙첨 확인하는 부분
				for (int a = 1; a < 6; a++) {
					// 최소 6개의 일치 여부를 체크하는 변수 matchingCount
					int matchingCount = 0;
					// 사용자가 선택한 1장을 배열에 집어 넣음
					JLabel[] lottoListLabels = customer.lottoList.get(a);
					for (int i = 0; i < 7; i++) { // 복권 당첨 숫자 7개
						for (int j = 2; j < 8; j++) { // 사용자가 선택한 숫자들을 6개

							String uniqueNumber = String.valueOf(uniqueArray[i]);
							String labelNumber = lottoListLabels[j].getText();

							if (uniqueNumber.equals(labelNumber)) { // 복권당첨 숫자와 사용자가 선택한 숫자가 같은 게 있다면 매칭카운트 1증가
								matchingCount++;
							}
						}
					}
					switch (a) {
					case 1:
						// 최소 6개 이상의 일치 여부 확인
						if (matchingCount >= 6) {
							winningGUI.lblNewLabel.setText("1등 당첨");
						} else if (matchingCount == 5) {
							winningGUI.lblNewLabel.setText("3등 당첨");
						} else if (matchingCount == 4) {
							winningGUI.lblNewLabel.setText("4등 당첨");
						} else if (matchingCount == 3) {
							winningGUI.lblNewLabel.setText("5등 당첨");
						} else {
							winningGUI.lblNewLabel.setText("낙첨");
						}
						break;
					case 2:
						if (matchingCount >= 6) {
							winningGUI.lblNewLabel_1.setText("당첨");
						} else if (matchingCount == 5) {
							winningGUI.lblNewLabel_1.setText("3등 당첨");
						} else if (matchingCount == 4) {
							winningGUI.lblNewLabel_1.setText("4등 당첨");
						} else if (matchingCount == 3) {
							winningGUI.lblNewLabel_1.setText("5등 당첨");
						} else {
							winningGUI.lblNewLabel_1.setText("낙첨");
						}

						break;
					case 3:
						if (matchingCount >= 6) {
							winningGUI.lblNewLabel_2.setText("당첨");
						} else if (matchingCount == 5) {
							winningGUI.lblNewLabel_2.setText("3등 당첨");
						} else if (matchingCount == 4) {
							winningGUI.lblNewLabel_2.setText("4등 당첨");
						} else if (matchingCount == 3) {
							winningGUI.lblNewLabel_2.setText("5등 당첨");
						} else {
							winningGUI.lblNewLabel_2.setText("낙첨");
						}

						break;
					case 4:
						if (matchingCount >= 6) {
							winningGUI.lblNewLabel_6.setText("당첨");
						} else if (matchingCount == 5) {
							winningGUI.lblNewLabel_6.setText("3등 당첨");
						} else if (matchingCount == 4) {
							winningGUI.lblNewLabel_6.setText("4등 당첨");
						} else if (matchingCount == 3) {
							winningGUI.lblNewLabel_6.setText("5등 당첨");
						} else {
							winningGUI.lblNewLabel_6.setText("낙첨");
						}

						break;
					case 5:
						if (matchingCount >= 6) {
							winningGUI.lblNewLabel_7.setText("당첨");
						} else if (matchingCount == 5) {
							winningGUI.lblNewLabel_7.setText("3등 당첨");
						} else if (matchingCount == 4) {
							winningGUI.lblNewLabel_7.setText("4등 당첨");
						} else if (matchingCount == 3) {
							winningGUI.lblNewLabel_7.setText("5등 당첨");
						} else {
							winningGUI.lblNewLabel_7.setText("낙첨");
						}

						break;
					}
				}
				setVisible(false);
				winningGUI.setVisible(true);
			}
		});

		showGUI();
	}

	private void showGUI() {
		setSize(793, 475);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	static void resetLottoList() {
		// customer.lottoList 초기화
		for (int i = 1; i <= 5; i++) {
			JLabel[] lottoListLabels = customer.lottoList.get(i);

			// 번호 초기화
			for (int j = 2; j < 8; j++) {
				lottoListLabels[j].setText("");
			}

			// 알파벳, 자동, 수동, 반자동 등의 부분 초기화
			// 예시로 setText("")를 사용하였으나 초기화하는 방식에 따라 변경할 수 있습니다.
			lottoListLabels[0].setText(""); // 알파벳 초기화
			lottoListLabels[1].setText(""); // 자동, 수동, 반자동 등 초기화
		}
	}

	private void extracted() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 783, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		panel.setLayout(null);

		btnPuchase = new JButton("");
		btnPuchase.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/구매하기버튼2.png")));
		btnPuchase.setFont(new Font("굴림", Font.BOLD, 15));
		btnPuchase.setBounds(12, 353, 222, 71);
		btnPuchase.setContentAreaFilled(false);
		btnPuchase.setBorderPainted(false);
		btnPuchase.setFocusPainted(false);
		panel.add(btnPuchase);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPuchase, -10, SpringLayout.SOUTH, getContentPane());
		btnPuchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnPuchase, 17, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnPuchase, 84, SpringLayout.EAST, btnCharge);

		btnCharge = new JButton("");
		btnCharge.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/충전하기버튼2.png")));
		btnCharge.setFont(new Font("굴림", Font.BOLD, 15));
		btnCharge.setBounds(289, 353, 202, 71);
		btnCharge.setContentAreaFilled(false);
		btnCharge.setBorderPainted(false);
		btnCharge.setFocusPainted(false);
		panel.add(btnCharge);

		springLayout.putConstraint(SpringLayout.NORTH, btnCharge, -151, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCharge, 57, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCharge, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCharge, 207, SpringLayout.WEST, getContentPane());

		btnWinning = new JButton("");
		btnWinning.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/당첨확인버튼2.png")));
		btnWinning.setFont(new Font("굴림", Font.BOLD, 15));
		btnWinning.setContentAreaFilled(false);
		btnWinning.setBorderPainted(false);
		btnWinning.setFocusPainted(false);
		btnWinning.setBounds(549, 353, 222, 71);
		panel.add(btnWinning);
		springLayout.putConstraint(SpringLayout.WEST, btnWinning, 529, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnWinning, 233, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnWinning, -21, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnWinning, -105, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnPuchase, -93, SpringLayout.WEST, btnWinning);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/페페첫화면.jpg")));
		lblNewLabel.setBounds(0, -134, 1361, 704);
		panel.add(lblNewLabel);
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		ChargeGUI chargeGUI = new ChargeGUI(firstPage);
	}
}