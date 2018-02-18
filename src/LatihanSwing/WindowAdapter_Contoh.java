package LatihanSwing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowAdapter_Contoh {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public WindowAdapter_Contoh() {
        prepareGUI();
    }

    public static void main(String[] args) {
        WindowAdapter_Contoh swingAdapterDemo = new WindowAdapter_Contoh();
        swingAdapterDemo.showWindowAdapterDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
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

    private void showWindowAdapterDemo() {
        headerLabel.setText("Listener in action: WindowAdapter");
        JButton okButton = new JButton("OK");
        final JFrame aboutFrame = new JFrame();
        aboutFrame.setSize(300, 200);;
        aboutFrame.setTitle("WindowAdapter Demo");

        aboutFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                aboutFrame.dispose();
            }
        });
        JLabel msgLabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
        aboutFrame.add(msgLabel);
        aboutFrame.setVisible(true);
    }
}
