package org.example;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class AnimationPanel extends JPanel {
    private House house;
    private Light light;
    private Smoke smoke;
    private boolean isAnimationRunning;

    public AnimationPanel() {
        this.setPreferredSize(new Dimension(600, 300));
        this.setBackground(Color.WHITE);
        this.house = new House();
        this.light = new Light();
        this.smoke = new Smoke();
        this.isAnimationRunning = false;
    }

    public House getHouse() {
        return this.house;
    }

    public Light getLight() {
        return this.light;
    }

    public Smoke getSmoke() {
        return this.smoke;
    }

    public void stopAnimation() {
        this.isAnimationRunning = false;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.house.draw(g);
        this.light.draw(g);
        this.smoke.draw(g);
    }

    class House implements Runnable {
        private int x = 0;
        private int y = 0;
        private Image houseImage;

        public House() {
            try {
                this.houseImage = ImageIO.read(new File("D:/java_lab/java/lab_6/house.png"));
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }

        public void run() {
            AnimationPanel.this.isAnimationRunning = true;

            while(AnimationPanel.this.isAnimationRunning) {
                this.y += 20;
                if (this.y > AnimationPanel.this.getWidth()) {
                    this.y = -100;
                }

                AnimationPanel.this.repaint();

                try {
                    Thread.sleep(50L);
                } catch (InterruptedException var2) {
                    return;
                }
            }

        }

        public void draw(Graphics g) {
            g.drawImage(this.houseImage, 100, 20, 250, 250, (ImageObserver)null);
        }
    }

    class Light implements Runnable {
        private int height = 0;
        private Image lightImage;

        public Light() {
            try {
                this.lightImage = ImageIO.read(new File("D:/java_lab/java/lab_6/light.png"));
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void run() {
            AnimationPanel.this.isAnimationRunning = true;

            while(AnimationPanel.this.isAnimationRunning) {
                this.height = 0;
                if (this.height < 50) {
                    this.height = 50;
                }

                AnimationPanel.this.repaint();

                try {
                    Thread.sleep(200L);
                } catch (InterruptedException var2) {
                    return;
                }
            }

        }

        public void draw(Graphics g) {
            g.drawImage(this.lightImage, 165, 240, 100, this.height - this.height * 2, (ImageObserver)null);
        }
    }

    class Smoke implements Runnable {
        private int height = 0;
        private Image smokeImage;

        public Smoke() {
            try {
                this.smokeImage = ImageIO.read(new File("D:/java_lab/java/lab_6/smoke.png"));
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void run() {
            AnimationPanel.this.isAnimationRunning = true;

            while(AnimationPanel.this.isAnimationRunning) {
                this.height += 3;
                if (this.height > 100) {
                    this.height = 50;
                }

                AnimationPanel.this.repaint();

                try {
                    Thread.sleep(200L);
                } catch (InterruptedException var2) {
                    return;
                }
            }

        }

        public void draw(Graphics g) {
            g.drawImage(this.smokeImage, 215, 120, 50, this.height - this.height * 2, (ImageObserver)null);
        }
    }
}
