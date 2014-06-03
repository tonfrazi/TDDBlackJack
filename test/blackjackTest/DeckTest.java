/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjackTest;

import cardDeck.Card;
import cardDeck.Deck;
import cardDeck.Suit;
import junit.framework.TestCase;

/**
 *
 * @author AXF3009
 */
public class DeckTest extends TestCase{
    
    public void testDefaultDeckContent() throws Exception{
        Deck testDeck = new Deck();
        assertEquals(52, testDeck.getCards().size());
        int [] checkValues = new int [13];
        int [] checkSuits = new int [4];
        for(int i=0; i<52; i++){
            Card testCard = testDeck.drawCard();
            int value = testCard.getValue();
            checkValues[value]++;
            Suit suit = testCard.getSuit();
            if(suit != null){
                switch(suit){
                    case HEARTS: checkSuits[0]++;
                        break;
                    case SPADES: checkSuits[1]++;
                        break;
                    case DIAMONDS: checkSuits[2]++;
                        break;
                    case CLUBS: checkSuits[3]++;
                        break;
                }
            }
            
        }
        for(int i=0; i<checkValues.length; i++){
            assertEquals(4, checkValues[i]);
        }
        for(int i=0; i<checkSuits.length; i++){
            assertEquals(13, checkSuits[i]);
        }
    }
    
    public void testDraw() throws Exception{
        Deck testDeck = new Deck();
        int deckBefore = testDeck.getCards().size();
        testDeck.drawCard();
        int deckAfter = testDeck.getCards().size();
        assertEquals(deckAfter, deckBefore - 1);
    }
}
