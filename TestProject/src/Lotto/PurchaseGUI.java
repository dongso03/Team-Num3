package Lotto;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;

public class PurchaseGUI extends JFrame {
   private List<JToggleButton> toggleButtons;
   FirstPage firstpage;
   JToggleButton btnAuto;
   JToggleButton togbtn;

   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_4;
   private JLabel lblNewLabel_5;
   private JLabel lblNewLabel_6;
   private JLabel lblNewLabel_7;
   private JLabel lblNewLabel_8;
   private JLabel lblNewLabel_9;
   private JLabel[] lbl1;
   private JLabel[] lbl2s;

<<<<<<< HEAD
   public PurchaseGUI(FirstPage firstpage) {
      getContentPane().setLayout(null);
      toggleButtons = new ArrayList<>();
      Panel panel = new Panel();
      panel.setBounds(10, 349, 353, 79);
      getContentPane().add(panel);
      SpringLayout sl_panel = new SpringLayout();
      panel.setLayout(sl_panel);
      Random ran = new Random();
=======
	public PurchaseGUI(FirstPage firstpage) {
		getContentPane().setLayout(null);
		toggleButtons = new ArrayList<>();
		Panel panel = new Panel();
		panel.setBounds(10, 394, 353, 31);
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		Random ran = new Random();
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

      JLabel lblNewLabel = new JLabel("수량");
      panel.add(lblNewLabel);

<<<<<<< HEAD
//      String[] list = new String[] { "1", "2", "3", "4", "5" };
//      JComboBox comboBox = new JComboBox(list);
=======
		String[] list = new String[] { "1", "2", "3", "4", "5" };
		JComboBox comboBox = new JComboBox(list);

//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		JComboBox<Integer> comboBox = new JComboBox<>();
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
		panel.add(comboBox);
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

<<<<<<< HEAD
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
      JComboBox<Integer> comboBox = new JComboBox<>(numbers.toArray(new Integer[0]));
      sl_panel.putConstraint(SpringLayout.WEST, comboBox, 102, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, comboBox, -146, SpringLayout.EAST, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, comboBox);
      sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -9, SpringLayout.WEST, comboBox);
      sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel);
      panel.add(comboBox);
=======
		JButton checkBtn = new JButton("확인");
		sl_panel.putConstraint(SpringLayout.NORTH, checkBtn, -4, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, checkBtn, 18, SpringLayout.EAST, comboBox);

