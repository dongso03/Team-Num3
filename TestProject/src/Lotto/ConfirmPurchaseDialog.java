package Lotto;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ConfirmPurchaseDialog extends JDialog {
	private PurchaseGUI purchaseGUI;
	private JButton btnOkay;
	private JButton btnNo;
	private FirstPage firstPage;
	private ChargeGUI chargeGUI;

	public ConfirmPurchaseDialog(PurchaseGUI purchaseGUI, FirstPage firstPage, ChargeGUI chargGUI) {
		super(purchaseGUI);
		this.purchaseGUI = purchaseGUI;
		this.firstPage = firstPage;
		this.chargeGUI = chargGUI;

		extracted();

		btnOkay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<Integer, JLabel[]> map = purchaseGUI.getMap();
				FirstPage.customer.lottoList = map;
				dispose();
				firstPage.setVisible(true);
				purchaseGUI.dispose();
				chargGUI.lblNewLabel.setText("(현재 잔액: " + (FirstPage.customer.getAmount() - FirstPage.nowPrice) + "원)");
//				PurchaseGUI purchaseGUI2 = new PurchaseGUI(firstPage, chargGUI);
//				WinningGUI winningGUI2 = new WinningGUI(firstPage);
				
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
		btnOkay.setBackground(Color.BLUE);
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOkay.setBounds(27, 140, 97, 23);
		getContentPane().add(btnOkay);

		btnNo = new JButton("취소");
		btnNo.setBackground(Color.RED);
		btnNo.setBounds(153, 140, 97, 23);
		getContentPane().add(btnNo);

		JLabel lblNewLabel = new JLabel("정말 구매하시겠습니까?");
		lblNewLabel.setFont(new Font("궁서체", Font.ITALIC, 16));
		lblNewLabel.setBounds(50, 88, 187, 15);
		getContentPane().add(lblNewLabel);
	}
}
