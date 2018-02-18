
package layout_swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayout_Contoh {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public CardLayout_Contoh(){
      prepareGUI();
   }
   public static void main(String[] args){
      CardLayout_Contoh swingLayoutDemo = new CardLayout_Contoh();  
      swingLayoutDemo.showCardLayoutDemo();       
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
   private void showCardLayoutDemo(){
      headerLabel.setText("Layout in action: CardLayout");      
      
      JPanel panel =new JPanel();
      panel.setBackground(Color.CYAN);
      panel.setSize(300,300);
      
      CardLayout layout = new CardLayout(10, 10);
      panel.setLayout(layout);
      
      JPanel btPanel = new JPanel();
      btPanel.add(new JButton("OK"));
      btPanel.add(new JButton("Cancel"));
      
      JPanel txtPanel = new JPanel();
      txtPanel.add(new JLabel("Nama :"));
      txtPanel.add(new JTextField(20));
      
      panel.add("Button", btPanel);
      panel.add("Text", txtPanel);
      
      DefaultComboBoxModel panelName = new DefaultComboBoxModel();
      panelName.addElement("Button");
      panelName.addElement("Text");
      
      final JComboBox lisComboBox =new JComboBox(panelName);
      lisComboBox.setSelectedIndex(0);
      
      JScrollPane listScrollPane = new JScrollPane(lisComboBox);
  
      JButton showButton = new JButton("Show");
      showButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String data= "";
              if (lisComboBox.getSelectedIndex()!= -1) {
                  CardLayout cardLayout = (CardLayout) panel.getLayout();
                  cardLayout.show(panel, (String) lisComboBox.getItemAt(lisComboBox.getSelectedIndex()));
              }
              statusLabel.setText(data);
          }
      });
      controlPanel.add(listScrollPane);
      controlPanel.add(showButton);
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
}