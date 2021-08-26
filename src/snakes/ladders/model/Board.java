/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class Board {
    /*
    places[0]:
    -1 snake
    0 neutral
    1 ladder
    
    places[1]:
    position to go
    */
    private final ArrayList<int[]> places;
    private final int boardSize;
    
    /*
    HashMap<From, To>
    */
    private final HashMap<Integer, Integer> snakes;
    private final HashMap<Integer, Integer> ladders;
    
    /**
     * Constructor for board.
     */
    public Board() {
        this.boardSize = 100;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.places = new ArrayList<>();
        setSnakesAndLadders();
        initiateBoard();
    }
    
    public int getBoardSize() {
        return this.boardSize;
    }
    
    public ArrayList<int[]> getBoard() {
        return this.places;
    }
    
    /**
     * Sets place of snakes and ladders on the board and where each one will redirect the player.
     */
    public void setSnakesAndLadders() {
        this.snakes.put(98, 41);
        this.snakes.put(95, 81);
        this.snakes.put(89, 53);
        this.snakes.put(76, 58);
        this.snakes.put(66, 45);
        this.snakes.put(54, 31);
        this.snakes.put(43, 18);
        this.snakes.put(40, 3);
        this.snakes.put(27, 5);
        this.snakes.put(36, 2);
        
        this.ladders.put(4, 25);
        this.ladders.put(8, 28);
        this.ladders.put(20, 39);
        this.ladders.put(13, 46);
        this.ladders.put(33, 49);
        this.ladders.put(42, 63);
        this.ladders.put(50, 69);
        this.ladders.put(62, 81);
        this.ladders.put(74, 92);
    }
    
    /**
     * Loops through board places and sets type and redirect place accordingly.
     */
    public void initiateBoard() {
        for (int i = 0; i <= this.boardSize; i++) {
            int[] currentPlace = new int[2];
            
            if (this.snakes.containsKey(i)) {
                currentPlace[0] = -1;
                currentPlace[1] = this.snakes.get(i);
            } else if (this.ladders.containsKey(i)) {
                currentPlace[0] = 1;
                currentPlace[1] = this.ladders.get(i);
            } else {
                currentPlace[0] = 0;
                currentPlace[1] = i;
            }
            this.places.add(currentPlace);
            
        }
    }
    
}
