package Player;

import CustomException.EnoughPlayerException;
import CustomException.InvalidPlayerNameException;

public class Bot extends Player implements LoserExpressEmotion {
    private static int id = 1;

    public Bot() throws EnoughPlayerException, InvalidPlayerNameException {
        super("Bot " + id);
        id++;
    }

    public static void clearBot() {
        id = 1;
    }

    @Override
    public void expressEmotion() {
        System.out.println(name + " said: " + "Huhu lets play again, winner wins all!!!");
    }
}
