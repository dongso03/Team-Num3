package Lotto;


import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


public class PurchaseGUI extends JFrame {
	public PurchaseGUI() {
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 349, 353, 79);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("반자동");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("수량");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 12, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
		panel.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("입력");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4, 6, SpringLayout.EAST, comboBox);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("자동");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_3, 29, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_3);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수동");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, -112, SpringLayout.EAST, panel);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("초기화");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_1);
		panel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 405, 418);
		getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 162, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 69, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 32, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 30, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_2);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 29, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_2);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 30, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel_2);
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(29, 79, 310, 241);
		getContentPane().add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_5 = new JButton("1");
		panel_2_1.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("2");
		panel_2_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("3");
		panel_2_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("4");
		panel_2_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("5");
		panel_2_1.add(btnNewButton_10);
		
		JButton btnNewButton_6 = new JButton("6");
		panel_2_1.add(btnNewButton_6);
		
		JButton btnNewButton_11 = new JButton("7");
		panel_2_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("8");
		panel_2_1.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("9");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("10");
		panel_2_1.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("11");
		panel_2_1.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("12");
		panel_2_1.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("13");
		panel_2_1.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("14");
		panel_2_1.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("15");
		panel_2_1.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("16");
		panel_2_1.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("17");
		panel_2_1.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("18");
		panel_2_1.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("19");
		panel_2_1.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("20");
		panel_2_1.add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("21");
		panel_2_1.add(btnNewButton_25);
		
		JButton btnNewButton_26 = new JButton("22");
		panel_2_1.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("23");
		panel_2_1.add(btnNewButton_27);
		
		JButton btnNewButton_28 = new JButton("24");
		panel_2_1.add(btnNewButton_28);
		
		JButton btnNewButton_29 = new JButton("25");
		panel_2_1.add(btnNewButton_29);
		
		JButton btnNewButton_30 = new JButton("26");
		panel_2_1.add(btnNewButton_30);
		
		JButton btnNewButton_31 = new JButton("27");
		panel_2_1.add(btnNewButton_31);
		
		JButton btnNewButton_32 = new JButton("28");
		btnNewButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2_1.add(btnNewButton_32);
		
		JButton btnNewButton_33 = new JButton("29");
		panel_2_1.add(btnNewButton_33);
		
		JButton btnNewButton_34 = new JButton("30");
		panel_2_1.add(btnNewButton_34);
		
		JButton btnNewButton_35 = new JButton("31");
		panel_2_1.add(btnNewButton_35);
		
		JButton btnNewButton_36 = new JButton("32");
		panel_2_1.add(btnNewButton_36);
		
		JButton btnNewButton_37 = new JButton("33");
		panel_2_1.add(btnNewButton_37);
		
		JButton btnNewButton_38 = new JButton("34");
		panel_2_1.add(btnNewButton_38);
		
		JButton btnNewButton_39 = new JButton("35");
		panel_2_1.add(btnNewButton_39);
		
		JButton btnNewButton_40 = new JButton("36");
		panel_2_1.add(btnNewButton_40);
		
		JButton btnNewButton_41 = new JButton("37");
		panel_2_1.add(btnNewButton_41);
		
		JButton btnNewButton_42 = new JButton("38");
		panel_2_1.add(btnNewButton_42);
		
		JButton btnNewButton_43 = new JButton("39");
		panel_2_1.add(btnNewButton_43);
		
		JButton btnNewButton_44 = new JButton("40");
		panel_2_1.add(btnNewButton_44);
		
		JButton btnNewButton_45 = new JButton("41");
		panel_2_1.add(btnNewButton_45);
		
		JButton btnNewButton_46 = new JButton("42");
		btnNewButton_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2_1.add(btnNewButton_46);
		
		JButton btnNewButton_47 = new JButton("43");
		panel_2_1.add(btnNewButton_47);
		
		JButton btnNewButton_48 = new JButton("44");
		panel_2_1.add(btnNewButton_48);
		
		JButton btnNewButton_49 = new JButton("45");
		panel_2_1.add(btnNewButton_49);
		
		JButton btnNum = new JButton();
		for (int i = 1; i < 45; i++) {
			btnNum.add(btnNum, String.valueOf(i), i);
		}
	}
}
