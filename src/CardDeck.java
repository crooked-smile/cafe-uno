import java.util.ArrayList;

public class CardDeck {
    private final Card[] cardDeck = new Card[112];
    private final ArrayList<Card> cardsAtPlay = new ArrayList<>();

    public CardDeck() {
        int cardColorSection = 0;
        for (int i = 0; i < this.cardDeck.length; i++) {
            if (i%14 == 0) cardColorSection++;
            int modCheck = (i-9)%14;

            if (0 < modCheck && modCheck <= 4) {
                if (modCheck == 1) this.cardDeck[i] = new Card(i, "S", getColor(cardColorSection));
                else if (modCheck == 2) this.cardDeck[i] = new Card(i, "R", getColor(cardColorSection));
                else if (modCheck == 3) this.cardDeck[i] = new Card(i, "+2", getColor(cardColorSection));
                else if (i < 56) this.cardDeck[i] = new SpecialCard(i, "W");
                else this.cardDeck[i] = new SpecialCard(i, "+4");
            } else this.cardDeck[i] = new Card(i, Integer.toString(i), getColor(cardColorSection));
        }
    }

    private String getColor(int aCardColorSection) {
        if (aCardColorSection == 0 || aCardColorSection == 4) return "R";
        else if (aCardColorSection == 1 || aCardColorSection == 5) return "Y";
        else if (aCardColorSection == 2 || aCardColorSection == 6) return "G";
        else if (aCardColorSection == 3 || aCardColorSection == 7) return "B";
        else return "N";
    }

    public Card drawCard(int cardId) {
        boolean usableCard = false;
        while (!usableCard) {
            boolean cardAlreadyAtPlay = false;
            for (Card cardAtPlay : cardsAtPlay) {
                if (cardAtPlay.getId() == cardId) {
                    cardAlreadyAtPlay = true;
                    break;
                }
            }
            if (!cardAlreadyAtPlay) {
                cardsAtPlay.add(cardDeck[cardId]);
                usableCard = true;
            }
        }
        return cardDeck[cardId];
    }
}
