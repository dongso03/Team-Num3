package Lotto;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class ChargeGUI extends JFrame {
	public JTextField textField;
	private JButton btn;
	private Customer customer = new Customer(100,1);
	private JButton btnReset;
	FirstPage firstPage;

	public ChargeGUI() {
		extracted();
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new confirmDialog(ChargeGUI.this, customer);
				jd.setVisible(true);
				

			}
		});

		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
                if (firstPage != null) {
                    firstPage.setVisible(true);
                }

			}
		});
		showGUI();

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
	}

	
	public static void main(String[] args) {
		new ChargeGUI();

	}

}