		// 확인 버튼을 눌렀을 때 -------------------------------------------------
		checkBtn.addActionListener(new ActionListener() {
			private List<Integer> selectedNumbers = new ArrayList<>();
			int selectCount = 0;
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

<<<<<<< HEAD
      JButton checkBtn = new JButton("확인");
      sl_panel.putConstraint(SpringLayout.EAST, checkBtn, -37, SpringLayout.EAST, panel);
=======
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedIndex()) {
				case 0: // 1장 선택했을 때
					if (!btnAuto.isSelected()) { // 수동
						selectedNumbers.addAll(getSelectedNumbers());
						Collections.sort(selectedNumbers);
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

<<<<<<< HEAD
      // 확인 버튼을 눌렀을 때 -------------------------------------------------
      checkBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            switch (comboBox.getSelectedIndex()) {
            case 0: // 1장 선택했을 때
               // 수동 자도 ㅇㅂ 반자동 => 이걸 메소드로 만들자
               if (!btnAuto.isSelected()) { // 수동인 거임
                  List<Integer> selectedNumbers = new ArrayList<>();
=======
						for (int i = 2; i < 8; i++) {
							lbl1[1].setText("수동");
							lbl1[i].setText(String.valueOf(selectedNumbers.get(i - 2)));
						}
					} else { // 자동 버튼을 클릭
						Set<Integer> notDuplicate = new HashSet<>(); // 중복없는 숫자 집합
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

<<<<<<< HEAD
                  for (JToggleButton button : toggleButtons) {
                     if (button.isSelected()) {
                        int num = Integer.parseInt(button.getText());
                        selectedNumbers.add(num);
                     }
                  }
                  Collections.sort(selectedNumbers); // 숫자로 바뀐 녀석들이 오름차순으로 정렬했음

                  for (int i = 2; i < 8; i++) {
                     lbl1[1].setText("수동");
                     lbl1[i].setText(String.valueOf(selectedNumbers.get(i - 2)));
                  }
               } else { // 자동 버튼을 클릭했을 때
                  // all 자동
                  // List<Integer> selectedNumbers = new ArrayList<>();
                  Set<Integer> uniqueNumbers = new HashSet<>();
                  int selectCount = 0;

                  for (JToggleButton button : toggleButtons) {
                     if (button.isSelected()) { // 중복되지 않고 랜덤 숫자 6개 만들기
                        selectCount++;
                     }
                  }
                  
                  if(selectCount == 0) {  // all 자동
                     while (uniqueNumbers.size() < 7) {
                           int randomNumber = ran.nextInt(45) + 1;
                           uniqueNumbers.add(randomNumber);
                       }
                     List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);
                     Collections.sort(uniqueList); // 인덱스 0~ 6까지 숫자 다 뽑아내라
                     for (int i = 2; i < 8; i++) {
                        lbl1[1].setText("자동");
                        lbl1[i].setText(String.valueOf(uniqueList.get(i - 2)));
                     }
                  } else if(0< selectCount && selectCount < 6) { // 반자동
                     // 선택된 숫자들 불러오고 나머지 숫자들은 랜덤. 중복되면 안되고 오름차순!
//                     List<Integer> selectedNumbers = new ArrayList<>();
//
//                     for (JToggleButton button : toggleButtons) {
//                        if (button.isSelected()) {
//                           int num = Integer.parseInt(button.getText());
//                           selectedNumbers.add(num);
//                        }
//                     }
//                     Collections.sort(selectedNumbers); // 숫자로 바뀐 녀석들이 오름차순으로 정렬했음
//
//                     for (int i = 2; i < 8; i++) {
//                        lbl1[1].setText("수동");
//                        lbl1[i].setText(String.valueOf(selectedNumbers.get(i - 2)));
                     
                  }
                  
               }

            }

            for (JToggleButton button : toggleButtons) {
               button.setSelected(false);
            }
         }
      });
      panel.add(checkBtn);

      JButton btnReset = new JButton("초기화");
      sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 12, SpringLayout.SOUTH, comboBox);
      sl_panel.putConstraint(SpringLayout.NORTH, checkBtn, 0, SpringLayout.NORTH, btnReset);
      sl_panel.putConstraint(SpringLayout.EAST, btnReset, -243, SpringLayout.EAST, panel);
      btnReset.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (JToggleButton button : toggleButtons) {

               button.setSelected(false);
            }
         }
      });
      panel.add(btnReset);
      // Random ran = new Random();

      btnAuto = new JToggleButton("자동");
      sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 12, SpringLayout.SOUTH, comboBox);
      sl_panel.putConstraint(SpringLayout.WEST, btnAuto, 23, SpringLayout.EAST, btnReset);
      panel.add(btnAuto);
      btnAuto.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (comboBox.getSelectedItem().toString().equals("1")) {

            } else if (comboBox.getSelectedItem().toString().equals("2")) {

            } else if (comboBox.getSelectedItem().toString().equals("3")) {

            } else if (comboBox.getSelectedItem().toString().equals("4")) {
=======
						for (JToggleButton button : toggleButtons) {
							if (button.isSelected()) { // 중복되지 않고 랜덤 숫자 6개 만들기
								selectCount++;
							}
						}
								// all 자동
						if (selectCount == 0 || selectCount == 6) {
							while (notDuplicate.size() < 7) {
								int randomNumber = ran.nextInt(45) + 1;
								notDuplicate.add(randomNumber);
							}
							List<Integer> lottoResult = new ArrayList<>(notDuplicate);
							Collections.sort(lottoResult); // 인덱스 0~ 6까지 숫자 다 뽑아내라
							for (int i = 2; i < 8; i++) {
								lbl1[1].setText("자동");
								lbl1[i].setText(String.valueOf(lottoResult.get(i - 2)));
							}   // 반자동인 경우
						} else if (0 < selectCount && selectCount < 6) { // 사용자가 1개 이상 5개 이하로 숫자를 선택시
							selectedNumbers.addAll(getSelectedNumbers());
							// Set<Integer> notDuplicate 중복을 허용하지 않는 set에 선택한 숫자들 전부 넣어주기
							notDuplicate.addAll(selectedNumbers);
							while (notDuplicate.size() < 7) { // 숫자들이 중복되지 않으면서, 크기가 6이 넘지 않게
								int r = ran.nextInt(45) + 1;
								notDuplicate.add(r);
							}
							// 오름차순으로 정렬하기위해 set -> list로 변환해줌
							List<Integer> lottoResult = new ArrayList<>(notDuplicate);
							Collections.sort(lottoResult); // 오름차순으로 정렬
							for (int i = 2; i < 8; i++) {
								lbl1[1].setText("반자동");
								lbl1[i].setText(String.valueOf(lottoResult.get(i - 2)));
							}
						}
					}

					break;
				case 1:

					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				}

				for (JToggleButton button : toggleButtons) {
					button.setSelected(false);
				}
			}
		});
		panel.add(checkBtn);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(369, 10, 405, 418);
		getContentPane().add(panel_2);
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

            } else if (comboBox.getSelectedItem().toString().equals("5")) {

            }
         }
      });
      JPanel panel_2 = new JPanel();
      panel_2.setBounds(369, 10, 405, 418);
      getContentPane().add(panel_2);

      panel_2.setLayout(null);

      JLabel lblNewLabel_1 = new JLabel("선택번호 확인");
      lblNewLabel_1.setBounds(164, 5, 76, 15);
      panel_2.add(lblNewLabel_1);

      JPanel panel_3 = new JPanel();
      panel_3.setBounds(24, 50, 301, 35);
      panel_2.add(panel_3);
      panel_3.setLayout(new GridLayout(1, 0, 0, 0));
      lbl1 = new JLabel[8];
      for (int i = 0; i < 8; i++) {
         lbl1[i] = new JLabel("d");
         panel_3.add(lbl1[i]);
      }

      // 오른쪽 숫자들 초기화하는 버튼
      JButton btnNewButton = new JButton("초기화");
      btnNewButton.setBounds(328, 50, 65, 23);
      panel_2.add(btnNewButton);

      JPanel panel_4 = new JPanel();
      panel_4.setBounds(23, 95, 302, 35);
      panel_2.add(panel_4);
      panel_4.setLayout(new GridLayout(1, 0, 0, 0));
      lbl2s = new JLabel[8];
      for (int i = 0; i < 8; i++) {
         lbl2s[i] = new JLabel("d");
         panel_4.add(lbl2s[i]);
      }

      JPanel panel_5 = new JPanel();
      panel_5.setBounds(24, 140, 302, 35);
      panel_2.add(panel_5);
      panel_5.setLayout(new GridLayout(1, 0, 0, 0));
      JLabel[] lbl3 = new JLabel[8];
      for (int i = 0; i < 8; i++) {
         lbl3[i] = new JLabel("d");
         panel_5.add(lbl3[i]);
      }

      JPanel panel_6 = new JPanel();
      panel_6.setBounds(24, 185, 301, 35);
      panel_2.add(panel_6);
      panel_6.setLayout(new GridLayout(1, 0, 0, 0));
      JLabel[] lbl4 = new JLabel[8];
      for (int i = 0; i < 8; i++) {
         lbl4[i] = new JLabel("d");
         panel_6.add(lbl4[i]);
      }

      JPanel panel_7 = new JPanel();
      panel_7.setBounds(24, 230, 301, 35);
      panel_2.add(panel_7);
      panel_7.setLayout(new GridLayout(1, 0, 0, 0));
      JLabel[] lbl5 = new JLabel[8];
      for (int i = 0; i < 8; i++) {
         lbl5[i] = new JLabel("d");
         panel_7.add(lbl5[i]);
      }

      btnNewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            for (int i = 2; i < 8; i++) {
               lbl1[1].setText("미지정");
               lbl1[i].setText("");
            }

