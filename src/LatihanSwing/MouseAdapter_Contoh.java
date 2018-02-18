package LatihanSwing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseAdapter_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel = new JLabel("",JLabel.CENTER);        
      
   private JPanel controlPanel;

   public MouseAdapter_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      MouseAdapter_Contoh  awtAdapterDemo = new MouseAdapter_Contoh();  
      awtAdapterDemo.showMouseAdapterDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      
      mainFrame.setVisible(true);  
   }
   private void showMouseAdapterDemo(){
       headerLabel.setText("Liastener in action : MouseAdater");
       JPanel panel =new JPanel();
       panel.setLayout(new FlowLayout());
       panel.setBackground(Color.green);
       panel.setSize(350, 100);
       JLabel msgJLabel =new JLabel("di coba jaj ya");
       panel.add(msgJLabel);
       
       panel.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e){
               statusLabel.setText("Mouse klicked : "+e.getX() +" , "+ e.getY());
           }
});
       
//      headerLabel.setText("Listener in action: MouseAdapter");      
//      JPanel panel = new JPanel();      
//      panel.setBackground(Color.magenta);
//      panel.setLayout(new FlowLayout());        
//      
//      panel.addMouseListener(new MouseAdapter(){
//         public void mouseClicked(MouseEvent e) {
//            statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
//         }                
//      });
//      JLabel msglabel 
//         = new JLabel("Welcome to TutorialsPoint SWING Tutorial.",JLabel.CENTER);
//      
//      msglabel.addMouseListener(new MouseAdapter(){
//         public void mouseClicked(MouseEvent e) {
//            statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
//         }                
//      });
//      panel.add(msglabel);

      controlPanel.add(panel);
      mainFrame.add(statusLabel);
      
      mainFrame.setVisible(true);  
   }
}