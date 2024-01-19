package Lotto;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;

public class PurchaseGUI extends JFrame {
	private List<JToggleButton> toggleButtons;
	FirstPage firstpage;
	JToggleButton btnAuto;
	JToggleButton togbtn;
	ChargeGUI chargeGUI;

	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	public JLabel[] lbl1;
	private JLabel[] lbl2;
	public JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	private JLabel[] lbl3;
	private JLabel[] lbl4;
	private JLabel[] lbl5;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private List<Integer> selectedNumbers = new ArrayList<>();
	int sumSelectedCombo = 0;

	public PurchaseGUI(FirstPage firstpage, ChargeGUI chargeGUI) {
		this.firstpage = firstpage;
		this.chargeGUI = chargeGUI;
		getContentPane().setLayout(null);
		toggleButtons = new ArrayList<>();
		Panel panel = new Panel();
		panel.setBounds(10, 394, 353, 31);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		Random ran = new Random();

		JLabel lblNewLabel = new JLabel("수량");
		panel.add(lblNewLabel);

		String[] list = new String[] { "1", "2", "3", "4", "5" };
		JComboBox comboBox = new JComboBox(list);

		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
		panel.add(comboBox);

		JButton checkBtn = new JButton("확인");
		sl_panel.putConstraint(SpringLayout.NORTH, checkBtn, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, checkBtn, 18, SpringLayout.EAST, comboBox);
		
		
		// 확인 버튼을 눌렀을 때 -------------------------------------------------
		checkBtn.addActionListener(new ActionListener() {
			// private List<Integer> selectedNumbers = new ArrayList<>();
			int selectCount = 0;

			private Map<Integer, JLabel[]> map = new HashMap<>();

			public void actionPerformed(ActionEvent e) {

				map.put(1, lbl1);
				map.put(2, lbl2);
				map.put(3, lbl3);
				map.put(4, lbl4);
				map.put(5, lbl5);

				int selectedCombo = comboBox.getSelectedIndex() + 1; // 2번째 선택 : 2장 선택
				sumSelectedCombo += selectedCombo; // 5이 됨. => lbl4,5가 채워져야됨(map의 키가 4,5임)

				if (sumSelectedCombo < 6) {

					for (int i = sumSelectedCombo-selectedCombo; i<sumSelectedCombo;i++) { // lbl2,3,4에 추가되어야 됨
						JLabel[] currentLabel = map.get(i+1);
						int currentLabelIndex = 0;

						if (!btnAuto.isSelected()) { // 수동 버튼
							if (selectCount == 0) {
								if (selectCount != 0) {
									selectedNumbers.addAll(getSelectedNumbers());
									Collections.sort(selectedNumbers);

									for (int j = 2; j < 8; j++) {
										currentLabel[1].setText("수동");
										currentLabel[j].setText(String.valueOf(selectedNumbers.get(j - 2)));
									}
								} else {
									JOptionPane.showMessageDialog(null, "숫자가 선택되지 않았습니다.");
								}

							}

						} else { // 자동 버튼 눌렀을 때
							Set<Integer> nonDuplicateNumber = new HashSet<>();

							for (JToggleButton button : toggleButtons) {
								if (button.isSelected()) {
									selectCount++;
								}
							}

							if (selectCount == 0 || selectCount == 6) {
								자동으로_숫자_생성(currentLabel, nonDuplicateNumber);
							} else if (0 < selectCount && selectCount < 6) {
								반자동으로_숫자_생성(currentLabel, nonDuplicateNumber);
							}
						}
						selectedNumbers.clear();
						selectCount = 0;

					}
				} else {
					JOptionPane.showMessageDialog(null, "한 번에 다섯 장 이상은 구매할 수 없습니다.");
				}

				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		// -----------------------------------------------------------------
		panel.add(checkBtn);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 519, 293);
		getContentPane().add(panel_2);

		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		lblNewLabel_1.setBounds(164, 5, 76, 15);
		panel_2.add(lblNewLabel_1);

		panel_3 = new JPanel();
		panel_3.setBounds(24, 50, 371, 35);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		lbl1 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl1[i] = new JLabel("");
			lbl1[0] = new JLabel("A");
			panel_3.add(lbl1[i]);
		}

		// 오른쪽 숫자들 초기화하는 버튼
		JButton btnReset_1 = new JButton("초기화");
		btnReset_1.setBounds(407, 50, 89, 23);
		panel_2.add(btnReset_1);

		panel_4 = new JPanel();
		panel_4.setBounds(23, 95, 372, 35);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		lbl2 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl2[i] = new JLabel("");
			lbl2[0] = new JLabel("B");
			panel_4.add(lbl2[i]);
		}

		panel_5 = new JPanel();
		panel_5.setBounds(24, 140, 371, 35);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		lbl3 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl3[i] = new JLabel("");
			lbl3[0] = new JLabel("C");
			panel_5.add(lbl3[i]);
		}

