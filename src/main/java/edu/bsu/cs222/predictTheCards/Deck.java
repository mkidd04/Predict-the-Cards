package edu.bsu.cs222.predictTheCards;

import edu.bsu.cs222.predictTheCards.Card.Rank;
import edu.bsu.cs222.predictTheCards.Card.Suit;

public class Deck {
    //Linked list?
    //Stack? Queue?
    private Card[] cards = new Card[52];

    public Deck() {
        refill();
    }

    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    public Card drawCard() {
        Card card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}
