/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import snakes.ladders.controller.Controller;
import snakes.ladders.model.Player;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class BoardView extends JPanel{
    
    private final Controller controller;
    
    /**
     * Constructor for board panel.
     * @param controller controller currently in use to get information from.
     */
    public BoardView(Controller controller) {
        this.controller = controller;
        
        // panel settings
        this.setLayout(new GridLayout(10, 10));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        ArrayList<int[]> board = this.controller.getBoard();
        
        // loops through array of Place to set information accordingly
        Place[] places = new Place[this.controller.getBoardSize()];
        for (int i = 0; i < places.length; i++) {
            places[i] = new Place(i, board.get(i), this.controller);
        }
        
        // inverted loop to place the Place JPanels on the right order onto the map
        for (int i = 9; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 0; j < 10; j++) {
                    this.add(places[j + (i * 10)]);
                }
            } else {
                for (int j = 9; j >= 0; j--) {
                    this.add(places[j + (i * 10)]);
                }
            }
        }
        
    }
    
    class Place extends JPanel{
        
        private int num;
        private int type;
        private int redirect;
        private Color colour;
        
        /**
         * Constructor for Place.
         * @param num number of place.
         * @param placePosition 
         * placePosition[0]: type of place 
         * -1: snake; 0: normal; 1: ladder
         * placePosition[1]: position to redirect player to
         * @param controller 
         */
        public Place (int num, int[] placePosition, Controller controller) {
            this.num = num;
            this.type = placePosition[0];
            this.redirect = placePosition[1];
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            
            this.setLayout(new BorderLayout());
            this.add(new JLabel("" + (this.num + 1)), BorderLayout.NORTH); // place number to be displayed
            String t = "normal place";
            switch (this.type) {
                case 1:
                    this.colour = Color.BLUE;
                    t = "ladder";
                    break;
                case -1:
                    this.colour = Color.RED;
                    t = "snake";
                    break;
                default:
                    this.colour = Color.WHITE;
                    break;
            }
            
            
            JPanel playerPanel = new JPanel();
            boolean containsPlayer = false;
            // loops through players and displays them on the place if they are currently on it
            for (Player p : controller.getPlayers()) {
                if (p.getPosition() == this.num || (this.num == 99 && p.getPosition() >= this.num)) {
                    containsPlayer = true;
                    playerPanel.setBackground(Color.GRAY);
                    JLabel currPlayer = new JLabel("" + p.getPlayerNumber());
                    currPlayer.setBackground(Color.GRAY);
                    currPlayer.setForeground(p.getColour());
                    playerPanel.add(currPlayer);
                    
                    // if player lands on a snake or a ladder, a message is displayed to alert the players
                    if (this.type == 1 || this.type == -1) {
                        p.setPosition(this.redirect);
                        JOptionPane.showMessageDialog(null, "Player " + p.getPlayerNumber() + " walked into a " + t + ".\r\n" + 
                                "They went from " + (this.num + 1) + " to " + (this.redirect + 1) + ".", t.toUpperCase(), JOptionPane.INFORMATION_MESSAGE);
                        controller.updateFrame();
                    }
                }
            }
            
            if (containsPlayer) {
                this.add(playerPanel, BorderLayout.EAST);
            }
            
            // shows where players will be redirected if they land on this place if it's a snake or a ladder
            if (this.redirect != this.num) {
                this.add(new JLabel("Goes to " + (this.redirect + 1)), BorderLayout.SOUTH);
                View.standardPanel(this);
            }
            
            this.setBackground(this.colour);
        }
        
    }
    
}
