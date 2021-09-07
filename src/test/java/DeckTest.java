import edu.bsu.cs222.predictTheCards.Card;
import edu.bsu.cs222.predictTheCards.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    public void drawCardTest(){
        Deck deck = new Deck();
        Card actual = deck.drawCard();
        Assertions.assertNotNull(actual);
    }
}
