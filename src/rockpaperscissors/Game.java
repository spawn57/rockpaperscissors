/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sunilpc
 */
public class Game {
    public enum SHAPE { rock, paper, scissors, unknown }    
    public enum RESULT { player1, player2, draw }
    public enum MODE { ComputerVsComputer, PlayerVsComputer, TwoPlayers, unknown }
    
    public static RESULT getWinner(SHAPE player1Shape, SHAPE player2Shape) {                
        Game.RESULT result = RESULT.draw;
        
        if (player1Shape == player2Shape) {
            result = RESULT.draw;
        } else if (player1Shape == SHAPE.rock) {
            if (player2Shape == SHAPE.scissors) {
                result = RESULT.player1;
            }
            if (player2Shape == SHAPE.paper) {
                result = RESULT.player2;
            }
        } else if (player1Shape == SHAPE.paper) {            
            if (player2Shape == SHAPE.rock) {
                result = RESULT.player1;
            }
            if (player2Shape == SHAPE.scissors) {
                result = RESULT.player2;
            }
        } else if (player1Shape == SHAPE.scissors) {
            if (player2Shape == SHAPE.paper) {
                result = RESULT.player1;
            }
            if (player2Shape == SHAPE.rock) {
                result = RESULT.player2;
            }
        }        
                       
        return result;
    }
    
    public static SHAPE parseShape(String input) {
        SHAPE result;
    
        switch (input) {
            case "r":
            case "R": result = SHAPE.rock;
                      break;
            case "p":
            case "P": result = SHAPE.paper;
                      break;
            case "s":
            case "S": result = SHAPE.scissors;
                      break;
            default:
               result = SHAPE.unknown;
        }
        return result;
    };
    
    public static SHAPE randomShape() {
        SHAPE result = SHAPE.unknown;
        Random rand = new Random();
        Integer randomNumber = rand.nextInt(3);
                
        switch (randomNumber) {
            case 0:
                result = SHAPE.rock;
                break;
            case 1:
                result = SHAPE.scissors;
                break;
            case 2:
                result = SHAPE.paper;
                break;                
        }
        
        return result;
    }
    
    public static MODE parseMode(String input) {
        MODE result = MODE.unknown;
        
        switch (input) {
            case "c":
            case "C": 
                result = MODE.ComputerVsComputer;
                break;
            case "p":
            case "P":
                result = MODE.PlayerVsComputer;
                break;
            case "2":
                result = MODE.TwoPlayers;
                break;
        }        
        
        return result;
    }
    
    public static void computerVsComputer() {
        Game.SHAPE computer1Shape = randomShape();  
        System.out.println("Computer 1 chooses shape:" + computer1Shape);
        
        Game.SHAPE computer2Shape = randomShape();  
        System.out.println("Computer 2 chooses shape:" + computer2Shape);
        
        Game.RESULT winner = Game.getWinner(computer1Shape, computer2Shape);          
        if (winner == Game.RESULT.player1) {
            System.out.println("The winner is Computer 1");
        } else if (winner == Game.RESULT.player2) {
            System.out.println("The winner is Computer 2");
        } else {
            System.out.println("Draw game, try again");
        }
    }
    
    public static void playerVsComputer() {
        Game.SHAPE player1Shape;                
        Scanner scanner = new Scanner(System.in);                
                        
        do {
            System.out.println("Player 1: Enter your move (R)ock, (P)aper, (S)cissors)");
            String player1Input = scanner.nextLine();
            player1Shape = Game.parseShape(player1Input);
        } while (player1Shape == Game.SHAPE.unknown);
        
        Game.SHAPE computerShape = randomShape();  
        System.out.println("Computer chooses shape:" + computerShape);
        
        Game.RESULT winner = Game.getWinner(player1Shape, computerShape);          
        if (winner == Game.RESULT.player1) {
            System.out.println("The winner is Player 1");
        } else if (winner == Game.RESULT.player2) {
            System.out.println("The winner is Computer");
        } else {
            System.out.println("Draw game, try again");
        }
    }
    
    public static void twoPlayers() {
        
        Game.SHAPE player1Shape;
        Game.SHAPE player2Shape;  
        
        Scanner scanner = new Scanner(System.in);                
                        
        do {
            System.out.println("Player 1: Enter your move (R)ock, (P)aper, (S)cissors)");
            String player1Input = scanner.nextLine();
            player1Shape = Game.parseShape(player1Input);
        } while (player1Shape == Game.SHAPE.unknown);
                
        do {
            System.out.println("Player 2: Enter your move (R)ock, (P)aper, (S)cissors)");
            String player2Input = scanner.nextLine();
            player2Shape = Game.parseShape(player2Input);            
        } while (player2Shape == Game.SHAPE.unknown);
        
        Game.RESULT winner = Game.getWinner(player1Shape, player2Shape);          
        if (winner == Game.RESULT.player1) {
            System.out.println("The winner is Player 1");
        } else if (winner == Game.RESULT.player2) {
            System.out.println("The winner is Player 2");
        } else {
            System.out.println("Draw game, try again");
        }
    }
}