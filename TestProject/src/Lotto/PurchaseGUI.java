package Lotto;


import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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


public class PurchaseGUI extends JFrame {
	 private List<JToggleButton> toggleButtons;
	private JButton btnAuto;
	
	public PurchaseGUI() {
		getContentPane().setLayout(null);
		 toggleButtons = new ArrayList<>();
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
		
		String[] list = new String[] {"1","2","3","4","5"};
		JComboBox comboBox = new JComboBox(list);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 12, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
		panel.add(comboBox);
		
		
		JButton btnNewButton_4 = new JButton("확인");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_4, 6, SpringLayout.EAST, comboBox);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_4);
		
		btnAuto = new JButton("자동");
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnAuto, 29, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, 0, SpringLayout.EAST, lblNewLabel);
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnAuto);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("초기화");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_2, 76, SpringLayout.EAST, btnNewButton);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 345, 317);
		getContentPane().add(panel_1);
		
		for (int i = 1; i <= 45; i++) {
            JToggleButton togbtn = new JToggleButton(String.valueOf(i));
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
	
	 private void handleToggleButtonAction(JToggleButton clickedButton) {
	        int selectedCount = 0;

	        for (JToggleButton button : toggleButtons) {
	            if (button.isSelected()) {
	                selectedCount++;
	            }
	        }

	        if (selectedCount > 6) {
	            JOptionPane.showMessageDialog(this, "최대 6개까지 선택 가능합니다.");
	            clickedButton.setSelected(false);
	        }
	    }
	private void showGUI(){
		setSize(815,501);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PurchaseGUI();
	}
}
