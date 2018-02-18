
package LatihanSwing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FocusAdapter_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public FocusAdapter_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      FocusAdapter_Contoh  swingAdapterDemo = new FocusAdapter_Contoh();        
      swingAdapterDemo.showFocusAdapterDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples FocusAdapter");
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
   
   private void showFocusAdapterDemo(){
       headerLabel.setText("Listener in action : focusAdapter");
       JButton okButton = new JButton("OK");
       JButton cancelButton = new JButton("Cancel");
       okButton.addFocusListener(new FocusListener() {
           @Override
           public void focusGained(FocusEvent e) {
               statusLabel.setText(e.getComponent().getClass().getSimpleName()+" lagi focus ");
           }

           @Override
           public void focusLost(FocusEvent e) {
               statusLabel.setText(e.getComponent().getClass().getSimpleName()+" tidak focus");
           }
       });
       controlPanel.add(okButton);
       controlPanel.add(cancelButton);
       mainFrame.setVisible(true);
       
   }
//      headerLabel.setText("Listener in action: FocusAdapter");      
//      JButton okButton = new JButton("OK");
//      JButton cancelButton = new JButton("Cancel");
//      
//      okButton.addFocusListener(new FocusAdapter() { 
//         @Override
//         public void focusGained(FocusEvent e) {
//            statusLabel.setText(statusLabel.getText() 
//               + e.getComponent().getClass().getSimpleName() 
//               + " gained focus. ");
//         }
//      });  
//      cancelButton.addFocusListener(new FocusAdapter(){
//         @Override
//         public void focusLost(FocusEvent e) {
//            statusLabel.setText(statusLabel.getText() 
//               + e.getComponent().getClass().getSimpleName() 
//               + " lost focus");
//         }
//      });  
//      controlPanel.add(okButton);
//      controlPanel.add(cancelButton);     
//      mainFrame.setVisible(true);  
//   }
}