/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackTest;

import blackjack.Game;
import blackjack.Player;
import cardDeck.Card;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author AXF3009
 */
public class BlackjackTest extends TestCase{
    
    public void testDeal() throws Exception{
        Game testGame = new Game();
        testGame.deal();
        assertEquals(2, testGame.getPlayer().getHand().size());
        assertEquals(2, testGame.getDealer().getHand().size());
    }
    
    public void testScoreSimple(){
        Game testGame = new Game();
        Player  testPlayer = new Player(testGame);
        List<Card> testCards = new ArrayList<>();
        for(int i=1; i<10; i++){
            Card testCard = new Card();
            testCard.setValue(i);
            testCards.add(testCard);
        }
        testPlayer.getHand().setCards(testCards);
        assertEquals(54, testPlayer.score());
    }
    
    public void testScoreFaceCard(){
        Game testGame = new Game();
        Player  testPlayer = new Player(testGame);
        List<Card> testCards = new ArrayList<>();
        for(int i=10; i<13; i++){
            Card testCard = new Card();
            testCard.setValue(i);
            testCards.add(testCard);
        }
        testPlayer.getHand().setCards(testCards);
        assertEquals(30, testPlayer.score());
    }
    
    public void testScoreAce(){
        Game testGame = new Game();
        Player  testPlayer = new Player(testGame);
        List<Card> testCards = new ArrayList<>();
        Card testCard = new Card();
        Card ace = new Card();
        testCard.setValue(10);
        ace.setValue(0);
        testCards.add(testCard);
        testCards.add(ace);
        testPlayer.getHand().setCards(testCards);
        assertEquals(21, testPlayer.score());
        testCards.add(testCard);
        assertEquals(21, testPlayer.score());
    }
    
    public void testHit() throws Exception{
        Game testGame = new Game();
        testGame.playerHit();
        assertEquals(1, testGame.getPlayer().getHand().size());
    }
    
    public void testFold() throws Exception{
        Game testGame = new Game();
        testGame.playerHit();
        testGame.playerHit();
        testGame.getPlayer().fold();
        assertEquals(0, testGame.getPlayer().getHand().size());
    }
    
    public void testBust() throws Exception{
        Game testGame = new Game();
        testGame.setPlayerCash(5);
        testGame.setBet(5);
        Player  testPlayer = testGame.getPlayer();
        List<Card> testCards = new ArrayList<>();
        Card seven = new Card();
        seven.setValue(6);
        testCards.add(seven);
        Card four = new Card();
        four.setValue(3);
        testCards.add(four);
        Card ten = new Card();
        ten.setValue(9);
        testCards.add(ten);
        testPlayer.getHand().setCards(testCards);
        assertEquals(21, testPlayer.score());
        testGame.playerHit();
        assertEquals(0, (int)testGame.getPlayerCash());
    }
    
    public void testCompareScore() throws Exception{
        Game testGame = new Game();
        testGame.setBet(5);
        testGame.setPlayerScore(20);
        testGame.setDealerScore(19);
        testGame.compareScore();
        assertEquals(5, (int)testGame.getPlayerCash());
        testGame.setPlayerScore(19);
        testGame.setDealerScore(20);
        testGame.compareScore();
        assertEquals(0, (int)testGame.getPlayerCash());
    }
    
    public void testInstantWin() throws Exception{
        Game testGame = new Game();
        testGame.setBet(10);
        while(true){
            testGame.deal();
            if(testGame.getPlayerScore() == 21){
                break;
            }
            testGame.getPlayer().fold();
            testGame.getDealer().fold();
        }
        assertEquals(15, (int)testGame.getPlayerCash());
    }
    
    public void testDealerLogic() throws Exception{
        Game testGame = new Game();
        testGame.deal();
        testGame.setDealerScore(0);
        testGame.dealerTurn();
        assertTrue(16 < testGame.getDealerScore());
        testGame.setDealerScore(17);
        testGame.dealerTurn();
        assertEquals(17, testGame.getDealerScore());
    }
}
