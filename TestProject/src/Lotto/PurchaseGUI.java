package Lotto;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
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
	private JLabel[] lbl1;
	private JLabel[] lbl2s;
	public JLabel lblNewLabel_10;

	public PurchaseGUI(FirstPage firstpage,ChargeGUI chargeGUI) {
		 this.firstpage= firstpage;
		 this.chargeGUI=chargeGUI;
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

//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		JComboBox<Integer> comboBox = new JComboBox<>();
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
			private List<Integer> selectedNumbers = new ArrayList<>();
			int selectCount = 0;

			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedIndex()) {
				case 0: // 1장 선택했을 때
					if (!btnAuto.isSelected()) { // 수동
						selectedNumbers.addAll(getSelectedNumbers());
						Collections.sort(selectedNumbers);

						for (int i = 2; i < 8; i++) {
							lbl1[1].setText("수동");
							lbl1[i].setText(String.valueOf(selectedNumbers.get(i - 2)));
						}
					} else { // 자동 버튼을 클릭
						Set<Integer> notDuplicate = new HashSet<>(); // 중복없는 숫자 집합

						for (JToggleButton button : toggleButtons) {
							if (button.isSelected()) { // 중복되지 않고 랜덤 숫자 6개 만들기
								selectCount++;
							}
						}
								// all 자동
						if (selectCount == 0 || selectCount == 6) {
							while (notDuplicate.size() < 7) {
								int randomNumber = ran.nextInt(45) + 1;
								notDuplicate.add(randomNumber);
							}
							List<Integer> lottoResult = new ArrayList<>(notDuplicate);
							Collections.sort(lottoResult); // 인덱스 0~ 6까지 숫자 다 뽑아내라
							for (int i = 2; i < 8; i++) {
								lbl1[1].setText("자동");
								lbl1[i].setText(String.valueOf(lottoResult.get(i - 2)));
							}   // 반자동인 경우
						} else if (0 < selectCount && selectCount < 6) { // 사용자가 1개 이상 5개 이하로 숫자를 선택시
							selectedNumbers.addAll(getSelectedNumbers());
							// Set<Integer> notDuplicate 중복을 허용하지 않는 set에 선택한 숫자들 전부 넣어주기
							notDuplicate.addAll(selectedNumbers);
							while (notDuplicate.size() < 7) { // 숫자들이 중복되지 않으면서, 크기가 6이 넘지 않게
								int r = ran.nextInt(45) + 1;
								notDuplicate.add(r);
							}
							// 오름차순으로 정렬하기위해 set -> list로 변환해줌
							List<Integer> lottoResult = new ArrayList<>(notDuplicate);
							Collections.sort(lottoResult); // 오름차순으로 정렬
							for (int i = 2; i < 8; i++) {
								lbl1[1].setText("반자동");
								lbl1[i].setText(String.valueOf(lottoResult.get(i - 2)));
							}
						}
					}

					break;
				case 1:

					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				}

				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		panel.add(checkBtn);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 405, 290);
		getContentPane().add(panel_2);

		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		lblNewLabel_1.setBounds(164, 5, 76, 15);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(24, 50, 301, 35);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		lbl1 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl1[i] = new JLabel("d");
			panel_3.add(lbl1[i]);
		}

		// 오른쪽 숫자들 초기화하는 버튼
		JButton btnNewButton = new JButton("초기화");
		btnNewButton.setBounds(328, 50, 65, 23);
		panel_2.add(btnNewButton);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(23, 95, 302, 35);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		lbl2s = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl2s[i] = new JLabel("d");
			panel_4.add(lbl2s[i]);
		}

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(24, 140, 302, 35);
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel[] lbl3 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl3[i] = new JLabel("d");
			panel_5.add(lbl3[i]);
		}

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(24, 185, 301, 35);
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel[] lbl4 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl4[i] = new JLabel("d");
			panel_6.add(lbl4[i]);
		}

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(24, 230, 301, 35);
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel[] lbl5 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl5[i] = new JLabel("d");
			panel_7.add(lbl5[i]);
		}

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 2; i < 8; i++) {
					lbl1[1].setText("미지정");
					lbl1[i].setText("");
				}

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 345, 317);
		getContentPane().add(panel_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 337, 353, 31);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);

		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(98, 10, 69, 23);
		panel_8.add(btnReset);
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.WEST, btnReset, 25, SpringLayout.WEST, panel);
		// Random ran = new Random();

		btnAuto = new JToggleButton("자동");
		btnAuto.setBounds(193, 10, 57, 23);
		panel_8.add(btnAuto);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, -34, SpringLayout.WEST, checkBtn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(375, 337, 405, 88);
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
				
				if(chargeGUI != null) {
					chargeGUI.setVisible(true);
				}
				dispose();
			}
		});
		btnNewButton_1.setBounds(76, 6, 57, 23);
		panel_9.add(btnNewButton_1);
		
		lblNewLabel_10 = new JLabel("보유금액: "+FirstPage.customer.getAmount());
		lblNewLabel_10.setBounds(12, 46, 121, 15);
		panel_9.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("결제금액");
		lblNewLabel_11.setBounds(182, 10, 57, 15);
		panel_9.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("구매");
		btnNewButton_2.setBounds(296, 42, 97, 23);
		panel_9.add(btnNewButton_2);
		btnAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("1")) {

				} else if (comboBox.getSelectedItem().toString().equals("2")) {

				} else if (comboBox.getSelectedItem().toString().equals("3")) {

				} else if (comboBox.getSelectedItem().toString().equals("4")) {

				} else if (comboBox.getSelectedItem().toString().equals("5")) {

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
		List<Integer> selectedNumbers = new ArrayList<>();
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

	private void showGUI() {
		setSize(815, 567);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}
	 public void setFirstPage(FirstPage firstPage) {
	        this.firstpage = firstPage;
	    }

	public static void main(String[] args) {
		FirstPage firstpage = new FirstPage();
		ChargeGUI chargeGUI= new ChargeGUI(firstpage);
		new PurchaseGUI(firstpage,chargeGUI);
	}
}