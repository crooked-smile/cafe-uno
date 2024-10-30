import java.util.Scanner;

public class Input {
    public static String input(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(prompt);

        return userInput.nextLine();
    }

    public static int inputInt(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(prompt);

        return userInput.nextInt();
    }

    public static double inputDouble(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(prompt);

        return userInput.nextDouble();
    }
}
