package Lotto;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConfirmPurchaseDialog extends JDialog {
	private PurchaseGUI purchaseGUI;
	private JButton btnOkay;
	private JButton btnNo;
	private Customer customer;
	
	
	public ConfirmPurchaseDialog(PurchaseGUI purchaseGUI) {
		super(purchaseGUI);
		this.purchaseGUI = purchaseGUI;
		

		extracted();

		btnOkay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  List<Integer> lottoNumbers = new ArrayList<>();
			        for (JLabel label : purchaseGUI.lbl1) {
			            // 여기에서 label의 텍스트를 정수로 변환하여 리스트에 추가
			            lottoNumbers.add(Integer.parseInt(label.getText()));
			        }
			        Customer.lottoList.add(lottoNumbers);
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
