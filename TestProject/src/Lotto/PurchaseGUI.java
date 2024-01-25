package Lotto;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class PurchaseGUI extends JFrame {
	static List<JToggleButton> toggleButtons;
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
	JLabel[] lbl2;
	public JLabel lblNewLabel_10;
	public JLabel priceLbl;
	JLabel[] lbl3;
	JLabel[] lbl4;
	JLabel[] lbl5;
	private JPanel panelA;
	private JPanel panelB;
	private JPanel panelC;
	private JPanel panelD;
	private JPanel panelE;
	private static List<Integer> selectedNumbers = new ArrayList<>();
	int sumSelectedCombo = 0;
	private int price = 0;
	public Map<Integer, JLabel[]> map;

	public static int SelectedNumbers;
	JPanel panel_1;
	private int nowPrice;

	public PurchaseGUI(FirstPage firstpage, ChargeGUI chargeGUI, int nowPrice) {
		getContentPane().setBackground(new Color(250, 250, 210));
		this.nowPrice = nowPrice;
		this.firstpage = firstpage;
		this.chargeGUI = chargeGUI;
		getContentPane().setLayout(null);
		toggleButtons = new ArrayList<>();
		Panel panel = new Panel();
		panel.setBounds(10, 425, 422, 57);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		Random ran = new Random();
		JLabel lblNewLabel = new JLabel("수량");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 9, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel.add(lblNewLabel);

		String[] list = new String[] { "1", "2", "3", "4", "5" };
		JComboBox comboBox = new JComboBox(list);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 3, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -264, SpringLayout.EAST, panel);
		comboBox.setBackground(new Color(250, 250, 210));
		panel.add(comboBox);

		JButton checkBtn = new JButton("");
		sl_panel.putConstraint(SpringLayout.EAST, checkBtn, -32, SpringLayout.EAST, panel);
		checkBtn.setBackground(Color.WHITE);
		checkBtn.setContentAreaFilled(false);
		checkBtn.setBorderPainted(false);
		checkBtn.setFocusPainted(false);
		checkBtn.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/확인버튼2.png")));
		map = new HashMap<>();
		map.put(1, lbl1);
		map.put(2, lbl2);
		map.put(3, lbl3);
		map.put(4, lbl4);
		map.put(5, lbl5);

		// 확인 버튼을 눌렀을 때 -------------------------------------------------
		checkBtn.addActionListener(new ActionListener() {
			// private List<Integer> selectedNumbers = new ArrayList<>();
			int selectCount = 0;
			private int selectedCombo;

			public void actionPerformed(ActionEvent e) {

				map.put(1, lbl1);
				map.put(2, lbl2);
				map.put(3, lbl3);
				map.put(4, lbl4);
				map.put(5, lbl5);

				selectedCombo = comboBox.getSelectedIndex() + 1;
				sumSelectedCombo += selectedCombo; // 5이 됨. => lbl4,5가 채워져야됨(map의 키가 4,5임)

				
				
				if (sumSelectedCombo < 6) {

					for (int i = sumSelectedCombo - selectedCombo; i < sumSelectedCombo; i++) { // lbl2,3,4에 추가되어야 됨
						JLabel[] currentLabel = map.get(i + 1);
						int currentLabelIndex = 0;

						if (!btnAuto.isSelected()) { // 수동 버튼
							for (JToggleButton button : toggleButtons) {
								if (button.isSelected()) {
									selectCount++;
								}
							}

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

					FirstPage.nowPrice += (comboBox.getSelectedIndex() + 1) * 1000;
					if (FirstPage.nowPrice > Customer.amount) {
						int result = JOptionPane.showOptionDialog(null, "충전 금액을 초과하였습니다.", "경고",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "확인" },
								"확인");

						if (result == JOptionPane.OK_OPTION) {
							// "확인" 버튼을 눌렀을 때 수행할 동작
							for (int i = 1; i < 8; i++) {
								lbl1[i].setText("");
								lbl2[i].setText("");
								lbl3[i].setText("");
								lbl4[i].setText("");
								lbl5[i].setText("");
							}
							FirstPage.nowPrice = 0;
							sumSelectedCombo = 0;
						}

					} else {
						priceLbl.setText(String.valueOf(FirstPage.nowPrice));
					}

				} else {
					JOptionPane.showMessageDialog(null, "한 번에 다섯 장 이상은 구매할 수 없습니다.");
					sumSelectedCombo -= selectedCombo;
				}

				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		// -----------------------------------------------------------------
		if (FirstPage.nowPrice < 0) {
			FirstPage.nowPrice = 0;
		} else if (FirstPage.nowPrice > 5000) {
			FirstPage.nowPrice = 5000;
		}
		panel.add(checkBtn);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 250, 210));
		panel_2.setBounds(369, 34, 702, 293);
		getContentPane().add(panel_2);

		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_1.setBounds(281, 10, 130, 30);
		panel_2.add(lblNewLabel_1);

		panelA = new JPanel();
		panelA.setBackground(new Color(255, 228, 181));
		panelA.setBounds(79, 50, 499, 35);
		panel_2.add(panelA);
		panelA.setLayout(new GridLayout(1, 0, 0, 0));
		lbl1 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl1[i] = new JLabel("");
			// lbl1[0] = new JLabel("A");
			Font newFont = new Font("맑은고딕", Font.BOLD, 16);
			lbl1[i].setFont(newFont);
			panelA.add(lbl1[i]);
		}

		panelB = new JPanel();
		panelB.setBackground(new Color(255, 228, 181));
		panelB.setBounds(79, 95, 499, 35);
		panel_2.add(panelB);
		panelB.setLayout(new GridLayout(1, 0, 0, 0));
		lbl2 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl2[i] = new JLabel("");
			// lbl2[0] = new JLabel("B");
			Font newFont = new Font("맑은고딕", Font.BOLD, 16);
			lbl2[i].setFont(newFont);
			panelB.add(lbl2[i]);
		}

		panelC = new JPanel();
		panelC.setBackground(new Color(255, 228, 181));
		panelC.setBounds(79, 140, 499, 35);
		panel_2.add(panelC);
		panelC.setLayout(new GridLayout(1, 0, 0, 0));
		lbl3 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl3[i] = new JLabel("");
			// lbl3[0] = new JLabel("C");
			Font newFont = new Font("맑은고딕", Font.BOLD, 16);
			lbl3[i].setFont(newFont);
			panelC.add(lbl3[i]);
		}

		panelD = new JPanel();
		panelD.setBackground(new Color(255, 228, 181));
		panelD.setBounds(79, 185, 499, 35);
		panel_2.add(panelD);
		panelD.setLayout(new GridLayout(1, 0, 0, 0));
		lbl4 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl4[i] = new JLabel("");
			// lbl4[0] = new JLabel("D");
			Font newFont = new Font("맑은고딕", Font.BOLD, 16);
			lbl4[i].setFont(newFont);
			panelD.add(lbl4[i]);
		}

		panelE = new JPanel();
		panelE.setBackground(new Color(255, 228, 181));
		panelE.setBounds(79, 230, 499, 35);
		panel_2.add(panelE);
		panelE.setLayout(new GridLayout(1, 0, 0, 0));
		lbl5 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			lbl5[i] = new JLabel("");
			// lbl5[0] = new JLabel("E");
			Font newFont = new Font("맑은고딕", Font.BOLD, 16);
			lbl5[i].setFont(newFont);
			panelE.add(lbl5[i]);
		}

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(250, 250, 210));
		panel_8.setBounds(10, 354, 353, 57);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);

		JButton btnReset = new JButton("");
		btnReset.setContentAreaFilled(false);
		btnReset.setBorderPainted(false);
		btnReset.setFocusPainted(false);
		btnReset.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset.setBounds(124, 10, 101, 33);
		panel_8.add(btnReset);
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.WEST, btnReset, 25, SpringLayout.WEST, panel);
        
        		
        		btnAuto = new JToggleButton("");
        		sl_panel.putConstraint(SpringLayout.NORTH, checkBtn, 0, SpringLayout.NORTH, btnAuto);
        		sl_panel.putConstraint(SpringLayout.WEST, checkBtn, 6, SpringLayout.EAST, btnAuto);
        		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, panel);
        		sl_panel.putConstraint(SpringLayout.WEST, btnAuto, 6, SpringLayout.EAST, comboBox);
        		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, 116, SpringLayout.EAST, comboBox);
        		panel.add(btnAuto);
        		btnAuto.setContentAreaFilled(false);
        		btnAuto.setBorderPainted(false);
        		btnAuto.setFocusPainted(false);
        		//btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
        		btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
        btnAuto.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 선택 상태에 따라 이미지 변경
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동빨강3.png")));
                } else {
                   btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
                }
            }
        });
	/*	btnAuto = new JToggleButton("");
		btnAuto.setBounds(180, 0, 132, 48);
		panel_8.add(btnAuto);
		btnAuto.setContentAreaFilled(false);
		btnAuto.setBorderPainted(false);
		btnAuto.setFocusPainted(false);
		// btnAuto.setIcon(new
		// ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
		btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, -34, SpringLayout.WEST, checkBtn);
		btnAuto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 선택 상태에 따라 이미지 변경
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동빨강3.png")));
				} else {
					btnAuto.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/자동버튼4.png")));
				}
			}
		});*/
		
		
		// 오른쪽 숫자들 초기화하는 버튼
		JButton btnReset_1 = new JButton("");
		btnReset_1.setContentAreaFilled(false);
		btnReset_1.setBorderPainted(false);
		btnReset_1.setFocusPainted(false);
		btnReset_1.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset_1.setBounds(590, 50, 100, 35);
		panel_2.add(btnReset_1);

		JButton btnReset_2 = new JButton("");
		btnReset_2.setContentAreaFilled(false);
		btnReset_2.setBorderPainted(false);
		btnReset_2.setFocusPainted(false);
		btnReset_2.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset_2.setBounds(590, 95, 100, 34);
		panel_2.add(btnReset_2);

		JButton btnReset_3 = new JButton("");
		btnReset_3.setContentAreaFilled(false);
		btnReset_3.setBorderPainted(false);
		btnReset_3.setFocusPainted(false);
		btnReset_3.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset_3.setBounds(590, 140, 100, 36);
		panel_2.add(btnReset_3);

		JButton btnReset_4 = new JButton("");
		btnReset_4.setContentAreaFilled(false);
		btnReset_4.setBorderPainted(false);
		btnReset_4.setFocusPainted(false);
		btnReset_4.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset_4.setBounds(590, 185, 100, 35);
		panel_2.add(btnReset_4);

		JButton btnReset_5 = new JButton("");
		btnReset_5.setContentAreaFilled(false);
		btnReset_5.setBorderPainted(false);
		btnReset_5.setFocusPainted(false);
		btnReset_5.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/초기화버튼3.png")));
		btnReset_5.setBounds(590, 230, 100, 35);
		panel_2.add(btnReset_5);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_13.setBounds(0, 50, 50, 43);
		panel_2.add(lblNewLabel_13);

		JLabel lblNewLabel_13_1 = new JLabel("");
		lblNewLabel_13_1.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_13_1.setBounds(0, 95, 50, 43);
		panel_2.add(lblNewLabel_13_1);

		JLabel lblNewLabel_13_1_1 = new JLabel("");
		lblNewLabel_13_1_1.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_13_1_1.setBounds(0, 140, 50, 43);
		panel_2.add(lblNewLabel_13_1_1);

		JLabel lblNewLabel_13_1_1_1 = new JLabel("");
		lblNewLabel_13_1_1_1.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_13_1_1_1.setBounds(0, 185, 50, 43);
		panel_2.add(lblNewLabel_13_1_1_1);

		JLabel lblNewLabel_13_1_1_2 = new JLabel("");
		lblNewLabel_13_1_1_2.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/페페얼굴3.png")));
		lblNewLabel_13_1_1_2.setBounds(0, 230, 50, 43);
		panel_2.add(lblNewLabel_13_1_1_2);

		JLabel lblNewLabel_14 = new JLabel("A");
		lblNewLabel_14.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		lblNewLabel_14.setBounds(46, 50, 34, 35);
		panel_2.add(lblNewLabel_14);

		JLabel lblNewLabel_14_1 = new JLabel("B");
		lblNewLabel_14_1.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		lblNewLabel_14_1.setBounds(46, 95, 34, 35);
		panel_2.add(lblNewLabel_14_1);

		JLabel lblNewLabel_14_2 = new JLabel("C");
		lblNewLabel_14_2.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		lblNewLabel_14_2.setBounds(46, 140, 34, 35);
		panel_2.add(lblNewLabel_14_2);

		JLabel lblNewLabel_14_3 = new JLabel("D");
		lblNewLabel_14_3.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		lblNewLabel_14_3.setBounds(46, 185, 34, 35);
		panel_2.add(lblNewLabel_14_3);

		JLabel lblNewLabel_14_4 = new JLabel("E");
		lblNewLabel_14_4.setFont(new Font("Segoe UI Black", Font.BOLD, 36));
		lblNewLabel_14_4.setBounds(46, 230, 34, 35);
		panel_2.add(lblNewLabel_14_4);
		
		btnReset_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 8; i++) {
					lbl1[i].setText(lbl2[i].getText());
					lbl2[i].setText(lbl3[i].getText());
					lbl3[i].setText(lbl4[i].getText());
					lbl4[i].setText(lbl5[i].getText());
					lbl5[i].setText("");
				}
				resetModify();
