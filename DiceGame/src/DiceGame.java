import Dice.Dice;
import Player.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Dice> dices = new ArrayList<>();
    private static Dice d1, d2, d3, d4;

    public static void main(String args[]) {
        try {
            d1 = new Dice(1);
            d2 = new Dice(2);
            d3 = new Dice(3);
            d4 = new Dice(4);
            dices.add(d1);
            dices.add(d2);
            dices.add(d3);
            dices.add(d4);

            showMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            int m;
            System.out.println("\n============= DICE GAME =============\n");
            System.out.println("1. New Game");
            System.out.println("0. Exit");
            System.out.print("\nYour choice: ");
            try {
                m = keyboard.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if (m == 1) {
                showNewGameMenu();
            } else if (m == 0) {
                System.out.println("Thanks for playing, see you soon!!!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showNewGameMenu() {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            int m;
            System.out.println("\n============= Players =============\n");
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + 1 + ". " + players.get(i).getName());
            }
            System.out.println("\n====================================\n");
            System.out.println("1. New Player");
            System.out.println("2. Begin");
            System.out.println("0. Back");
            System.out.print("\nYour choice: ");
            try {
                m = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if (m == 1) {
                System.out.print("Enter player's name: ");
                String name = keyboard.nextLine();
                try {
                    Player p = new Player(name);
                    players.add(p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (m == 2) {
                String winner = "";
                int playersNum = Player.getNUM();
                if (playersNum < 4) {
                    System.out.println("Auto generate " + (4 - playersNum) + " Bot");
                    for (int i = 0; i < 4 - playersNum; i++) {
                        try {
                            players.add(new Bot());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                while (true) {
                    int score = 0;
                    for (Player p : players) {
                        System.out.println("\n====================================");
                        System.out.println(p.getName() + "'s turn:");
                        if (p instanceof Bot) {
                            p.rollDice(DiceGame.pickADice());
                            score = p.getScore();
                            if (score == -1) {
                                winner = p.getName();
                                break;
                            }
                            continue;
                        }
                        System.out.print("Enter to roll dice: ");
                        keyboard.nextLine();
                        p.rollDice(DiceGame.pickADice());
                        score = p.getScore();
                        if (score == -1) {
                            break;
                        }
                    }
                    if (score == -1) {
                        break;
                    }
                }
                for (Player p : players) {
                    if (p instanceof Bot && !p.getName().equals(winner)) {
                        ((Bot) p).expressEmotion();
                    }
                }
                players.removeIf(e -> e instanceof Bot);
                Player.clearBot(4 - playersNum);
                Bot.clearBot();
            } else if (m == 0) {
                players.clear();
                Player.clearPLayer();
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static Dice pickADice() {
        Random r = new Random();
        int idx = r.nextInt(4);
        return dices.get(idx);
    }
}
