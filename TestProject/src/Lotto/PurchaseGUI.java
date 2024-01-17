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


public class PurchaseGUI extends JFrame {
	 private List<JToggleButton> toggleButtons;
	FirstPage firstpage;
	 JToggleButton btnAuto;
	 JToggleButton togbtn;
	
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
		
		String[] list = new String[] {"1","2","3","4","5"};
		JComboBox comboBox = new JComboBox(list);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
		panel.add(comboBox);
		
		
		JButton btnNewButton_4 = new JButton("확인");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_4, -37, SpringLayout.EAST, panel);
		btnNewButton_4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        if (!btnAuto.isSelected()) {
			            List<Integer> selectedNumbers = new ArrayList<>();

			            for (JToggleButton button : toggleButtons) {
			                if (button.isSelected()) {
			                   
			                    selectedNumbers.add(Integer.parseInt(button.getText()));
			                }
			            }

			            
			            Collections.sort(selectedNumbers);

			           
//			            for (int i = 0; i < selectedNumbers.size(); i++) {
//			                switch (i) {
//			                    case 0:
//			                        lblA.setText(String.valueOf(selectedNumbers.get(i)));
//			                        break;
//			                    case 1:
//			                        lblB.setText(String.valueOf(selectedNumbers.get(i)));
//			                        break;
//			                    case 2:
//			                        lblC.setText(String.valueOf(selectedNumbers.get(i)));
//			                        break;
//			                    case 3:
//			                        lblD.setText(String.valueOf(selectedNumbers.get(i)));
//			                        break;
//			                    case 4:
//			                        lblE.setText(String.valueOf(selectedNumbers.get(i)));
//			                        break;
//			                }
//			            }
			        }
			        for (JToggleButton button : toggleButtons) {
			            button.setSelected(false);
			        }
			    }
			});
		panel.add(btnNewButton_4);
		
		JButton btnReset = new JButton("초기화");
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 12, SpringLayout.SOUTH, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_4, 0, SpringLayout.NORTH, btnReset);
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
				if(comboBox.getSelectedItem().toString().equals("1")) {
					
				}else if (comboBox.getSelectedItem().toString().equals("2")) {

				}else if (comboBox.getSelectedItem().toString().equals("3")) {

				}else if (comboBox.getSelectedItem().toString().equals("4")) {

				}else if (comboBox.getSelectedItem().toString().equals("5")) {

				}
			}
		});
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 405, 418);
		getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 162, SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_1);
		
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}
//	private void setRandomNumbersToLabels(int count) {
//	    List<Integer> numbers = new ArrayList<>();
//
//	    // 1부터 45까지의 숫자를 리스트에 추가
//	    for (int i = 1; i <= 45; i++) {
//	        numbers.add(i);
//	    }
//
//	    // 숫자를 섞음
//	    java.util.Collections.shuffle(numbers);
//
//	    // count 개수만큼의 숫자를 선택
//	    List<Integer> selectedNumbers = numbers.subList(0, count);
//
//	    // 선택된 숫자를 정렬하여 각 라벨에 할당
//	    java.util.Collections.sort(selectedNumbers);
//	    for (int i = 0; i < count; i++) {
//	        switch (i) {
//	            case 0:
//	                lblA.setText(String.valueOf(selectedNumbers.get(i)));
//	                break;
//	            case 1:
//	                lblB.setText(String.valueOf(selectedNumbers.get(i)));
//	                break;
//	            case 2:
//	                lblC.setText(String.valueOf(selectedNumbers.get(i)));
//	                break;
//	            case 3:
//	                lblD.setText(String.valueOf(selectedNumbers.get(i)));
//	                break;
//	            case 4:
//	                lblE.setText(String.valueOf(selectedNumbers.get(i)));
//	                break;
//	        }
//	    }
//	}
	public static void main(String[] args) {
		FirstPage firstpage = new FirstPage();
		new PurchaseGUI(firstpage);
	}
}
