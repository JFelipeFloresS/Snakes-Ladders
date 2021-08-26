/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.model;

import java.awt.Color;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class Player {
    private int position;
    private final Color colour;
    private final int playerNumber;
    
    /**
     * Constructor for player.
     * @param colour colour that will represent player on the board.
     * @param number player number
     */
    public Player(Color colour, int number) {
        this.position = 0;
        this.playerNumber = number;
        this.colour = colour;
    }

    public int getPosition() {
        return position;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Color getColour() {
        return colour;
    }

    /**
     * Sets player position.
     * @param position position to set player.
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
