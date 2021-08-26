/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import snakes.ladders.controller.Controller;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class View extends JFrame{
    
    private final Controller controller;
    private final int[] windowSize;
    
    /**
     * Constructor for View.
     * @param controller 
     */
    public View(Controller controller) {
        this.windowSize = new int[2];
        this.windowSize[0] = 1200;
        this.windowSize[1] = 800;
        this.controller = controller;
        setUpWindow();
    }
    
    /**
     * Frame settings
     */
    public void setUpWindow(){ 
        this.setVisible(true);
        this.setSize(this.windowSize[0], this.windowSize[1]);
        this.setTitle("Snakes And Ladders");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        updateFrame();
    }
    
    /**
     * Removes all content of frame and adds a new BoardView and new SidePanel
     */
    public void updateFrame() {
        this.getContentPane().removeAll();
        this.add(new BoardView(this.controller), BorderLayout.CENTER);
        this.add(new SidePanel(this.controller, this.controller.getRolled()), BorderLayout.EAST);
        this.validate();
        this.repaint();
    }
    
    /**
     * Standardises a panel.
     * @param panel panel to be standardised.
     * @param controller controller to be used.
     */
    public static void standardPanel(JPanel panel, Controller controller) {
        Component[] components = panel.getComponents();
        panel.setBackground(Color.GRAY);
        
        for (Component c : components) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(controller);
            } else if (c instanceof JPanel) {
                standardPanel((JPanel) c, controller);
            }
        }
    }
    
    /**
     * Standardises a panel.
     * @param panel panel to be standardised.
     */
    public static void standardPanel(JPanel panel) {
        Component[] components = panel.getComponents();
        panel.setForeground(Color.WHITE);
        
        for (Component c : components) {
            if (c instanceof JLabel) {
                c.setForeground(Color.WHITE);
            }
        }
    }
    
}
