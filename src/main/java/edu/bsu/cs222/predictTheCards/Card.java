package edu.bsu.cs222.predictTheCards;


import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {

    enum Suit {
        HEARTS(), DIAMONDS(), CLUBS(), SPADES()
        }

    enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        final int value;

        Rank(int value) {
            this.value = value;
        }
    }

    public Suit suit;
    public Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        //Generating a card is different from the idea of a card
        Rectangle bg = new Rectangle(80, 100);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(Color.WHITE);
        Text text = new Text(toString());
        text.setWrappingWidth(70);
        getChildren().add(new StackPane(bg, text));

    }


    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

}

