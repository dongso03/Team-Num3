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
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;

public class FirstPage extends JFrame {
   private JButton btnCharge;
   private JButton btnPuchase;
   private JButton btnWinning;
   private ChargeGUI chargGUI;
   private PurchaseGUI purchaseGUI;
   private WinningGUI winningGUI;
   public static Customer customer;
   private JPanel panel;
   static int nowPrice = 0;
   List<Integer> uniqueList;
   int[] uniqueArray;
   
   
   public FirstPage() {
      customer = new Customer(1000, 1);
      chargGUI = new ChargeGUI(this);
      winningGUI = new WinningGUI(this);
      purchaseGUI = new PurchaseGUI(this, chargGUI);
      ImageIcon icon = new ImageIcon("Image/캡처.PNG");
      uniqueList = winningGUI.uniqueList;
      uniqueArray = uniqueList.stream().mapToInt(Integer::intValue).toArray();
      
      
      extracted();
      btnCharge.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            chargGUI.setVisible(true);
            //chargGUI.lblNewLabel.setText(text);
            
         }
      });

      btnPuchase.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            setVisible(false);
            purchaseGUI.setVisible(true);
            purchaseGUI.lblNewLabel_10.setText("(현재 잔액: " + (FirstPage.customer.getAmount() - nowPrice) + "원)");
         }
      });
      btnWinning.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

             for (int i = 0; i < 8; i++) {
                winningGUI.pirntNumbersA.add(customer.lottoList.get(1)[i]);
             }
             for (int i = 0; i < 8; i++) {
                winningGUI.pirntNumbersB.add(customer.lottoList.get(2)[i]);
             }
             for (int i = 0; i < 8; i++) {
                winningGUI.pirntNumbersC.add(customer.lottoList.get(3)[i]);
             }
             for (int i = 0; i < 8; i++) {
                winningGUI.pirntNumbersD.add(customer.lottoList.get(4)[i]);
             }
             for (int i = 0; i < 8; i++) {
                winningGUI.pirntNumbersE.add(customer.lottoList.get(5)[i]);
             }
             
             // 각 숫자를 문자열로 변환하여 일치 여부 체크하여 당첨, 낙첨 확인하는 부분
             for(int a = 1; a< 6; a++) {
                // 최소 6개의 일치 여부를 체크하는 변수 matchingCount
                int matchingCount = 0;
                // 사용자가 선택한  1장을 배열에 집어 넣음
                JLabel[] lottoListLabels = customer.lottoList.get(a);
                for (int i = 0; i < 7; i++) { // 복권 당첨 숫자 7개
                   for (int j = 2; j < 8; j++) { // 사용자가 선택한 숫자들을 6개
                      
                      String uniqueNumber = String.valueOf(uniqueArray[i]);
                      String labelNumber = lottoListLabels[j].getText();
                      
                      if (uniqueNumber.equals(labelNumber)) { // 복권당첨 숫자와 사용자가 선택한 숫자가 같은 게 있다면 매칭카운트 1증가
                         matchingCount++;
                      }
                   }
                }
                switch(a) {
                case 1:
                   // 최소 6개 이상의 일치 여부 확인
                   if (matchingCount >= 6) {
                      winningGUI.lblNewLabel.setText("당첨");
                   } else {
                      winningGUI.lblNewLabel.setText("낙첨");
                   }
                   break;
                case 2:
                   if (matchingCount >= 6) {
                      winningGUI.lblNewLabel_1.setText("당첨");
                   } else {
                      winningGUI.lblNewLabel_1.setText("낙첨");
                   }
                   
                   break;
                case 3:
                   if (matchingCount >= 6) {
                      winningGUI.lblNewLabel_2.setText("당첨");
                   } else {
                      winningGUI.lblNewLabel_2.setText("낙첨");
                   }
                   
                   break;
                case 4:
                   if (matchingCount >= 6) {
                      winningGUI.lblNewLabel_6.setText("당첨");
                   } else {
                      winningGUI.lblNewLabel_6.setText("낙첨");
                   }
                   
                   break;
                case 5:
                   if (matchingCount >= 6) {
                      winningGUI.lblNewLabel_7.setText("당첨");
                   } else {
                      winningGUI.lblNewLabel_7.setText("낙첨");
                   }
                   
                   break;
                }
             }
             setVisible(false);
             winningGUI.setVisible(true);
          }
       });

      showGUI();
   }

   private void showGUI() {
      setSize(793, 533);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      setLocationRelativeTo(null);
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
      btnPuchase.setFont(new Font("굴림", Font.BOLD, 15));
      btnPuchase.setBounds(100, 415, 98, 23);
      btnPuchase.setContentAreaFilled(false);
      btnPuchase.setBorderPainted(false);
      btnPuchase.setFocusPainted(false);
      panel.add(btnPuchase);
      springLayout.putConstraint(SpringLayout.SOUTH, btnPuchase, -10, SpringLayout.SOUTH, getContentPane());
      btnPuchase.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      springLayout.putConstraint(SpringLayout.NORTH, btnPuchase, 17, SpringLayout.SOUTH, panel);
      springLayout.putConstraint(SpringLayout.WEST, btnPuchase, 84, SpringLayout.EAST, btnCharge);

      btnCharge = new JButton("충전하기");
      btnCharge.setFont(new Font("굴림", Font.BOLD, 15));
      btnCharge.setBounds(337, 417, 98, 18);
      btnCharge.setContentAreaFilled(false);
      btnCharge.setBorderPainted(false);
      btnCharge.setFocusPainted(false);
      panel.add(btnCharge);

      springLayout.putConstraint(SpringLayout.NORTH, btnCharge, -151, SpringLayout.SOUTH, getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, btnCharge, 57, SpringLayout.WEST, getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, btnCharge, 0, SpringLayout.SOUTH, getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnCharge, 207, SpringLayout.WEST, getContentPane());

      btnWinning = new JButton("당첨확인");
      btnWinning.setFont(new Font("굴림", Font.BOLD, 15));
      btnWinning.setContentAreaFilled(false);
      btnWinning.setBorderPainted(false);
      btnWinning.setFocusPainted(false);
      btnWinning.setBounds(549, 415, 111, 23);
      panel.add(btnWinning);
      springLayout.putConstraint(SpringLayout.WEST, btnWinning, 529, SpringLayout.WEST, getContentPane());
      springLayout.putConstraint(SpringLayout.NORTH, btnWinning, 233, SpringLayout.NORTH, getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, btnWinning, -21, SpringLayout.SOUTH, getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnWinning, -105, SpringLayout.EAST, getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnPuchase, -93, SpringLayout.WEST, btnWinning);
      
      JLabel lblNewLabel = new JLabel("New label");
      lblNewLabel.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/sfdasfdasfda.jpg")));
      lblNewLabel.setBounds(-184, -11, 1361, 624);
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