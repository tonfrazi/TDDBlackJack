/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackjack;

import cardDeck.Deck;

/**
 *
 * @author AXF3009
 */
public class Game {
    private Player dealer = new Player(this);
    private Player player = new Player(this);
    private int dealerScore = 0;
    private int playerScore = 0;
    private float bet = 0;
    private float playerCash = 0;
    private Deck deck = new Deck();

    public void deal() {
        if(deck.getCards().isEmpty()){
            deck = new Deck();
        }
        player.hit();
        setPlayerScore(player.hit());
        if(getPlayerScore() == 21){
            instantWin();
        }
        dealer.hit();
        setDealerScore(dealer.hit());
    }
    
    public void playerHit(){
        setPlayerScore(player.hit());
        if(playerScore > 21){
            lose();
        }
    }
    
    public void dealerHit(){
        setDealerScore(dealer.hit());
        if(playerScore > 21){
            win();
        }
    }

    public void dealerTurn() {
        while(dealerScore < 17){
            dealerHit();
        }
    }

    public void win() {
        playerCash += bet;
    }

    public void instantWin() {
        playerCash += (bet*3)/2;
    }
    
    public void lose(){
        playerCash -= bet;
    }

    public void compareScore() {
        if(playerScore > dealerScore){
            win();
        }
        else{
            lose();
        }
    }

    /**
     * @return the dealer
     */
    public Player getDealer() {
        return dealer;
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * @return the dealerScore
     */
    public int getDealerScore() {
        return dealerScore;
    }

    /**
     * @param dealerScore the dealerScore to set
     */
    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    private void playerWin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the bet
     */
    public float getBet() {
        return bet;
    }

    /**
     * @param bet the bet to set
     */
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * @return the playerCash
     */
    public float getPlayerCash() {
        return playerCash;
    }

    /**
     * @param cash the playerCash to set
     */
    public void setPlayerCash(float playerCash) {
        this.playerCash = playerCash;
    }
}
