/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.ladders;

import javax.swing.JOptionPane;
import snakes.ladders.controller.Controller;

/**
 *
 * @author José Felipe Flores da Silva
 */
public class SnakesLadders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // pop-up to check number of players
        String[] nums = {"2", "3", "4"};
        String num = (String) JOptionPane.showInputDialog(null, "Enter number of players for this round.", "Number of players", JOptionPane.QUESTION_MESSAGE, null, nums, nums[0]);
        
        // start controller
        new Controller(Integer.valueOf(num));
    }
    
}
