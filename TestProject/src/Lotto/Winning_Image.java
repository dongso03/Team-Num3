package Lotto;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


// 당첨시 나오는 축하 이미지
class Winning_Image extends JDialog{
	public Winning_Image(WinningGUI win) {
		super(win);
		setTitle("당첨");
		// 이미지 넣기
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon("D:\\춘식\\춘식1.png"));
		pnl.add(lbl);
		getContentPane().add(pnl);
		
		setSize(300,300);
		setLocationRelativeTo(win); 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
}
