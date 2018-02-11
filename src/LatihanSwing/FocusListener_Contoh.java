
package LatihanSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FocusListener_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   JButton okButton;
   
   public FocusListener_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      FocusListener_Contoh  swingListenerDemo = new FocusListener_Contoh();  
      swingListenerDemo.showFocusListenerDemo();
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
   private void showFocusListenerDemo(){
      headerLabel.setText("Listener in action: FocusListener");      
      okButton = new JButton("OK");
      JButton cancelButton = new JButton("Cancel");
      JButton lostButton = new JButton("Cancel");
      
      okButton.addFocusListener(new CustomFocusListener());
      cancelButton.addFocusListener(new CustomFocusListener());
      controlPanel.add(okButton);
      controlPanel.add(cancelButton);
      controlPanel.add(lostButton);
      mainFrame.setVisible(true);

   }
//   class CustomFocusListener implements FocusListener{
//      public void focusGained(FocusEvent e) {
//         statusLabel.setText(statusLabel.getText() 
//            + e.getComponent().getClass().getSimpleName() + " gained focus. ");
//      }
//      public void focusLost(FocusEvent e) {
//         statusLabel.setText(statusLabel.getText() 
//            + e.getComponent().getClass().getSimpleName() + " lost focus. ");
//      }
//   }
   class CustomFocusListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            statusLabel.setText(e.getComponent().getClass().getSimpleName()+" dapat focus");
        }

        @Override
        public void focusLost(FocusEvent e) {
            statusLabel.setText(okButton.getText()+" lost focus");
        }
       
   }
}
