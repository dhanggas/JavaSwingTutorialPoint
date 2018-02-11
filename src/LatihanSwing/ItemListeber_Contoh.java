
package LatihanSwing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemListeber_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public ItemListeber_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      ItemListeber_Contoh  swingListenerDemo = new ItemListeber_Contoh();  
      swingListenerDemo.showItemListenerDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showItemListenerDemo(){
JCheckBox chkApple = new JCheckBox("Apple");
      JCheckBox chkMango = new JCheckBox("Mango");
      JCheckBox chkPeer = new JCheckBox("Peer");  
      chkApple.addItemListener(new CustomItemListener());
      chkMango.addItemListener(new CustomItemListener());
      chkPeer.addItemListener(new CustomItemListener());
      
      controlPanel.add(chkPeer);
      controlPanel.add(chkApple);
      controlPanel.add(chkMango);
      mainFrame.setVisible(true);
   }
   

   class CustomItemListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            statusLabel.setText(((JCheckBox)e.getItem()).getText() +(e.getStateChange()==1?" checked":" uncheked"));
        }
       
   }
}