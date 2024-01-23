package Lotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Font;

public class confirmDialog extends JDialog {

   private ChargeGUI chargeGUI;
   // private Customer customer;
   
   

   public confirmDialog(ChargeGUI chargeGUI) {
        super(chargeGUI);
        this.chargeGUI = chargeGUI;
        
        
      setTitle("확인창");
      setModal(true);
      
      //customer = new Customer();
      JPanel pnl = new JPanel();
      JLabel lblcon = new JLabel("정말 충전하시겠습니까?");
      lblcon.setFont(new Font("궁서체", Font.ITALIC, 16));
      JLabel lblcon2 = new JLabel("");
      JButton btn2 = new JButton("확인");
      btn2.setBackground(Color.BLUE);
      JButton btn3 = new JButton("취소");
      btn3.setBackground(Color.RED);
      SpringLayout sl_pnl = new SpringLayout();
      sl_pnl.putConstraint(SpringLayout.NORTH, btn2, 28, SpringLayout.SOUTH, lblcon);
      sl_pnl.putConstraint(SpringLayout.WEST, lblcon, 0, SpringLayout.WEST, btn2);
      sl_pnl.putConstraint(SpringLayout.SOUTH, lblcon, -6, SpringLayout.NORTH, lblcon2);
      sl_pnl.putConstraint(SpringLayout.NORTH, btn3, 0, SpringLayout.NORTH, btn2);
      sl_pnl.putConstraint(SpringLayout.WEST, btn3, 51, SpringLayout.EAST, btn2);
      sl_pnl.putConstraint(SpringLayout.WEST, btn2, 47, SpringLayout.WEST, pnl);
      sl_pnl.putConstraint(SpringLayout.NORTH, lblcon2, 98, SpringLayout.NORTH, pnl);
      sl_pnl.putConstraint(SpringLayout.EAST, lblcon2, -62, SpringLayout.EAST, pnl);
      
      
      btn2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            String str = chargeGUI.textField.getText();
            int number = Integer.valueOf(str);
            Integer a = FirstPage.customer.addToAmount(Integer.valueOf(number));
            FirstPage.customer.setAmount(a);
            
         
            //System.out.println(customer.getAmount());
            chargeGUI.textField.setText("");
            setVisible(false); 
            
         }
      });
      
      
      btn3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            chargeGUI.textField.setText("");
            dispose();
         }
      });
      
      pnl.setLayout(sl_pnl);
      pnl.add(lblcon);
      pnl.add(lblcon2);
      pnl.add(btn2);
      pnl.add(btn3);

      getContentPane().add(pnl);
      

      setSize(300, 300);
      // setLocation(parent.getX()-parent.getWidth(), parent.getY());
      setLocationRelativeTo(chargeGUI);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
}