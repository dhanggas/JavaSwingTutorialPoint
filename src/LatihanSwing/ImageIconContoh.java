package LatihanSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageIconContoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ImageIconContoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ImageIconContoh swingControlDemo = new ImageIconContoh();
        swingControlDemo.showListDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(600, 400);
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

    private static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = ImageIconContoh.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void showListDemo() {
        headerLabel.setText("Control in action: JList");

        JLabel nameLabel = new JLabel("User ID :", JLabel.RIGHT);
        JLabel paswdLabel = new JLabel("Password :", JLabel.CENTER);
        final JTextField userTxt = new JTextField(6);
        final JPasswordField pasTxt = new JPasswordField(6);

        ImageIcon icon = new ImageIcon("src/gambar/windows_16.png");
        JButton showBtn = new JButton("SHOW",icon);
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "User nama : " + userTxt.getText();
                data += "Password : " + new String(pasTxt.getPassword());
                statusLabel.setText(data);
            }

        });

        controlPanel.add(nameLabel);
        controlPanel.add(userTxt);

        controlPanel.add(paswdLabel);
        controlPanel.add(pasTxt);
        controlPanel.add(showBtn);
        mainFrame.setVisible(true);
    }
}
