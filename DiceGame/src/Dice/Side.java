package Dice;

import CustomException.InvalidSideException;

public class Side {
    private int num;
    private float percentage;

    public Side() {
    }

    public Side(int num, float percentage) throws InvalidSideException {
        if (num < 1 || num > 6) {
            throw new InvalidSideException();
        }
        if (percentage == 0.16f || percentage == 0.2f) {
            this.num = num;
            this.percentage = percentage;
        } else {
            throw new InvalidSideException();
        }

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
