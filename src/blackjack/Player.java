/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

import cardDeck.Card;
import cardDeck.Deck;
import cardDeck.Hand;

/**
 *
 * @author AXF3009
 */
public class Player {
    private Hand hand = new Hand();;
    private Game game;
    
    public Player(Game game){
        this.game = game;
    }

    public int hit() {
        if(game.getDeck().getCards().isEmpty()){
            game.setDeck(new Deck());
        }
        hand.addCard(game.getDeck().drawCard());
        return score();
    }

    public void fold() {
        hand.getCards().removeAll(hand.getCards());
    }

    public int score() {
        int score = 0;
        int numAces = 0;
        for(Card card: hand.getCards()){
            int value = card.getValue();
            if(value == 0){
                score += 11;
                numAces ++;
            }
            else if(value>9){
                score += 10;
            }
            else{
                score += value + 1;
            }
        }
        if(score>21){
            for(int i=0; i<numAces; i++){
                score -= 10;
            }
        }
        return score;
    }
    
    /**
     * @return the hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
