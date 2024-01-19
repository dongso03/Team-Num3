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

public class FirstPage extends JFrame {
	private JButton btnCharge;
	private JButton btnPuchase;
	private JButton btnWinning;
	private ChargeGUI chargGUI;
	private PurchaseGUI purchaseGUI;
	private WinningGUI winningGUI;
	public static Customer customer;

//	static JPanel page1=new JPanel() {
//		Image background=new ImageIcon(FirstPage.class.getResource("../image/background1.png")).getImage();
//		public void paint(Graphics g) {//그리는 함수
//				g.drawImage(background, 0, 0, null);//background를 그려줌		
//		}
	//};	
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
		setSize(799, 444);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void extracted() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		btnCharge = new JButton("충전하기");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCharge, -94, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCharge, 208, SpringLayout.WEST, getContentPane());
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, btnCharge, -245, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCharge, 58, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnCharge);

		btnPuchase = new JButton("구매하기");
		springLayout.putConstraint(SpringLayout.NORTH, btnPuchase, 0, SpringLayout.NORTH, btnCharge);
		springLayout.putConstraint(SpringLayout.WEST, btnPuchase, 81, SpringLayout.EAST, btnCharge);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPuchase, 0, SpringLayout.SOUTH, btnCharge);
		btnPuchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnPuchase);

		btnWinning = new JButton("당첨확인");
		springLayout.putConstraint(SpringLayout.EAST, btnPuchase, -88, SpringLayout.WEST, btnWinning);
		springLayout.putConstraint(SpringLayout.WEST, btnWinning, 527, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnWinning, -107, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnWinning, 0, SpringLayout.NORTH, btnCharge);
		springLayout.putConstraint(SpringLayout.SOUTH, btnWinning, 0, SpringLayout.SOUTH, btnCharge);
		getContentPane().add(btnWinning);
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		ChargeGUI chargeGUI = new ChargeGUI(firstPage);
	}
}