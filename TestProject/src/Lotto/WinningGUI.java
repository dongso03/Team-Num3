package Lotto;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinningGUI extends JFrame{
	public WinningGUI() {
		setTitle("당첨확인");
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JLabel lbl = new JLabel("구매 내역: ");
		lbl.setBounds(73, 24, 84, 15);
		pnl.add(lbl);
		add(pnl);
		
		String[] list = new String[] {"","1회차","당첨된 것만 보기"};
		JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(169, 21, 178, 21);
		pnl.add(comboBox);
		
		
		
		showGUI();
	}

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WinningGUI();
	}
	
}
