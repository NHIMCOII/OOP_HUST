package Dice;

import CustomException.*;

import java.util.LinkedList;
import java.util.Random;

public class Dice implements Rollable {
    private Side[] dice = new Side[6];
    private int side20;
    private static final int MAX = 4;
    private static int num = 0;

    public Dice() throws EnoughDiceException {
        if (num == MAX) {
            throw new EnoughDiceException();
        }
    }

    public Dice(int side20) throws InvalidSideException, EnoughDiceException {
        if (num == MAX) {
            throw new EnoughDiceException();
        }
        for (int i = 0; i < 6; i++) {
            if (i == side20 - 1) {
                dice[i] = new Side(side20, (float) 0.2);
                this.side20 = side20;
                continue;
            }
            dice[i] = new Side(i + 1, (float) 0.16);
        }
        num++;
    }

    public int roll() {
        Random r = new Random();
        int result = r.nextInt(100);
        if (result < 20) { // 20%
            return side20;
        }
        LinkedList<Integer> option = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            if (i == side20 - 1) {
                continue;
            }
            option.add(i);
        }
        return option.get(r.nextInt(option.size()));
    }
}
