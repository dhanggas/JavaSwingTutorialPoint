
package LatihanSwing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListener_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public MouseListener_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      MouseListener_Contoh  swingListenerDemo = new MouseListener_Contoh();  
      swingListenerDemo.showMouseListenerDemo();
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
   private void showMouseListenerDemo(){
      headerLabel.setText("Listener in action: MouseListener");      

      JPanel panel = new JPanel();      
      panel.setBackground(Color.magenta);
      panel.setLayout(new FlowLayout());        
//      panel.addMouseListener(new CustomMouseListener());

      JLabel msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.",JLabel.CENTER);        
      panel.add(msglabel);

      msglabel.addMouseListener(new CustomMouseListener());
      panel.add(msglabel);

      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
  class CustomMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            statusLabel.setText("Mouse Klicked : "+e.getX()+ " , "+e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
      
  }
}