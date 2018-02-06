package LatihanSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileChoserContoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public FileChoserContoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        FileChoserContoh swingControlDemo = new FileChoserContoh();
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
        java.net.URL imgURL = FileChoserContoh.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void showListDemo() {
        headerLabel.setText("Control in action: JFileChoser");
        final JFileChooser fileDialog=  new JFileChooser();
        ImageIcon icon = new ImageIcon("src/gambar/windows_16.png");
        JButton showFileDialogBtn = new JButton("Open Fiel",icon);
        
        showFileDialogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nilaiVar = fileDialog.showOpenDialog(mainFrame);
                if (nilaiVar == JFileChooser.APPROVE_OPTION) {
                    java.io.File file =fileDialog.getSelectedFile();
                    statusLabel.setText(file.getName());
                } else {
                    statusLabel.setText("Canceled By User");
                }
            }
        });

        

        controlPanel.add(showFileDialogBtn);
     
        mainFrame.setVisible(true);
    }
}
