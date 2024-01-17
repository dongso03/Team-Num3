package Lotto;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinningGUI extends JFrame{
	FirstPage firstPage;
	
	public WinningGUI(FirstPage firstPage) {
		setTitle("당첨확인");
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JLabel lbl = new JLabel("구매 내역: ");
		lbl.setBounds(73, 24, 84, 15);
		pnl.add(lbl);
		
		String[] list = new String[] {"","1회차","당첨된 것만 보기"};
		JComboBox comboBox = new JComboBox(list);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		comboBox.setBounds(169, 21, 178, 21);
		pnl.add(comboBox);
		
		
		getContentPane().add(pnl);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 88, 363, 64);
		pnl.add(panel);
		panel.setLayout(null);
		
		// 당첨 숫자 라벨
		JLabel result_1 = new JLabel("");
		result_1.setBounds(12, 10, 28, 27);
		panel.add(result_1);
		
		JLabel result_2 = new JLabel("");
		result_2.setBounds(52, 10, 28, 27);
		panel.add(result_2);
		
		JLabel result_3 = new JLabel("");
		result_3.setBounds(92, 10, 28, 27);
		panel.add(result_3);
		
		JLabel result_4 = new JLabel("");
		result_4.setBounds(132, 10, 28, 27);
		panel.add(result_4);
		
		JLabel result_5 = new JLabel("");
		result_5.setBounds(171, 9, 28, 27);
		panel.add(result_5);
		
		JLabel result_6 = new JLabel("");
		result_6.setBounds(211, 9, 28, 27);
		panel.add(result_6);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("+");
		lblNewLabel_2_1_1.setBounds(251, 10, 17, 27);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("당첨 번호");
		lblNewLabel_3.setBounds(102, 39, 57, 15);
		panel.add(lblNewLabel_3);
		
		
		JLabel result_7 = new JLabel("");
		result_7.setBounds(292, 10, 28, 27);
		panel.add(result_7);
		
		
		JLabel lblNewLabel_4 = new JLabel("보너스");
		lblNewLabel_4.setBounds(292, 39, 57, 15);
		panel.add(lblNewLabel_4);
		
		Random ran = new Random();
		// 숫자 7개를 랜덤으로 뽑아내는데 6개는 오름차순으로, 하나는 보너스
		// n1~n7까지 숫자가 중복안되게 수정 필요!!!!
		//----------------------------
		Set<Integer> uniqueNumbers = new HashSet<>();

        // 중복되지 않는 6개의 난수 생성(보너스 숫자 포함x)
        while (uniqueNumbers.size() < 7) {
            int randomNumber = ran.nextInt(45) + 1;
            uniqueNumbers.add(randomNumber);
        }

       // List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);
        Set<Integer> resultList = new TreeSet<>(uniqueNumbers);
        List<Integer> uniqueList = new ArrayList<>(resultList);
        result_1.setText(String.valueOf(uniqueList.get(0)));
		result_2.setText(String.valueOf(uniqueList.get(1)));
		result_3.setText(String.valueOf(uniqueList.get(2)));
		result_4.setText(String.valueOf(uniqueList.get(4)));
		result_5.setText(String.valueOf(uniqueList.get(5)));
		result_6.setText(String.valueOf(uniqueList.get(6)));
		result_7.setText(String.valueOf(uniqueList.get(3)));
        
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(40, 162, 363, 64);
		pnl.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 0, 305, 64);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(306, 0, 57, 64);
		panel_1.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("처음 화면으로 돌아가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstPage.setVisible(true);
				dispose();
				
			}
		});
		
		btnNewButton.setBounds(294, 236, 178, 23);
		pnl.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("당첨규칙 확인하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//다이얼로그 만들기
				JDialog dia = new MyDialog(WinningGUI.this);
				dia.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(294, 269, 178, 23);
		pnl.add(btnNewButton_1);
		
		showGUI();
	}
	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}

	public static void main(String[] args) {
		FirstPage firstPage = new FirstPage();
		new WinningGUI(firstPage);
	}
}

class MyDialog extends JDialog{
	public MyDialog(JFrame parent) {
		super(parent); 
		setTitle("당첨 규칙 확인");
		setModal(true);
		String labelText = "<html>* 로또는 온라인복권입니다.<br/>"
				+ "온라인복권이란 복권 발행시스템을 갖춘 중앙전산센터와 정보통신망으로 연결된 단말기를 통해 복권의 발행 및 판매가 이루어지는 복권으로 인터넷복권과는 다른 개념입니다.<br/>"
				+ "<br/>"
				+ "* 자동, 반자동, 수동으로 고객이 선택하여 구입할 수 있습니다.<br/>"
				+ "“자동선택”을 선택하거나 판매인에게 요청하여 45개의 번호 중 6개 번호를 임의로 부여받는 방법, 1개~5개 번호 중 원하는 번호를 선택하고 나머지 번호는 임의로 부여받는 방법, 고객이 6개 번호를 모두 직접 선택하는 방법 중에서 원하는 대로 구입할 수 있습니다."
				+ "</html>";
		JLabel lblRule = new JLabel(labelText);
		add(lblRule);
		
		setSize(400,400);
		setLocationRelativeTo(parent); 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	}
}

