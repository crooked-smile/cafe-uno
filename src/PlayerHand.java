import java.util.ArrayList;
import java.util.Random;

public class PlayerHand {
    private final CardDeck cardDeck;
    private ArrayList<Card> playerHand = new ArrayList<>();

    public PlayerHand(CardDeck deck, int initialHandSize) {
        cardDeck = deck;
        for (int i = 0; i < initialHandSize; i++) {
            Random rand = new Random();
            playerHand.add(cardDeck.drawCard(rand.nextInt(0, 112)));
        }
    }
}
