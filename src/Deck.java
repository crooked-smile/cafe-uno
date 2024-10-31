import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final Card[] allCards = new Card[112];
    private ArrayList<Integer> cardsAtPlay = new ArrayList<>();
    private Card lastPlayedCard;

    public Deck() {
        int cardSection = 1;
        String[] validColors = {"R", "Y", "G", "B"};

        for (int i = 0; i < allCards.length; i++) {
            String currentColor = validColors[cardSection-1];
            int sectionRelativeIndex = i-14*Math.floorDiv(i, 14);
            if (sectionRelativeIndex == 10) {
                allCards[i] = new Card(i, "S", currentColor);
            } else if (sectionRelativeIndex == 11) {
                allCards[i] = new Card(i, "R", currentColor);
            } else if (sectionRelativeIndex == 12) {
                allCards[i] = new Card(i, "+2", currentColor);
            } else if ((sectionRelativeIndex == 13 && i < 55) || (sectionRelativeIndex == 0 && i >= 55)) {
                allCards[i] = new Card(i, "W", "W");
            } else if (sectionRelativeIndex == 13 && i > 55) {
                allCards[i] = new Card(i, "+4", "W");
            } else {
                allCards[i] = new Card(i, Integer.toString(sectionRelativeIndex), currentColor);
            }
            if ((i + 1) % 14 == 0) cardSection++;
            if (cardSection > 4) cardSection -= 4;
        }
    }

    public Card drawACard() {
        Random rand = new Random();
        Card drawnCard;

        boolean validCard = false;
        do {
            drawnCard = allCards[rand.nextInt(0, 112)];

            if (!cardsAtPlay.contains(drawnCard.getId()) || lastPlayedCard.getId() != drawnCard.getId()) {
                cardsAtPlay.add(drawnCard.getId());
                validCard = true;
            }
        } while (!validCard);

        return drawnCard;
    }

    public void discardCard(Card discardedCard) {
        discardedCard.setPlayableColor("N");
        cardsAtPlay.remove(discardedCard.getId());
    }
}
