package Lotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public 	class confirmDialog extends JDialog {
	
	private ChargeGUI chargeGUI;
	private Customer customer;
	
	public confirmDialog(ChargeGUI chargeGUI) {
        super(chargeGUI);
        this.chargeGUI = chargeGUI;
        this.customer = new Customer();
		setTitle("확인창");
		setModal(true);
		
		//chargeGUI = new ChargeGUI();
		customer = new Customer();
		JPanel pnl = new JPanel();
		JLabel lblcon = new JLabel("정말 충전하시겠습니까?");
		JLabel lblcon2 = new JLabel("확인버튼 누를시 시작화면으로");
		JButton btn2 = new JButton("확인");
		JButton btn3 = new JButton("취소");
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.NORTH, lblcon2, 98, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, lblcon2, -62, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn3, 22, SpringLayout.SOUTH, lblcon2);
		sl_pnl.putConstraint(SpringLayout.WEST, btn3, 165, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn2, 0, SpringLayout.NORTH, btn3);
		sl_pnl.putConstraint(SpringLayout.WEST, btn2, 0, SpringLayout.WEST, lblcon2);
		sl_pnl.putConstraint(SpringLayout.WEST, lblcon, 71, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblcon, -15, SpringLayout.NORTH, lblcon2);
		
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = chargeGUI.textField.getText();
				//System.out.println(str);
				Integer number = Integer.valueOf(str);
				customer.addToAmount(number);
				
				System.out.println(customer.getAmount());
				
				
			}
		});
		
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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