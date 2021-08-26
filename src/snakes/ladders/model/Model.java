/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.model;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class Model {
    private final int totalPlayers;
    private final Player[] players;
    private int round;
    private int rolled;
    
    /**
     * Constructor for model.
     * @param numberOfPlayers number of players that will be playing the game.
     */
    public Model(int numberOfPlayers) {
        this.totalPlayers = numberOfPlayers;
        this.players = new Player[this.totalPlayers];
        this.round = 0;
        this.rolled = 0;
        setPlayers();
    }

    public int getRound() {
        return round;
    }
    
    /**
     * Adds to round and reset round to 0 after the last player's turn.
     */
    public void passRound() {
        this.round++;
        if (this.round >= this.totalPlayers) {
            this.round = 0;
        }
    }

    public int getRolled() {
        return rolled;
    }
    
    /**
     * Generates a random number from 1 to 6 and adds the result to the player's current position.
     */
    public void rollDice() {
        Random rd = new Random();
        this.rolled = 1 + rd.nextInt(6);
        this.players[this.round].setPosition(this.players[this.round].getPosition() + this.rolled);
        passRound();
    }

    public Player[] getPlayers() {
        return players;
    }
    
    /**
     * Sets players number and colour.
     */
    public void setPlayers() {
        Color[] colours = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
        for (int i = 0; i < this.totalPlayers; i++) {
            this.players[i] = new Player(colours[i], i + 1);
        }
    }

    /**
     * Checks if player's position is greater or equal than board size and therefore the winner.
     * @return winner player's number or -1 if there is no winner.
     */
    public int checkVictory(int boardSize) {
        for (Player p : this.players) {
            if (p.getPosition() >= boardSize - 1) {
                return p.getPlayerNumber();
            }
        }
        
        return -1;
    }
}
