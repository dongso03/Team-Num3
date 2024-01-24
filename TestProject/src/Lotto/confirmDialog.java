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
import javax.swing.ImageIcon;

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
      pnl.setBackground(new Color(250, 250, 210));
      JLabel lblcon = new JLabel("정말 충전하시겠습니까?");
      lblcon.setFont(new Font("궁서체", Font.ITALIC, 20));
      JLabel lblcon2 = new JLabel("");
      JButton btn2 = new JButton("");
      btn2.setContentAreaFilled(false);
      btn2.setBorderPainted(false);
      btn2.setFocusPainted(false);
      btn2.setIcon(new ImageIcon(confirmDialog.class.getResource("/Image/확인버튼큰3.png")));
      btn2.setBackground(Color.BLUE);
      JButton btn3 = new JButton("");
      btn3.setContentAreaFilled(false);
      btn3.setBorderPainted(false);
      btn3.setFocusPainted(false);
      btn3.setIcon(new ImageIcon(confirmDialog.class.getResource("/Image/취소버튼2.png")));
      btn3.setBackground(Color.RED);
      SpringLayout sl_pnl = new SpringLayout();
      sl_pnl.putConstraint(SpringLayout.WEST, btn3, 30, SpringLayout.EAST, btn2);
      sl_pnl.putConstraint(SpringLayout.EAST, btn3, -48, SpringLayout.EAST, pnl);
      sl_pnl.putConstraint(SpringLayout.SOUTH, btn2, 0, SpringLayout.SOUTH, btn3);
      sl_pnl.putConstraint(SpringLayout.NORTH, btn2, 0, SpringLayout.NORTH, btn3);
      sl_pnl.putConstraint(SpringLayout.WEST, btn2, 20, SpringLayout.WEST, pnl);
      sl_pnl.putConstraint(SpringLayout.EAST, btn2, -261, SpringLayout.EAST, pnl);
      sl_pnl.putConstraint(SpringLayout.SOUTH, btn3, -92, SpringLayout.SOUTH, pnl);
      sl_pnl.putConstraint(SpringLayout.NORTH, lblcon, 10, SpringLayout.NORTH, pnl);
      sl_pnl.putConstraint(SpringLayout.WEST, lblcon, 109, SpringLayout.WEST, pnl);
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
      
      JLabel lblNewLabel = new JLabel("");
      sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel, -196, SpringLayout.SOUTH, pnl);
      sl_pnl.putConstraint(SpringLayout.NORTH, btn3, 55, SpringLayout.SOUTH, lblNewLabel);
      sl_pnl.putConstraint(SpringLayout.EAST, lblNewLabel, -80, SpringLayout.WEST, lblcon2);
      lblNewLabel.setIcon(new ImageIcon(confirmDialog.class.getResource("/Image/페페고민3.png")));
      pnl.add(lblNewLabel);
      

      setSize(475, 467);
      // setLocation(parent.getX()-parent.getWidth(), parent.getY());
      setLocationRelativeTo(chargeGUI);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
}