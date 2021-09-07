package edu.bsu.cs222.predictTheCards;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Game extends Application{

    private Deck deck = new Deck();
    private Hand player;
    private Text message = new Text();


    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox playerCards = new HBox(20);

    private Parent setBoard() {
        //Generates players hand by reading HBox contents
        //!
        player = new Hand(playerCards.getChildren());
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        Region background = new Region();
        background.setPrefSize(800, 600);
        background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");

        //Main Menu
        HBox rootLayout = new HBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle leftBG = new Rectangle(550, 560);
        leftBG.setArcWidth(50);
        leftBG.setArcHeight(50);
        leftBG.setFill(Color.DIMGREY);
        Rectangle rightBG = new Rectangle(230, 560);
        rightBG.setArcWidth(50);
        rightBG.setArcHeight(50);
        rightBG.setFill(Color.DARKRED);

        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text playerScore = new Text("");
        Text suitColor = new Text(" DIAMONDS/HEARTS = Red || SPADES/CLUBS = Black");

        leftVBox.getChildren().addAll( message, playerCards,suitColor);
        VBox rightVBox = new VBox(20);
        rightVBox.setAlignment(Pos.CENTER);

        //Making buttons
        Button btnPlay = new Button("PLAY");
        Button btnRed = new Button("Red");
        Button btnBlack = new Button("Black");
        Button btnExit = new Button("Exit");

        //Making button HBox
        HBox buttonsHBox = new HBox(15, btnRed, btnBlack);
        HBox btnExitHBox = new HBox(1, btnExit);
        buttonsHBox.setAlignment(Pos.CENTER);
        btnExitHBox.setAlignment(Pos.CENTER_LEFT);

        rightVBox.getChildren().addAll(btnPlay, buttonsHBox, btnExitHBox);
        rootLayout.getChildren().addAll(new StackPane(leftBG, leftVBox), new StackPane(rightBG, rightVBox));
        root.getChildren().addAll(background, rootLayout);

        //Only allow players to use red/black button once play button has been pressed
        btnPlay.disableProperty().bind(playable);
        btnRed.disableProperty().bind(playable.not());
        btnBlack.disableProperty().bind(playable.not());

        //Update player score
        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty()));

        //Button events
        btnPlay.setOnAction(event -> startNewGame());
        btnRed.setOnAction(event -> player.takeCard(deck.drawCard(),"red"));
        btnBlack.setOnAction(event -> player.takeCard(deck.drawCard(),"black"));
        btnExit.setOnAction(event -> System.exit(0));

        return root;
    }

    private void startNewGame() {
        playable.set(true);
        message.setText("");

        deck.refill();

        player.reset();

    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setBoard()));
        //Insert new methods here
        //primarystage.makeButtons();

        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Red or Black");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
