/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import snakes.ladders.controller.Controller;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class SidePanel extends JPanel{
    
    private final Controller controller;
    private final int rolled;
    
    /**
     * Constructor for SidePanel.
     * @param controller
     * @param rolled last number rolled by the die.
     */
    public SidePanel(Controller controller, int rolled) {
        
        this.controller = controller;
        this.rolled = rolled;
        
        // SidePanel settings
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        setTopPanel();
        setCentralPanel();
        
        View.standardPanel(this, this.controller);
    }
    
    public void setTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new GridLayout(10, 1));
        JLabel titlePanel = new JLabel("Snakes and Ladders");
        titlePanel.setFont(new Font("Tahoma", Font.BOLD, 25));
        titlePanel.setForeground(Color.WHITE);
        topPanel.add(titlePanel);
        
        // displays current round's player
        JLabel roundLabel = new JLabel("Player " + this.controller.getPlayers()[this.controller.getRound()].getPlayerNumber() + " round.");
        roundLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        roundLabel.setForeground(this.controller.getPlayers()[this.controller.getRound()].getColour());
        topPanel.add(roundLabel);
        
        this.add(topPanel, BorderLayout.NORTH);
    }
    
    public void setCentralPanel() {
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new GridLayout(10, 1));
        
        JPanel dieRollPanel = new JPanel();
        // button to roll the die
        JButton rollDice = new JButton("ROLL DICE");
        rollDice.setActionCommand("roll dice");
        rollDice.setFont(new Font("Tahoma", Font.BOLD, 25));
        rollDice.setBackground(this.controller.getPlayers()[this.controller.getRound()].getColour());
        rollDice.setForeground(Color.BLACK);
        rollDice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        dieRollPanel.add(rollDice);
        
        dicePanel.add(dieRollPanel);
        
        // display last number rolled
        if (this.rolled != 0) {
            JLabel numberRolled = new JLabel("" + this.rolled);
            numberRolled.setFont(new Font("Tahoma", Font.BOLD, 30));
            numberRolled.setForeground(Color.BLACK);
            numberRolled.setHorizontalAlignment(SwingConstants.CENTER);
            dicePanel.add(numberRolled);
        }
        
        this.add(dicePanel, BorderLayout.CENTER);
    }
}
