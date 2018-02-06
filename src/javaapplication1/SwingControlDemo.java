package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showRadioButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
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

    private void showRadioButtonDemo() {
        headerLabel.setText("Control in action: RadioButton");

        JRadioButton radApple = new JRadioButton("Apple", true);
        JRadioButton radMango = new JRadioButton("Mango");
        JRadioButton radPeer = new JRadioButton("Peer");

        radApple.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Apple radio Buton : " + (e.getStateChange() == 1 ? "cheked" : "uncheked"));
            }
        });

        radMango.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Mango radio Buton : " + (e.getStateChange() == 1 ? "cheked" : "uncheked"));
            }
        });

        radPeer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Peer radio Buton : " + (e.getStateChange() == 1 ? "cheked" : "uncheked"));
            }
        });
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();

        group.add(radApple);
        group.add(radMango);
        group.add(radPeer);

        controlPanel.add(radApple);
        controlPanel.add(radMango);
        controlPanel.add(radPeer);

        mainFrame.setVisible(true);

    }

}
