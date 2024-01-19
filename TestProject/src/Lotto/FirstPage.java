package Lotto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.sun.prism.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FirstPage extends JFrame {
	private JButton btnCharge;
	private JButton btnPuchase;
	private JButton btnWinning;
	private ChargeGUI chargGUI;
	private PurchaseGUI purchaseGUI;
	private WinningGUI winningGUI;
	public static Customer customer;
	private JPanel panel;
	private JLabel lblNewLabel;

	public FirstPage() {
		customer = new Customer(1000, 1);
		chargGUI = new ChargeGUI(this);
		winningGUI = new WinningGUI(this);
		purchaseGUI = new PurchaseGUI(this, chargGUI);
		ImageIcon icon = new ImageIcon("Image/캡처.PNG");

		extracted();
		btnCharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				chargGUI.setVisible(true);

			}
		});

		btnPuchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				purchaseGUI.setVisible(true);
				purchaseGUI.lblNewLabel_10.setText("(현재 잔액: " + FirstPage.customer.getAmount() + "원)");
			}
		});
		btnWinning.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				winningGUI.setVisible(true);
			}
		});

		showGUI();
	}

	private void showGUI() {
		setSize(635, 438);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void extracted() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 783, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		panel.setLayout(null);

		btnPuchase = new JButton("구매하기");
		btnPuchase.setBounds(56, 179, 98, 131);
		panel.add(btnPuchase);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPuchase, -10, SpringLayout.SOUTH, getContentPane());
		btnPuchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnPuchase, 17, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnPuchase, 84, SpringLayout.EAST, btnCharge);

		btnCharge = new JButton("충전하기");
		btnCharge.setBounds(251, 179, 98, 131);
		panel.add(btnCharge);

		springLayout.putConstraint(SpringLayout.NORTH, btnCharge, -151, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCharge, 57, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCharge, 0, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCharge, 207, SpringLayout.WEST, getContentPane());

		btnWinning = new JButton("당첨확인");
		btnWinning.setBounds(422, 179, 111, 131);
		panel.add(btnWinning);
		springLayout.putConstraint(SpringLayout.WEST, btnWinning, 529, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnWinning, 233, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnWinning, -21, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnWinning, -105, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnPuchase, -93, SpringLayout.WEST, btnWinning);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/캡처.PNG")));
		lblNewLabel.setBounds(0, 0, 783, 405);
		panel.add(lblNewLabel);
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		ChargeGUI chargeGUI = new ChargeGUI(firstPage);
	}
}