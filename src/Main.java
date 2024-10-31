import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final Scanner userInput = new Scanner(System.in);
    public static Deck gameDeck = new Deck();

    private static Map<String, Player> playerData = new LinkedHashMap<>();
    private static Map<String, Deck> deckData = new LinkedHashMap<>();

    private static Map<String, Object> gameState = new LinkedHashMap<>();

    public static void main(String[] args) {
        gameState.put("PlayerData", playerData);
        gameState.put("DeckData", gameDeck);

        Player playerOne = new Player("Crooked");
        playerData.put(playerOne.getPlayerName(), playerOne);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(gameState));
    }

    public static Scanner userPrompt(String prompt) {
        System.out.print(prompt);

        return userInput;
    }
}