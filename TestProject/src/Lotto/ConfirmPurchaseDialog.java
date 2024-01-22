package Lotto;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Container;
import java.awt.event.ActionEvent;

public class ConfirmPurchaseDialog extends JDialog {
	private PurchaseGUI purchaseGUI;
	private JButton btnOkay;
	private JButton btnNo;
	private FirstPage firstPage;
	public Map<Integer, JLabel[]> map = new HashMap<>();
	public WinningGUI winningGUI;
	public Customer customer;
	
	public Map<Integer, JLabel[]> lottoList() {
			return map;
		}
	
		public ConfirmPurchaseDialog(PurchaseGUI purchaseGUI,FirstPage firstPage) {
		super(purchaseGUI);
		this.purchaseGUI = purchaseGUI;
		this.firstPage= firstPage;
		
		extracted();
		
		

		btnOkay.addActionListener(new ActionListener() {
			//private Map<Integer, JLabel[]> map;

			@Override
			public void actionPerformed(ActionEvent e) {
				map = purchaseGUI.getMap();
				System.out.println(map);
                customer.lottoList = map;
				
//				for(int i = 0; i < purchaseGUI.map.size(); i++) {
//					JLabel[] value = purchaseGUI.map.get(i+1);
//					mapp.put(i+1, value);
//				}
//				System.out.println(mapp.get(1)[1]);
				
				//winningGUI.setLblAs(purchaseGUI.map.get(1));
				
				
                dispose();
			    firstPage.setVisible(true); 
			    purchaseGUI.setVisible(false);
				  
			        dispose();
			    }
			});

		btnNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setTitle("확인창");
		setModal(true);
		setSize(300, 300);
		setLocationRelativeTo(purchaseGUI);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

	}

	

	private void extracted() {
		btnOkay = new JButton("확인");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnOkay.setBounds(31, 115, 97, 23);
		getContentPane().add(btnOkay);

		btnNo = new JButton("취소");
		btnNo.setBounds(140, 115, 97, 23);
		getContentPane().add(btnNo);

		JLabel lblNewLabel = new JLabel("정말 구매하시겠습니까?");
		lblNewLabel.setBounds(68, 68, 131, 15);
		getContentPane().add(lblNewLabel);
	}
}
