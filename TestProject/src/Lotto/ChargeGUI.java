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
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ChargeGUI extends JFrame {
	public JTextField textField;
	private JButton btn;
	PurchaseGUI purchaseGUI;
	private JButton btnReset;
	FirstPage firstPage;
	public JLabel lblNewLabel;
	ConfirmPurchaseDialog confirmPurchaseDialog;

	public ChargeGUI(FirstPage firstPage) {
		getContentPane().setBackground(new Color(250, 250, 210));
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

		// 입력값이 -일 경우
		else if (!str.isEmpty() && Integer.valueOf(str) < 0) {
			JOptionPane.showMessageDialog(this, " 올바른 충전 금액을 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
			textField.setText("");
			return;
		}

		// 입력값이 너무 클 경우(천만원)
		else if (!str.isEmpty() && Integer.valueOf(str) > 10000000) {
			JOptionPane.showMessageDialog(this, " 천만원 이내에서만 충전가능합니다. 충전금액을 다시 입력해주세요.", "알림",
					JOptionPane.WARNING_MESSAGE);
			textField.setText("");
			return;
		}

		Integer number;

		try {
			number = Integer.valueOf(str);
			JDialog jd = new confirmDialog(ChargeGUI.this);
			jd.setVisible(true);

			FirstPage.customer.subtractToAmount(FirstPage.nowPrice);
			lblNewLabel.setText("(현재 잔액: " + FirstPage.customer.getAmount() + "원)");

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "유효한 숫자를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
		setLocationRelativeTo(null);
	}

	private void extracted() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JLabel lbl = new JLabel("충전 금액 입력");
		springLayout.putConstraint(SpringLayout.WEST, lbl, 10, SpringLayout.WEST, getContentPane());
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getContentPane().add(lbl);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lbl);
		springLayout.putConstraint(SpringLayout.WEST, textField, 60, SpringLayout.EAST, lbl);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 21, SpringLayout.NORTH, lbl);
		getContentPane().add(textField);
		textField.setColumns(10);

		btn = new JButton("");
		springLayout.putConstraint(SpringLayout.EAST, textField, -30, SpringLayout.WEST, btn);
		springLayout.putConstraint(SpringLayout.WEST, btn, 350, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btn, -29, SpringLayout.EAST, getContentPane());
		btn.setIcon(new ImageIcon(ChargeGUI.class.getResource("/Image/확인버튼2.png")));
		btn.setBackground(new Color(0, 0, 255));
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setFont(new Font("궁서체", Font.ITALIC, 14));
		getContentPane().add(btn);

		btnReset = new JButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnReset, 149, SpringLayout.WEST, getContentPane());
		btnReset.setIcon(new ImageIcon(ChargeGUI.class.getResource("/Image/시작화면돌아가기버튼44.png")));
		btnReset.setFont(new Font("궁서체", Font.ITALIC, 14));
		btnReset.setContentAreaFilled(false);
		btnReset.setBorderPainted(false);
		btnReset.setFocusPainted(false);
		btnReset.setBackground(Color.RED);
		getContentPane().add(btnReset);

		lblNewLabel = new JLabel("(현재 잔액: " + FirstPage.customer.getAmount() + "원)");
		springLayout.putConstraint(SpringLayout.NORTH, btnReset, 22, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, btn);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 199, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -73, SpringLayout.EAST, getContentPane());
		Font newFont2 = new Font("맑은 고딕", Font.BOLD, 16);
		lblNewLabel.setFont(newFont2);
		getContentPane().add(lblNewLabel);

		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, btn, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 27, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -178, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -29, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lbl, 18, SpringLayout.SOUTH, panel);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChargeGUI.class.getResource("/Image/개구리.jpg")));
		lblNewLabel_1.setBounds(0, 0, 428, 273);
		panel.add(lblNewLabel_1);
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();

		new ChargeGUI(firstPage);

	}
}