package Lotto;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ConfirmPurchaseDialog extends JDialog {
   private PurchaseGUI purchaseGUI;
   private JButton btnOkay;
   private JButton btnNo;
   private FirstPage firstPage;
   private ChargeGUI chargeGUI;
   private JLabel lblNewLabel_1;

   public ConfirmPurchaseDialog(PurchaseGUI purchaseGUI, FirstPage firstPage, ChargeGUI chargGUI) {
      super(purchaseGUI);
      getContentPane().setBackground(new Color(250, 250, 210));
      this.purchaseGUI = purchaseGUI;
      this.firstPage = firstPage;
      this.chargeGUI = chargGUI;

      extracted();

      btnOkay.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Map<Integer, JLabel[]> map = purchaseGUI.getMap();
            FirstPage.customer.lottoList = map;
            dispose();
            firstPage.setVisible(true);
            purchaseGUI.dispose();
            chargGUI.lblNewLabel.setText("(현재 잔액: " + (FirstPage.customer.getAmount() - FirstPage.nowPrice) + "원)");
//            PurchaseGUI purchaseGUI2 = new PurchaseGUI(firstPage, chargGUI);
//            WinningGUI winningGUI2 = new WinningGUI(firstPage);
            
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
      setSize(350, 376);
      setLocationRelativeTo(purchaseGUI);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      getContentPane().setLayout(null);
      
      lblNewLabel_1 = new JLabel("\r\n");
      lblNewLabel_1.setIcon(new ImageIcon(ConfirmPurchaseDialog.class.getResource("/Image/페페고민3.png")));
      lblNewLabel_1.setBounds(79, 76, 204, 176);
      getContentPane().add(lblNewLabel_1);

   }

   private void extracted() {
      btnOkay = new JButton("");
      btnOkay.setContentAreaFilled(false);
      btnOkay.setBorderPainted(false);
      btnOkay.setFocusPainted(false);
      btnOkay.setIcon(new ImageIcon(ConfirmPurchaseDialog.class.getResource("/Image/확인버튼큰3.png")));
      btnOkay.setBackground(new Color(0, 0, 255));
      btnOkay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnOkay.setBounds(12, 262, 143, 52);
      getContentPane().add(btnOkay);

      btnNo = new JButton("");
      btnNo.setContentAreaFilled(false);
      btnNo.setBorderPainted(false);
      btnNo.setFocusPainted(false);
      btnNo.setIcon(new ImageIcon(ConfirmPurchaseDialog.class.getResource("/Image/취소버튼2.png")));
      btnNo.setBackground(Color.RED);
      btnNo.setBounds(179, 262, 143, 65);
      getContentPane().add(btnNo);

      JLabel lblNewLabel = new JLabel("정말 구매하시겠습니까?");
      lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 17));
      lblNewLabel.setBounds(69, 21, 214, 37);
      getContentPane().add(lblNewLabel);
   }
}