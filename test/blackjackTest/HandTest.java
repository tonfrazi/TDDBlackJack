/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackTest;

import cardDeck.Deck;
import cardDeck.Hand;
import junit.framework.TestCase;

/**
 *
 * @author AXF3009
 */
public class HandTest extends TestCase{
    
    public void testDraw() throws Exception{
        Deck testDeck = new Deck();
        Hand testHand = new Hand();
        int handBefore = testHand.size();
        testHand.draw(testDeck, 1);
        int handAfter = testHand.size();
        assertEquals(handAfter, handBefore + 1);
    }
    
    public void testFold() throws Exception{
        Deck testDeck = new Deck();
        Hand testHand = new Hand();
        testHand.draw(testDeck, 5);
        testHand.fold();
        assertEquals(0, testHand.size());
    }
}
