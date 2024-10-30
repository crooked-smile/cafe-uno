public class Card {
    private final int id;
    private final String symbol;
    private final String color;

    public Card(int aId, String aSymbol, String aColor) {
        this.id = aId;
        this.symbol = aSymbol;
        this.color = aColor;
    }

    public int getId() {
        return this.id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
}
