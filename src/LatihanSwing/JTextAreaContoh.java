package LatihanSwing;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaContoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public JTextAreaContoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        JTextAreaContoh swingControlDemo = new JTextAreaContoh();
        swingControlDemo.showListDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(100, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showListDemo() {
        headerLabel.setText("Control in action: JTextArea");

        JLabel nameLabel = new JLabel("User ID :", JLabel.RIGHT);
        final JTextArea commentText = new JTextArea("Ada Apa dengan mu Pada hari ini mas bro, baik baik saja ka", 10, 20);
        
        JScrollPane scrollPane = new JScrollPane(commentText);

        JButton showBtn = new JButton("SHOW");
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                statusLabel.setText(commentText.getText());
            }
            
        });
        

        controlPanel.add(nameLabel);

        controlPanel.add(scrollPane);
        controlPanel.add(showBtn);
        mainFrame.setVisible(true);
    }
}
