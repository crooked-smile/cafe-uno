public class Player {
    private final String playerName;
    private Hand playerHand;

    public Player(String aPlayerName) {
        this.playerName = aPlayerName;
        this.playerHand = new Hand(7);
    }

    public String getPlayerName() {
        return playerName;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }
}
