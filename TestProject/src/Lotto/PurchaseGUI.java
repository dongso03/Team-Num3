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
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel[] lbl1;
	private JLabel[] lbl2s;

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
					
					for (JToggleButton button : toggleButtons) {
						if (button.isSelected()) {
							int num = Integer.parseInt(button.getText());
							selectedNumbers.add(num);
						}
					}
					Collections.sort(selectedNumbers); // 숫자로 바뀐 녀석들이 오름차순으로 정렬했음
					
					for(int i = 2; i<8; i++) {
						for(int j = 0;j<6; j++) {
						lbl1[i].setText(String.valueOf(selectedNumbers.get(j)));
						}
					}


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
		lbl1 = new JLabel[8]; 
		for (int i = 0; i < 8; i++) {
		    lbl1[i] = new JLabel("d"); 
		    panel_3.add(lbl1[i]); 
		}
		

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