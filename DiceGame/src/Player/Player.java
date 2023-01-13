package Player;

import CustomException.InvalidPlayerNameException;
import Dice.Dice;
import CustomException.EnoughPlayerException;

public class Player implements RollDice {
    protected String name;
    private int score;
    private final int TARGET = 21;
    private static final int MAX = 4;
    private static int NUM = 0;

    public static int getNUM() {
        return NUM;
    }

    public Player() throws EnoughPlayerException {
        if (NUM == MAX) {
            throw new EnoughPlayerException();
        }
    }

    public Player(String name) throws EnoughPlayerException, InvalidPlayerNameException {
        if (NUM == MAX) {
            throw new EnoughPlayerException();
        }
        if (name.equals("")) {
            throw new InvalidPlayerNameException();
        }
        this.name = name;
        this.score = 0;
        NUM++;
    }

    public int rollDice(Dice dice) {
        int result = dice.roll();
        this.score += result;
        System.out.println(this.name + " rolled: " + result);
        return result;
    }

    public int getScore() {
        if (score > 21) {
            score = 0;
        }
        if (score == 21) {
            System.out.println(this.name + "'s score: " + score);
            System.out.println("Congratulation, " + this.name + " win !!!\n");
            return -1;
        }
        System.out.println(this.name + "'s score: " + score);
        return score;
    }

    public String getName() {
        return name;
    }

    public static void clearPLayer() {
        NUM = 0;
    }

}
