
package LatihanSwing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowListener_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JFrame aboutFrame;

   public WindowListener_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      WindowListener_Contoh  swingListenerDemo = new WindowListener_Contoh();  
      swingListenerDemo.showWindowListenerDemo();
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
   private void showWindowListenerDemo(){
      headerLabel.setText("Listener in action: WindowListener");      
      JButton okButton = new JButton("OK");
      aboutFrame = new JFrame();
      aboutFrame.setSize(300, 200);
      aboutFrame.addWindowListener(new CustomWindowListener());
      JPanel panel = new JPanel();
      panel.setBackground(Color.red);
      JLabel label = new JLabel("Selmst Datang Teman");
      panel.add(okButton);
      panel.add(label);
      aboutFrame.add(panel);
      aboutFrame.setVisible(true);
      
   }
   class CustomWindowListener implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            aboutFrame.dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
       
   }

}