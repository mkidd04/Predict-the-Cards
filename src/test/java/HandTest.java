import edu.bsu.cs222.predictTheCards.Card;
import edu.bsu.cs222.predictTheCards.Deck;
import edu.bsu.cs222.predictTheCards.Hand;
import org.junit.jupiter.api.Test;

public class HandTest {
    @Test
    public void takeCardTest(){
        Deck deck = new Deck();
        Card card = deck.drawCard();
        Hand player = new Hand();
    }
}
