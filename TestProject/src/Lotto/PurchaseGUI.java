package Lotto;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
	JLabel[][] labels;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	public PurchaseGUI(FirstPage firstpage) {
		getContentPane().setLayout(null);
		toggleButtons = new ArrayList<>();
		Panel panel = new Panel();
		panel.setBounds(10, 349, 353, 79);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

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
		sl_panel.putConstraint(SpringLayout.EAST, checkBtn, -37, SpringLayout.EAST, panel);
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnAuto.isSelected()) { // 수동인 거임
					List<Integer> selectedNumbers = new ArrayList<>();
					lblNewLabel_2.setText("수동");
					for (JToggleButton button : toggleButtons) {
						if (button.isSelected()) {
							int num = Integer.parseInt(button.getText());
							selectedNumbers.add(num);
						}
					}
					Collections.sort(selectedNumbers); // 숫자로 바뀐 녀석들이 오름차순으로 정렬했음
					if (selectedNumbers.size() > 0) {
						lblNewLabel_4.setText(String.valueOf(selectedNumbers.get(0)));
					} else {
						lblNewLabel_4.setText("");
					}
					if (selectedNumbers.size() > 1) {
						lblNewLabel_5.setText(String.valueOf(selectedNumbers.get(1)));
					} else {
						lblNewLabel_5.setText("");
					}
					if (selectedNumbers.size() > 1) {
						lblNewLabel_6.setText(String.valueOf(selectedNumbers.get(2)));
					} else {
						lblNewLabel_6.setText("");
					}
					if (selectedNumbers.size() > 1) {
						lblNewLabel_7.setText(String.valueOf(selectedNumbers.get(3)));
					} else {
						lblNewLabel_7.setText("");
					}
					if (selectedNumbers.size() > 1) {
						lblNewLabel_8.setText(String.valueOf(selectedNumbers.get(4)));
					} else {
						lblNewLabel_8.setText("");
					}
					if (selectedNumbers.size() > 1) {
						lblNewLabel_9.setText(String.valueOf(selectedNumbers.get(5)));
					} else {
						lblNewLabel_9.setText("");
					}

//                     lblNewLabel_4.setText(String.valueOf(selectedNumbers.indexOf(0)));
//                     lblNewLabel_5.setText(String.valueOf(selectedNumbers.indexOf(1)));
//                     lblNewLabel_6.setText(String.valueOf(selectedNumbers.indexOf(2)));
//                     lblNewLabel_7.setText(String.valueOf(selectedNumbers.indexOf(3)));
//                     lblNewLabel_8.setText(String.valueOf(selectedNumbers.indexOf(4)));
//                     lblNewLabel_9.setText(String.valueOf(selectedNumbers.indexOf(5)));

				}
				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		panel.add(checkBtn);

		JButton btnReset = new JButton("초기화");
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 12, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, checkBtn, 0, SpringLayout.NORTH, btnReset);
		sl_panel.putConstraint(SpringLayout.EAST, btnReset, -243, SpringLayout.EAST, panel);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		panel.add(btnReset);
		Random ran = new Random();

		btnAuto = new JToggleButton("자동");
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 12, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, btnAuto, 23, SpringLayout.EAST, btnReset);
		panel.add(btnAuto);
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
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 405, 418);
		getContentPane().add(panel_2);

		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		lblNewLabel_1.setBounds(164, 5, 76, 15);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(24, 50, 301, 35);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("A");
		panel_3.add(lblNewLabel_3);

		// 이 라벨에서 미지정,수동,자동,반자동 표현
		lblNewLabel_2 = new JLabel("미지정");
		panel_3.add(lblNewLabel_2);
		// 확인 버튼을 눌렸을 때 자동이 선택되어 있으면 자동이나 반자동, 자동이 선택되어 있지 않다면 수동으로 라벨 표시

		lblNewLabel_4 = new JLabel("");
		panel_3.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		panel_3.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("");
		panel_3.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		panel_3.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		panel_3.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("");
		panel_3.add(lblNewLabel_9);

		JButton btnNewButton = new JButton("초기화");
		btnNewButton.setBounds(328, 50, 65, 23);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_4.setText("");
				lblNewLabel_5.setText("");
				lblNewLabel_6.setText("");
				lblNewLabel_7.setText("");
				lblNewLabel_8.setText("");
				lblNewLabel_9.setText("");

			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 345, 317);
		getContentPane().add(panel_1);

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
		setSize(815, 501);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	public static void main(String[] args) {
		FirstPage firstpage = new FirstPage();
		new PurchaseGUI(firstpage);
	}
}