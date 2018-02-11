package LatihanSwing;

import java.awt.*;
import java.awt.event.*;
import javafx.concurrent.Task;
import javax.swing.*;

public class ProgresbarContoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ProgresbarContoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ProgresbarContoh swingControlDemo = new ProgresbarContoh();
        swingControlDemo.showProgresBar();
    }

    /*adad
    asadad
    adadadsfds fsdsfds
    sfdsfdsfdsf fdsfdsfds*/

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

    private static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = ProgresbarContoh.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    private JProgressBar progressBar;
    private Task task;
    private JButton startButton;
    private JTextArea outputTextArea;

    private void showProgresBar() {
        headerLabel.setText("Control in action Progres Bar");
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);

        startButton = new JButton("Start");
        outputTextArea = new JTextArea(" ", 5, 18);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();
            }
        });
        controlPanel.add(startButton);
        controlPanel.add(progressBar);
        controlPanel.add(scrollPane);
        mainFrame.setVisible(true);
    }

    private class Task extends Thread {

        public Task() {

        }

        public void run() {
            for (int i = 0; i <= 100; i++) {
                final int progres = i;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setValue(progres);
                        outputTextArea.setText(outputTextArea.getText() + String.format("Complete Task %d%% of task \n", progres));
                    }
                });
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

            }
        }
    }

}
