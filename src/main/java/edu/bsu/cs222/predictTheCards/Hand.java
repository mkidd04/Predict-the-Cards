package edu.bsu.cs222.predictTheCards;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import javax.swing.*;



public class Hand {

    public ObservableList<Node> cards;
    private SimpleStringProperty color = new SimpleStringProperty("");


    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void takeCard(Card card, String btnColor) {
        cards.add(card);
        if (btnColor.equals("red")) {
            if(card.suit.toString().equals("DIAMONDS") || card.suit.toString().equals("HEARTS")){
                winGame();
            }else{
                loseGame();
            }

        }else {
            if (card.suit.toString().equals("SPADES") || card.suit.toString().equals("CLUBS")) {
                winGame();
            } else {
                loseGame();
            }

        }
    }

    public void winGame(){
        JOptionPane.showMessageDialog(null, "You WIN!");
    }

    public void loseGame(){
        JOptionPane.showMessageDialog(null, "You LOSE!");
    }



    public void reset() {
        cards.clear();
        color.set("");
    }

    public SimpleStringProperty valueProperty() {
        return color;
    }
}