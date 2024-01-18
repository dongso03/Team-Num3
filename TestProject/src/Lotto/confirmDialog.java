package Lotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class confirmDialog extends JDialog {

	private ChargeGUI chargeGUI;
	// private Customer customer;
	private Customer customer = new Customer(100, 1); // 이거 수정해야됨

	public confirmDialog(ChargeGUI chargeGUI,Customer c) {
        super(chargeGUI);
        this.chargeGUI = chargeGUI;
        this.customer = c;
        
		setTitle("확인창");
		setModal(true);
		
		//customer = new Customer();
		JPanel pnl = new JPanel();
		JLabel lblcon = new JLabel("정말 충전하시겠습니까?");
		JLabel lblcon2 = new JLabel("");
		JButton btn2 = new JButton("확인");
		JButton btn3 = new JButton("취소");
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.NORTH, btn2, 0, SpringLayout.NORTH, btn3);
		sl_pnl.putConstraint(SpringLayout.WEST, btn2, 0, SpringLayout.WEST, lblcon);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn3, 37, SpringLayout.SOUTH, lblcon);
		sl_pnl.putConstraint(SpringLayout.EAST, btn3, 0, SpringLayout.EAST, lblcon2);
		sl_pnl.putConstraint(SpringLayout.NORTH, lblcon2, 98, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, lblcon2, -62, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, lblcon, 71, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblcon, -15, SpringLayout.NORTH, lblcon2);
		
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = chargeGUI.textField.getText();
				Integer number = Integer.valueOf(str);
				int a = customer.addToAmount(number);
				customer.setAmount(a);
				
				//System.out.println(customer.getAmount());
				chargeGUI.textField.setText("");
				setVisible(false); 
				
			}
		});
		
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chargeGUI.textField.setText("");
				dispose();
			}
		});
		
		pnl.setLayout(sl_pnl);
		pnl.add(lblcon);
		pnl.add(lblcon2);
		pnl.add(btn2);
		pnl.add(btn3);

		getContentPane().add(pnl);
		

		setSize(300, 300);
		// setLocation(parent.getX()-parent.getWidth(), parent.getY());
		setLocationRelativeTo(chargeGUI);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}