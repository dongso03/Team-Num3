package Lotto;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChargeGUI extends JFrame {
	public JTextField textField;
	private JButton btn;
	PurchaseGUI purchaseGUI;
	private JButton btnReset;
	FirstPage firstPage;
	private JLabel lblNewLabel;

	public ChargeGUI(FirstPage firstPage) {
		extracted();
	
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleConfirmButtonClick();
			}
		});

		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                    firstPage.setVisible(true);
                    dispose();

				if (firstPage != null) {
					firstPage.setVisible(true);
				}
				dispose();
			}
		});
		
		
		showGUI();

	}
	private void handleConfirmButtonClick() {
 
        String str = textField.getText();

        // 입력값이 비어있을 경우 알림을 표시하고 함수 종료
        if (str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "충전 금액을 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
        

        Integer number ;
       
        	
        	try {
        		number =  Integer.valueOf(str);
        		JDialog jd = new confirmDialog(ChargeGUI.this);
				jd.setVisible(true);
				 
				lblNewLabel.setText("(현재 잔액: " + FirstPage.customer.getAmount() +"원)");
				
        		
        	} catch (NumberFormatException e) {
        		JOptionPane.showMessageDialog(this, "유효한 숫자를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
        	}
       
    }

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	private void extracted() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JLabel lbl = new JLabel("충전 금액 입력");
		springLayout.putConstraint(SpringLayout.WEST, lbl, 41, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbl, -221, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(lbl);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lbl);
		springLayout.putConstraint(SpringLayout.WEST, textField, 42, SpringLayout.EAST, lbl);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btn = new JButton("확인");
		springLayout.putConstraint(SpringLayout.NORTH, btn, -4, SpringLayout.NORTH, lbl);
		springLayout.putConstraint(SpringLayout.WEST, btn, 338, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btn, -41, SpringLayout.EAST, getContentPane());
		getContentPane().add(btn);

		btnReset = new JButton("시작화면 돌아가기");
		springLayout.putConstraint(SpringLayout.NORTH, btnReset, 77, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnReset, 0, SpringLayout.WEST, textField);
		getContentPane().add(btnReset);
		
		lblNewLabel = new JLabel("(현재 잔액: " + FirstPage.customer.getAmount() +"원)");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 8, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 163, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, textField);
		getContentPane().add(lblNewLabel);
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		
		new ChargeGUI(firstPage);

	}
	
}