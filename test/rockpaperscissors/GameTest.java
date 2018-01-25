/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sunilpc
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   
    @Test
    public void testDraw() {                
        Game.RESULT result1 = Game.getWinner(Game.SHAPE.rock, Game.SHAPE.rock);
        assertEquals(result1, Game.RESULT.draw);
        Game.RESULT result2 = Game.getWinner(Game.SHAPE.paper, Game.SHAPE.paper);
        assertEquals(result2, Game.RESULT.draw);
        Game.RESULT result3 = Game.getWinner(Game.SHAPE.scissors, Game.SHAPE.scissors);
        assertEquals(result3, Game.RESULT.draw);
    }
    
    @Test
    public void testRockBeatsScissors() {
        Game.RESULT result1 = Game.getWinner(Game.SHAPE.rock, Game.SHAPE.scissors);
        assertEquals(result1, Game.RESULT.player1);
        Game.RESULT result2 = Game.getWinner(Game.SHAPE.scissors, Game.SHAPE.rock);
        assertEquals(result2, Game.RESULT.player2);
    }
    
    @Test
    public void testPaperBeatsRock() {
        Game.RESULT result1 = Game.getWinner(Game.SHAPE.paper, Game.SHAPE.rock);
        assertEquals(result1, Game.RESULT.player1);
        Game.RESULT result2 = Game.getWinner(Game.SHAPE.rock, Game.SHAPE.paper);
        assertEquals(result2, Game.RESULT.player2);
    }
    
    @Test
    public void testScissorsBeatsPaper() {
        Game.RESULT result1 = Game.getWinner(Game.SHAPE.scissors, Game.SHAPE.paper);
        assertEquals(result1, Game.RESULT.player1);
        Game.RESULT result2 = Game.getWinner(Game.SHAPE.paper, Game.SHAPE.scissors);
        assertEquals(result2, Game.RESULT.player2);
    }
    
    public void testParseShapeLowerCaseRock() {
        Game.SHAPE shape = Game.parseShape("r");
        assertEquals(shape, Game.SHAPE.rock);        
    }
    
    public void testParseShapeUpperCaseRock() {
        Game.SHAPE shape = Game.parseShape("R");
        assertEquals(shape, Game.SHAPE.rock);        
    }
    
    public void testParseShapeLowerCasePaper() {
        Game.SHAPE shape = Game.parseShape("p");
        assertEquals(shape, Game.SHAPE.paper);
    }
    
    public void testParseShapeUpperCasePaper() {
        Game.SHAPE shape = Game.parseShape("P");
        assertEquals(shape, Game.SHAPE.paper);        
    }
    
    public void testParseShapeLowerCaseScissors() {        
        Game.SHAPE shape = Game.parseShape("s");
        assertEquals(shape, Game.SHAPE.scissors);        
    }
    
    public void testParseShapeUpperCaseStone() {        
        Game.SHAPE shape = Game.parseShape("S");
        assertEquals(shape, Game.SHAPE.scissors);
    }
        
    public void testParseShapeNumber() {
        Game.SHAPE shape = Game.parseShape("1");        
        assertEquals(shape, Game.SHAPE.unknown);
    }
    
    @Test
    public void testParseShapeOtherLowerCaseChar() {        
        Game.SHAPE shape = Game.parseShape("a");        
        assertEquals(shape, Game.SHAPE.unknown);
    }
    
    @Test
    public void testParseShapeOtherUpperCaseChar() {
        Game.SHAPE shape = Game.parseShape("Z");
        assertEquals(shape, Game.SHAPE.unknown);
    }        
    
    @Test
    public void testParseShapeOtherSymbols() {
        Game.SHAPE shape = Game.parseShape("!");
        assertEquals(shape, Game.SHAPE.unknown);
    }
    
    @Test
    public void testParseShapeMultipleChars() {
        Game.SHAPE shape = Game.parseShape("AAD*@(@#lAA");
        assertEquals(shape, Game.SHAPE.unknown);
    }
    
    @Test
    public void testRandomShape() {
        for (Integer i=0; i< 50; i++) {
            Game.SHAPE shape = Game.randomShape();        
            assertTrue((shape == Game.SHAPE.scissors) || (shape == Game.SHAPE.rock) || (shape == Game.SHAPE.paper));        
        }
    }
    
    @Test
    public void testParseModeUpperCaseC() {
        Game.MODE mode = Game.parseMode("C");
        assertEquals(mode, Game.MODE.ComputerVsComputer);
    }
    
    @Test
    public void testParseModeLowerCaseC() {
        Game.MODE mode = Game.parseMode("c");
        assertEquals(mode, Game.MODE.ComputerVsComputer);
    }
    
    @Test
    public void testParseModeUpperCaseP() {
        Game.MODE mode = Game.parseMode("P");
        assertEquals(mode, Game.MODE.PlayerVsComputer);
    }
    
    @Test
    public void testParseModeLowerCaseP() {
        Game.MODE mode = Game.parseMode("p");
        assertEquals(mode, Game.MODE.PlayerVsComputer);
    }
    
    @Test
    public void testParseModeUpperCase2() {
        Game.MODE mode = Game.parseMode("2");
        assertEquals(mode, Game.MODE.TwoPlayers);
    }        
    
    @Test
    public void testParseModeOther() {
        Game.MODE mode = Game.parseMode("@");
        assertEquals(mode, Game.MODE.unknown);
    }        
}