<<<<<<< HEAD
         }
      });
=======
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 337, 353, 31);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);

		JButton btnReset = new JButton("초기화");
		btnReset.setBounds(98, 10, 69, 23);
		panel_8.add(btnReset);
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.WEST, btnReset, 25, SpringLayout.WEST, panel);
		// Random ran = new Random();

		btnAuto = new JToggleButton("자동");
		btnAuto.setBounds(193, 10, 57, 23);
		panel_8.add(btnAuto);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAuto, 0, SpringLayout.NORTH, checkBtn);
		sl_panel.putConstraint(SpringLayout.EAST, btnAuto, -34, SpringLayout.WEST, checkBtn);
		btnAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("1")) {

				} else if (comboBox.getSelectedItem().toString().equals("2")) {

				} else if (comboBox.getSelectedItem().toString().equals("3")) {

				} else if (comboBox.getSelectedItem().toString().equals("4")) {

				} else if (comboBox.getSelectedItem().toString().equals("5")) {

				}
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JToggleButton button : toggleButtons) {

					button.setSelected(false);
				}
			}
		});

		for (int i = 1; i <= 45; i++) {
			togbtn = new JToggleButton(String.valueOf(i));
			togbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					handleToggleButtonAction(togbtn);
				}
			});
			panel_1.add(togbtn);
			toggleButtons.add(togbtn);
		}
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

      JPanel panel_1 = new JPanel();
      panel_1.setBounds(12, 10, 345, 317);
      getContentPane().add(panel_1);

