package com.company;
import javax.swing.JFrame;

    public class GameFrame extends JFrame {

        public @Override void toFront() {
            int sta = super.getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;

            super.setExtendedState(sta);
            super.setAlwaysOnTop(true);
            super.toFront();
            super.requestFocus();
            super.setAlwaysOnTop(false);
        }
        GameFrame() {
            GamePanel panel = new GamePanel();  //declare a new panel
            this.add(panel); //adding the panel we declared to our container
            this.setTitle("Snake Game"); //giving title to our game Panel
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this give the functionality to the close button that appears on our frame to close it on click
            this.setVisible(true); //sets visibility of our panel
            this.toFront();
            this.requestFocus();
            this.repaint();
            setVisible(true);
            toFront();
            requestFocus();
            repaint();
            this.setResizable(false); //we set this resizable function to false that will resist to make our panel resizable as we cannot just resize our panel by dragging it with mouse
            this.pack(); //pack our every components and layouts in minimum space
            this.setLocationRelativeTo(null); //sets the location of our panel on window

        }



    }