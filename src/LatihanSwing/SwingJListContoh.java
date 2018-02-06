
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingJListContoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public SwingJListContoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingJListContoh swingControlDemo = new SwingJListContoh();
        swingControlDemo.showListDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showListDemo() {
        headerLabel.setText("Control in action: JList");
        final DefaultComboBoxModel fruitName = new DefaultComboBoxModel();
        fruitName.addElement("Apel");
        fruitName.addElement("Mangga");
        fruitName.addElement("jeruk");
        fruitName.addElement("Jambu");

        final JComboBox fruitList = new JComboBox(fruitName);
        fruitList.setSelectedIndex(0);

        JScrollPane fruitListScolpane = new JScrollPane(fruitList);

        final DefaultListModel vegName = new DefaultListModel();
        vegName.addElement("Lombok ");
        vegName.addElement("Rawit");
        vegName.addElement("Potato");
        vegName.addElement("Tomato");
        
        final  JList vegList = new JList(vegName);
        vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vegList.setSelectedIndex(0);
        vegList.setVisibleRowCount(3);
        
        JScrollPane vegScorlPane = new JScrollPane(vegList);
        
        
        JButton showBtn = new JButton("SHOW");
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data ="";
                if (fruitList.getSelectedIndex()!= -1) {
                    data = "Buah yg di pilih :"+ fruitList.getItemAt(fruitList.getSelectedIndex());
                    statusLabel.setText(data);
                            }
                if (vegList.getSelectedIndex() != -1) {
                    data +="Sayuran yg dipilih :"+ vegList.getSelectedValue();
                                        

                }
                statusLabel.setText(data);
            }
        });
        
        controlPanel.add(fruitListScolpane);
        controlPanel.add(vegScorlPane);
        controlPanel.add(showBtn);
        mainFrame.setVisible(true);
    }
}

