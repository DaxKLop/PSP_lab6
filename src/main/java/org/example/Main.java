package org.example;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener {
    private JButton startButton;
    private JButton stopButton;
    private AnimationPanel animationPanel;
    private Thread houseThread;
    private Thread lightThread;
    private Thread smokeThread;
    private Thread backThread;

    public Main() {
        this.setTitle("lab6");
        this.setDefaultCloseOperation(3);
        this.setSize(600, 400);
        this.startButton = new JButton("Старт");
        this.stopButton = new JButton("Стоп");
        this.startButton.addActionListener(this);
        this.stopButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(this.startButton);
        buttonPanel.add(this.stopButton);
        this.animationPanel = new AnimationPanel();
        Container container = this.getContentPane();
        container.add(this.animationPanel, "Center");
        container.add(buttonPanel, "South");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.startButton) {
            this.houseThread = new Thread(this.animationPanel.getHouse());
            this.lightThread = new Thread(this.animationPanel.getLight());
            this.smokeThread = new Thread(this.animationPanel.getSmoke());
            this.houseThread.start();
            this.lightThread.start();
            this.smokeThread.start();
        } else if (e.getSource() == this.stopButton) {
            this.animationPanel.stopAnimation();
            this.animationPanel.getSmoke().setHeight(0);
            this.animationPanel.repaint();
            this.animationPanel.getLight().setHeight(0);
            this.animationPanel.repaint();
            this.houseThread.interrupt();
            this.lightThread.interrupt();
            this.smokeThread.interrupt();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main app = new Main();
                app.setVisible(true);
            }
        });
    }
}
