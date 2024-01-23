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
            
    //       System.out.println(purchaseGUI.getMap()); 
//            for(int i= 0; i< 8;i++) {
//            winningGUI.lblAs[i].setText("하이");
//            }
    //        for(int i= 0; i< 8;i++) {
           // winningGUI.lblB.setText("하이");
//            }
//            for(int i= 0; i<8;i++) {
//            winningGUI.lblAs[i].setText(Arrays.toString(purchaseGUI.lbl1));
//            }
            for(int i= 0; i<8;i++) {
            winningGUI.pirntNumbersA.add(customer.lottoList.get(1)[i]);
            }
            // customer.lottoList.get(1) 이게 A라벨들(스트링임.)(앞에 두 개빼고 숫자 6개)인데. 
            // 이걸 uniqueList integer(숫자 7개)들과 비교하여 
            // 포함을 x개 하고  있다면 1등이니깐 settext "당첨" 아니면 "낙첨"    66000 32000
            
            
            
            
            for(int i= 0; i<8;i++) {
               winningGUI.pirntNumbersB.add(customer.lottoList.get(2)[i]);
            }
            for(int i= 0; i<8;i++) {
               winningGUI.pirntNumbersC.add(customer.lottoList.get(3)[i]);
            }
            for(int i= 0; i<8;i++) {
               winningGUI.pirntNumbersD.add(customer.lottoList.get(4)[i]);
            }
            for(int i= 0; i<8;i++) {
               winningGUI.pirntNumbersE.add(customer.lottoList.get(5)[i]);
            }
            setVisible(false);
            winningGUI.setVisible(true);
         }
      });

      showGUI();
   }

   private void showGUI() {
      setSize(597, 438);
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

      btnPuchase = new JButton("");
      btnPuchase.setIcon(new ImageIcon(FirstPage.class.getResource("/Image/구매2.jpg")));
      btnPuchase.setFont(new Font("굴림", Font.BOLD, 15));
      btnPuchase.setBounds(12, 301, 203, 77);
     // btnPuchase.setContentAreaFilled(false);
      //btnPuchase.setBorderPainted(false);
      //btnPuchase.setFocusPainted(false);
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
      btnCharge.setBounds(253, 360, 98, 18);
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
      btnWinning.setBounds(417, 358, 111, 23);
      panel.add(btnWinning);
      springLayout.putConstraint(SpringLayout.WEST, btnWinning, 529, SpringLayout.WEST, getContentPane());
      springLayout.putConstraint(SpringLayout.NORTH, btnWinning, 233, SpringLayout.NORTH, getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, btnWinning, -21, SpringLayout.SOUTH, getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnWinning, -105, SpringLayout.EAST, getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, btnPuchase, -93, SpringLayout.WEST, btnWinning);
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