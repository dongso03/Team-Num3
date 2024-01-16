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

public class ChargeGUI extends JFrame{
	private JTextField textField;
	private JButton btn;
	Customer customer;
	
	public ChargeGUI() {
		extracted();
		 customer = new Customer();
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new confirmDialog(ChargeGUI.this);
				jd.setVisible(true);
				JPanel pnl = new JPanel();
				JButton btn2 = new JButton("확인");
				JButton btn3 = new JButton("취소");
				
			}
		});

		showGUI();
		
	}
	private void showGUI(){
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class confirmDialog extends JDialog {
		public confirmDialog(JFrame parent) {
			super (parent);
			setTitle("확인창");
			setModal(true);
			
			setSize(300,300);
		//	setLocation(parent.getX()-parent.getWidth(), parent.getY());
			setLocationRelativeTo(parent);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
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
	}
	public static void main(String[] args) {
		new ChargeGUI();
		
	}
	
}
