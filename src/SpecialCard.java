public class SpecialCard extends Card {
    private String playableColor;

    public SpecialCard(int aId, String aSymbol) {
        super(aId, aSymbol, "W");
        playableColor = "N";
    }

    public String getPlayableColor() {
        return playableColor;
    }

    public void setPlayableColor(String aPlayableColor) {
        this.playableColor = aPlayableColor;
    }
}
