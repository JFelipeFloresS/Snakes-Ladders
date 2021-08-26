/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import snakes.ladders.model.Board;
import snakes.ladders.model.Model;
import snakes.ladders.model.Player;
import snakes.ladders.view.View;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class Controller implements ActionListener{
    
    // instantiate variables
    private Model model;
    private final Board board;
    private final View view;
    
    /**
     * Controller constructor.
     * @param numberOfPlayers number of players that will be playing the game.
     */
    public Controller(int numberOfPlayers) {
        this.model = new Model(numberOfPlayers);
        this.board = new Board();
        this.view = new View(this);
    }
    
    public ArrayList<int[]> getBoard() {
        return this.board.getBoard();
    }
    
    public int getBoardSize() {
        return this.board.getBoardSize();
    }
    
    public Player[] getPlayers() {
        return this.model.getPlayers();
    }
    
    public int getRound() {
        return this.model.getRound();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "roll dice":
                rollDice();
                break;
            default:
                System.out.println(e.getActionCommand());
                break;
        }
    }
    
    /**
     * Rolls dice for current player and checks for victory.
     */
    public void rollDice() {
        this.model.rollDice();
        this.view.updateFrame();
        if (this.model.checkVictory(getBoardSize()) != -1) {
            int response = JOptionPane.showConfirmDialog(this.view, "PLAYER " + this.model.checkVictory(getBoardSize()) + " WON THE GAME!\r\nPlay again?", "VICTORY", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                this.resetGame();
            } else {
                System.exit(0);
            }
        }
    }
    
    public int getRolled() {
        return this.model.getRolled();
    }
    
    public void updateFrame() {
        this.view.updateFrame();
    }
    
    /**
     * Resets the game by checking number of players that will be playing the game and starting a new model.
     */
    public void resetGame() {
        String[] nums = {"2", "3", "4"};
        String num = (String) JOptionPane.showInputDialog(null, "Enter number of players for this round.", "Number of players", JOptionPane.QUESTION_MESSAGE, null, nums, nums[0]);
        this.model = new Model(Integer.valueOf(num));
        updateFrame();
    }
}