<<<<<<< HEAD
      for (int i = 1; i <= 45; i++) {
         togbtn = new JToggleButton(String.valueOf(i));
         togbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               handleToggleButtonAction(togbtn);
            }
         });
         panel_1.add(togbtn);
         toggleButtons.add(togbtn);
      }
=======
	
	// 토글 버튼에서 숫자를 추출하고, 그 숫자들을 리스트로 반환 메소드
	private List<Integer> getSelectedNumbers() {
		List<Integer> selectedNumbers = new ArrayList<>();
		for (JToggleButton button : toggleButtons) {
			if (button.isSelected()) {
				int num = Integer.parseInt(button.getText());
				selectedNumbers.add(num);
			}
		}
		return selectedNumbers;
	}
	

	private void handleToggleButtonAction(JToggleButton togbtn) {
		int selectedCount = 0;
		this.togbtn = togbtn;
		List<JToggleButton> a = new ArrayList<>();
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

      showGUI();
   }

   private void handleToggleButtonAction(JToggleButton togbtn) {
      int selectedCount = 0;
      this.togbtn = togbtn;
      List<JToggleButton> a = new ArrayList<>();

      for (JToggleButton button : toggleButtons) {
         if (button.isSelected()) {
            a.add(button);
            selectedCount++;
         }
      }

<<<<<<< HEAD
      if (selectedCount == 7) {
         JOptionPane.showMessageDialog(this, "최대 6개까지 선택 가능합니다.");
         // 모든 토글 버튼을 대상으로 확인하여 선택이 되어있는 경우 선택 취소
         a.get(6).setSelected(false);
=======
	private void showGUI() {
		setSize(815, 567);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
	}
>>>>>>> branch 'gayoung' of https://github.com/dongso03/Team-Num3.git

      }
   }

   private void showGUI() {
      setSize(815, 501);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setVisible(false);
   }

   public static void main(String[] args) {
      FirstPage firstpage = new FirstPage();
      new PurchaseGUI(firstpage);
   }
}