		panel_6 = new JPanel();
		panel_6.setBounds(24, 185, 371, 35);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		lbl4 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl4[i] = new JLabel("");
			lbl4[0] = new JLabel("D");
			panel_6.add(lbl4[i]);
		}

		panel_7 = new JPanel();
		panel_7.setBounds(24, 230, 371, 35);
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 337, 353, 31);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);

		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(98, 10, 69, 23);
		panel_8.add(btnReset);
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.WEST, btnReset, 25, SpringLayout.WEST, panel);

		JButton btnReset_2 = new JButton("초기화");
		btnReset_2.setBounds(407, 96, 89, 23);
		panel_2.add(btnReset_2);

		JButton btnReset_3 = new JButton("초기화");
		btnReset_3.setBounds(407, 139, 89, 23);
		panel_2.add(btnReset_3);

		JButton btnReset_4 = new JButton("초기화");
		btnReset_4.setBounds(407, 185, 89, 23);
		panel_2.add(btnReset_4);

		JButton btnReset_5 = new JButton("초기화");
		btnReset_5.setBounds(407, 230, 89, 23);
		panel_2.add(btnReset_5);
		lbl5 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl5[i] = new JLabel("");
			lbl5[0] = new JLabel("E");
			panel_7.add(lbl5[i]);
		}

		btnReset_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl1[1].setText("미지정");
					lbl1[i].setText("");
					sumSelectedCombo--;
				}

			}
		});
		btnReset_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl2[1].setText("미지정");
					lbl2[i].setText("");
					sumSelectedCombo--;
				}

			}
		});
		btnReset_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl3[1].setText("미지정");
					lbl3[i].setText("");
					sumSelectedCombo--;
				}

			}
		});
		btnReset_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl4[1].setText("미지정");
					lbl4[i].setText("");
					sumSelectedCombo--;
				}

			}
		});
		btnReset_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl5[1].setText("미지정");
					lbl5[i].setText("");
					sumSelectedCombo--;
				}

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 345, 317);
		getContentPane().add(panel_1);

		// Random ran = new Random();

		btnAuto = new JToggleButton("자동");
		btnAuto.setBounds(193, 10, 57, 23);
		panel_8.add(btnAuto);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, -34, SpringLayout.WEST, checkBtn);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(375, 337, 405, 108);
		getContentPane().add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("보유금액");
		lblNewLabel_3.setBounds(12, 10, 57, 15);
		panel_9.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("충전");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				chargeGUI.setVisible(true);

				if (chargeGUI != null) {
					chargeGUI.setVisible(true);
				}
				dispose();
			}
		});
		btnNewButton_1.setBounds(76, 6, 57, 23);
		panel_9.add(btnNewButton_1);

		lblNewLabel_10 = new JLabel("보유금액: " + FirstPage.customer.getAmount());
		lblNewLabel_10.setBounds(12, 46, 121, 15);
		panel_9.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("결제금액");
		lblNewLabel_11.setBounds(182, 10, 57, 15);
		panel_9.add(lblNewLabel_11);

		JButton btnNewButton_2 = new JButton("구매");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog jdp = new ConfirmPurchaseDialog(PurchaseGUI.this);
				jdp.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(296, 10, 97, 55);
		panel_9.add(btnNewButton_2);

		lblNewLabel_12 = new JLabel("1000원");
		lblNewLabel_12.setBounds(182, 46, 57, 15);
		panel_9.add(lblNewLabel_12);

		JButton btnNewButton_3 = new JButton("돌아가기");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstpage.setVisible(true);
				dispose();

				if (firstpage != null) {
					firstpage.setVisible(true);
				}
				dispose();
			}
		});
		btnNewButton_3.setBounds(296, 75, 97, 23);
		panel_9.add(btnNewButton_3);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("1")) {
					lblNewLabel_12.setText("1000원");
				} else if (comboBox.getSelectedItem().toString().equals("2")) {
					lblNewLabel_12.setText("2000원");
				} else if (comboBox.getSelectedItem().toString().equals("3")) {
					lblNewLabel_12.setText("3000원");
				} else if (comboBox.getSelectedItem().toString().equals("4")) {
					lblNewLabel_12.setText("4000원");
				} else if (comboBox.getSelectedItem().toString().equals("5")) {
					lblNewLabel_12.setText("5000원");
				}

			}
		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : toggleButtons) {

					button.setSelected(false);
				}
			}
		});

		for (int i = 1; i <= 45; i++) {
			togbtn = new JToggleButton(String.valueOf(i));
			togbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					handleToggleButtonAction(togbtn);
				}
			});
			panel_1.add(togbtn);
			toggleButtons.add(togbtn);
		}

		showGUI();
	}

	// 토글 버튼에서 숫자를 추출하고, 그 숫자들을 리스트로 반환 메소드
	private List<Integer> getSelectedNumbers() {
		// List<Integer> selectedNumbers = new ArrayList<>();
		for (JToggleButton button : toggleButtons) {
			if (button.isSelected()) {
				int num = Integer.parseInt(button.getText());
				selectedNumbers.add(num);
			}
		}
		return selectedNumbers;
	}

	private void handleToggleButtonAction(JToggleButton togbtn) {
		int selectedCount = 0;
		this.togbtn = togbtn;
		List<JToggleButton> a = new ArrayList<>();

		for (JToggleButton button : toggleButtons) {
			if (button.isSelected()) {
				a.add(button);
				selectedCount++;
			}
		}

		if (selectedCount == 7) {
			JOptionPane.showMessageDialog(this, "최대 6개까지 선택 가능합니다.");
			// 모든 토글 버튼을 대상으로 확인하여 선택이 되어있는 경우 선택 취소
			a.get(6).setSelected(false);

		}
	}

	// 자동으로 숫자를 생성하는 메소드
	private void 자동으로_숫자_생성(JLabel[] currentLabel, Set<Integer> nonDuplicateNumber) {
		Random r = new Random();
		while (nonDuplicateNumber.size() < 7) {
			int randomNumber = r.nextInt(45) + 1;
			nonDuplicateNumber.add(randomNumber);
		}

		List<Integer> lottoResult = new ArrayList<>(nonDuplicateNumber);
		Collections.sort(lottoResult);

		currentLabel[1].setText("자동");

		for (int i = 2; i < 8; i++) {
			currentLabel[i].setText(String.valueOf(lottoResult.get(i - 2)));
		}
	}

	// 반자동으로 숫자를 생성하는
	// 메소드--------------------------------------------------------------
	private void 반자동으로_숫자_생성(JLabel[] currentLabel, Set<Integer> nonDuplicateNumber) {
		selectedNumbers.addAll(getSelectedNumbers());
		nonDuplicateNumber.addAll(selectedNumbers);
		Random ran = new Random();

		while (nonDuplicateNumber.size() < 7) {
			int r = ran.nextInt(45) + 1;
			nonDuplicateNumber.add(r);
		}

		List<Integer> lottoResult = new ArrayList<>(nonDuplicateNumber);
		Collections.sort(lottoResult);

		currentLabel[1].setText("반자동");

		for (int i = 2; i < 8; i++) {
			currentLabel[i].setText(String.valueOf(lottoResult.get(i - 2)));
		}

		selectedNumbers.clear();
	}

	private void showGUI() {
		setSize(903, 566);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	public void setFirstPage(FirstPage firstPage) {
		this.firstpage = firstPage;
	}

	public static void main(String[] args) {
		FirstPage firstpage = new FirstPage();
		ChargeGUI chargeGUI = new ChargeGUI(firstpage);
		new PurchaseGUI(firstpage, chargeGUI);
	}
}