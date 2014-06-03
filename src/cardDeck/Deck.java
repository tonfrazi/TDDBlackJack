/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AXF3009
 */
public class Deck {
    private List<Card> cards;
    
    public Deck(){
        cards = new ArrayList<>();
        setUpDefaultPlayingCards();
    }
    
    /**
     * @return the cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    private void setUpDefaultPlayingCards() {
        String [] labels = {" A"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10"," J"," Q"," K"};
        setupSuit(Suit.HEARTS, labels);
        setupSuit(Suit.SPADES, labels);
        setupSuit(Suit.DIAMONDS, labels);
        setupSuit(Suit.CLUBS, labels);
    }
    
    private void setupSuit(Suit suit, String [] labels){
        for (int i=0; i<labels.length; i++) {
            Card tempCard = new Card();
            tempCard.setSuit(suit);
            tempCard.setValue(i);
            tempCard.setLabel(labels[i]);
            this.cards.add(tempCard);
        }
    }    
    public Card drawCard() {
        Card card;
        Random random = new Random();
        int index = random.nextInt(getCards().size());
        card = getCards().get(index);
        this.cards.remove(index);
        return card;
    }
}
