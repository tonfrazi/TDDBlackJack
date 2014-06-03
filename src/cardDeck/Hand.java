/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardDeck;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AXF3009
 */
public class Hand {
    private List<Card> cards = new ArrayList<>();
    
    public void addCard(Card card){
        cards.add(card);
    }

    public void draw(Deck deck, int number) {
        for(int i=0; i<number; i++){
            this.cards.add(deck.drawCard());
        }
    }

    public void fold() {
        cards.removeAll(cards);
    }
    
    public int size(){
        return cards.size();
    }
    
    public Hand(){
        cards = new ArrayList<>();
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
}
