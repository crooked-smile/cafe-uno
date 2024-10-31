import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Hand {
    public ArrayList<Card> cardsInHand = new ArrayList<Card>();

    public Hand(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            cardsInHand.add(Main.gameDeck.drawACard());
        }
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCardToHand() {
        cardsInHand.add(Main.gameDeck.drawACard());
    }

    public Card playCard(Card cardToPlay) {
        if (Objects.equals(cardToPlay.getColor(), "W")) {
            String[] validColors = {"R", "Y", "G", "B"};
            boolean validColor = false;
            String wildColor;
            do {
                wildColor = Main.userPrompt("What color do you want this card to be (R, Y, G, B)?: ").nextLine().toUpperCase();
                if (Arrays.asList(validColors).contains(wildColor)) {
                    cardToPlay.setPlayableColor(wildColor);
                    validColor = true;
                }
                else System.out.println("Invalid color!");
            } while (!validColor);
        }
        Card cartToPlayCopy = new Card(cardToPlay.getId(), cardToPlay.getSymbol(), cardToPlay.getColor());
        cartToPlayCopy.setPlayableColor(cardToPlay.getPlayableColor());

        cardsInHand.remove(cardToPlay);
        Main.gameDeck.discardCard(cardToPlay);
        return cartToPlayCopy;
    }
}