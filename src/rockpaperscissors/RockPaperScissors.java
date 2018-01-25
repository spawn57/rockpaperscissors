/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author sunilpc
 */
public class RockPaperScissors {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        Game.MODE mode = Game.MODE.unknown;
        System.out.println("rock paper scissors");                
            
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("(C)omputer vs. Computer, (P)layer vs. Computer, (2) Players");
            String modeInput = scanner.nextLine();
            mode = Game.parseMode(modeInput);
        } while (mode == Game.MODE.unknown);
        
        switch (mode) {
            case ComputerVsComputer:
                Game.computerVsComputer();
                break;
            case PlayerVsComputer:
                Game.playerVsComputer();
                break;
            case TwoPlayers:
                Game.twoPlayers();
                break;                
        }                        
    }            
}
