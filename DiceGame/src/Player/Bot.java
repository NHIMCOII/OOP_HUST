package Player;

import CustomException.EnoughPlayerException;
import CustomException.InvalidPlayerNameException;

public class Bot extends Player implements LoserExpressEmotion {
    private static int id = 1;
    private String quote1 = "Huhu lets play again, winner wins all!!!";
    private String quote2 = "Beginner's luck, wanna try again";
    private String quote3 = "Congrat, you should go to Las Vegas";
    private String quote4 = "Suiiii";

    public Bot() throws EnoughPlayerException, InvalidPlayerNameException {
        super("Bot " + id);
        id++;
    }

    public static void clearBot() {
        id = 1;
    }

    @Override
    public void expressEmotion() {
        String quote = "";
        if (this.name.equals("Bot 1")) {
            quote = quote1;
        }
        if (this.name.equals("Bot 2")) {
            quote = quote2;
        }
        if (this.name.equals("Bot 3")) {
            quote = quote3;
        }
        if (this.name.equals("Bot 4")) {
            quote = quote4;
        }
        System.out.println(name + " said: " + quote);
    }
}