//				priceLbl.setText(String.valueOf(Integer.parseInt(priceLbl.getText()) - 1000)+"원");
			}
		});
		btnReset_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 8; i++) {
					lbl2[i].setText(lbl3[i].getText());
					lbl3[i].setText(lbl4[i].getText());
					lbl4[i].setText(lbl5[i].getText());
					lbl5[i].setText("");
				}
				resetModify();
			}
		});
		btnReset_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 8; i++) {
					lbl3[i].setText(lbl4[i].getText());
					lbl4[i].setText(lbl5[i].getText());
					lbl5[i].setText("");
				}
				resetModify();
			}
		});
		btnReset_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 8; i++) {
					lbl4[i].setText(lbl5[i].getText());
					lbl5[i].setText("");
				}
				resetModify();
			}
		});
		btnReset_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 8; i++) {
					lbl5[i].setText("");
				}
				resetModify();
			}
		});

		
		
		
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(12, 79, 345, 265);
		getContentPane().add(panel_1);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(250, 250, 210));
		panel_9.setBounds(479, 337, 437, 131);
		getContentPane().add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("보유금액:");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_3.setBounds(12, 15, 73, 22);
		panel_9.add(lblNewLabel_3);


		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/충전버튼44.png")));
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
		btnNewButton_1.setBounds(315, 10, 123, 35);
		panel_9.add(btnNewButton_1);
		lblNewLabel_10 = new JLabel("");
		Font newFont = new Font("맑은 고딕", Font.BOLD, 16);
		lblNewLabel_10.setFont(newFont);
		lblNewLabel_10.setBounds(86, 10, 221, 33);
		panel_9.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("결제금액:");
		lblNewLabel_11.setForeground(new Color(0, 0, 128));
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_11.setBounds(12, 63, 73, 22);
		panel_9.add(lblNewLabel_11);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/구매버튼3.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog jdp = new ConfirmPurchaseDialog(PurchaseGUI.this, firstpage, chargeGUI);
				jdp.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(315, 58, 123, 35);
		panel_9.add(btnNewButton_2);

		priceLbl = new JLabel("");
		Font newFont2 = new Font("맑은 고딕", Font.BOLD, 16);
		priceLbl.setForeground(new Color(0, 0, 0));
		priceLbl.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		if (FirstPage.nowPrice <= 0) {
			priceLbl.setText("0");
		}
		priceLbl.setBounds(92, 67, 221, 15);
		panel_9.add(priceLbl);
		
		JLabel lblNewLabel_15 = new JLabel("원");
		lblNewLabel_15.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_15.setBounds(134, 59, 57, 31);
		panel_9.add(lblNewLabel_15);
		
		JLabel lblNewLabel_12 = new JLabel("번호 선택");
		lblNewLabel_12.setForeground(new Color(0, 0, 128));
		lblNewLabel_12.setBackground(new Color(255, 255, 0));
		lblNewLabel_12.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_12.setBounds(129, 33, 102, 35);
		getContentPane().add(lblNewLabel_12);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/Image/시작화면돌아가기버튼44.png")));
		btnNewButton_3.setBounds(722, 478, 176, 39);
		getContentPane().add(btnNewButton_3);
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
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : toggleButtons) {

					button.setSelected(false);
				}
			}
		});

		showGUI();
	}

	// 토글 버튼에서 숫자를 추출하고, 그 숫자들을 리스트로 반환 메소드
	static List<Integer> getSelectedNumbers() {
		List<Integer> selectedNumbers00 = new ArrayList<>();
		for (JToggleButton button : toggleButtons) {
			if (button.isSelected()) {
				int num = Integer.parseInt(button.getText());
				selectedNumbers00.add(num);
			}
		}
		return selectedNumbers00;
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
		setSize(1099, 566);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);
	}

	public Map<Integer, JLabel[]> getMap() {
		return map;
	}

	public void setFirstPage(FirstPage firstPage) {
		this.firstpage = firstPage;
	}

	public void resetModify() {
		sumSelectedCombo--;
		FirstPage.nowPrice -= 1000;
		if (FirstPage.nowPrice <= 0) {
			FirstPage.nowPrice = 0;
			priceLbl.setText("0");
		} else {
			priceLbl.setText(String.valueOf(Integer.parseInt(priceLbl.getText()) - 1000));
		}
	}

// nowPrice를 초기화하는 메서드 추가
	public void resetNowPrice() {
		FirstPage.nowPrice = 0;
	}

	public static void main(String[] args) {
	}
}