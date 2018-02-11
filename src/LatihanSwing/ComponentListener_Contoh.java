
package LatihanSwing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponentListener_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public ComponentListener_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      ComponentListener_Contoh  swingListenerDemo = new ComponentListener_Contoh();  
      swingListenerDemo.showComponentListenerDemo();
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

   private void showComponentListenerDemo(){
       headerLabel.setText("Listener in action : Component Listener");
       JPanel panel = new JPanel();
       panel.setBackground(Color.red);
       JLabel msglLabel = new JLabel("Welcome To TUtutial", JLabel.CENTER);
       panel.add(msglLabel);
       msglLabel.addComponentListener(new CustomComponentListener());
       controlPanel.add(panel);
       mainFrame.setVisible(true);
      
   }

   class CustomComponentListener implements ComponentListener{

        @Override
        public void componentResized(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()+e.getComponent().getClass().getSimpleName()+" reaized ");
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText()+e.getComponent().getClass().getSimpleName()+" moved ");
        }

        @Override
        public void componentShown(ComponentEvent e) {
                        statusLabel.setText(statusLabel.getText()+e.getComponent().getClass().getSimpleName()+" showd ");

        }

        @Override
        public void componentHidden(ComponentEvent e) {
                        statusLabel.setText(statusLabel.getText()+e.getComponent().getClass().getSimpleName()+" moved ");

        }
       
   }
}