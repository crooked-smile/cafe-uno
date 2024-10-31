import java.util.Objects;

public class Card {
    private final int id;
    private final String symbol;
    private final String color;
    private String playableColor;

    public Card(int aId, String aSymbol, String aColor) {
        this.id = aId;
        this.symbol = aSymbol;
        this.color = aColor;
        if (Objects.equals(aColor, "W")) {
            this.playableColor = "N";
        } else {
            this.playableColor = aColor;
        }
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

    public String getPlayableColor() {
        return playableColor;
    }

    public void setPlayableColor(String aPlayableColor) {
        if (Objects.equals(this.color, "W")) {
            this.playableColor = aPlayableColor;
        }
    }
}