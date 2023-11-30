import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadderGame {
    private static final int BOARD_SIZE = 100;
    private static final int[] SNAKE_POSITIONS = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] SNAKE_DESTINATIONS = {6, 26, 11, 53, 19, 60, 24, 73, 75, 78};
    private static final int[] LADDER_STARTS = {1, 4, 9, 21, 28, 36, 51, 71, 80};
    private static final int[] LADDER_DESTINATIONS = {38, 14, 31, 42, 84, 44, 67, 91, 100};

    private int playerPosition;

    public SnakeAndLadderGame() {
        this.playerPosition = 1;
    }

    private void rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to roll the dice...");
        scanner.nextLine();
        Random random = new Random();
        int diceValue = random.nextInt(6) + 1;
        System.out.println("You rolled a " + diceValue + ".");
        movePlayer(diceValue);
    }

    private void movePlayer(int steps) {
        playerPosition += steps;

        if (playerPosition > BOARD_SIZE) {
            int overshoot = playerPosition - BOARD_SIZE;
            playerPosition = BOARD_SIZE - overshoot;
        }

        checkSnakeAndLadder();
        System.out.println("You are now at position " + playerPosition);

        if (playerPosition == BOARD_SIZE) {
            System.out.println("Congratulations! You reached the end. Game Over!");
            System.exit(0);
        }

        rollDice();
    }

    private void checkSnakeAndLadder() {
        for (int i = 0; i < SNAKE_POSITIONS.length; i++) {
            if (playerPosition == SNAKE_POSITIONS[i]) {
                System.out.println("Oops! You encountered a snake. Go back to position " + SNAKE_DESTINATIONS[i]);
                playerPosition = SNAKE_DESTINATIONS[i];
            }
        }

        for (int i = 0; i < LADDER_STARTS.length; i++) {
            if (playerPosition == LADDER_STARTS[i]) {
                System.out.println("Yay! You found a ladder. Climb to position " + LADDER_DESTINATIONS[i]);
                playerPosition = LADDER_DESTINATIONS[i];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.rollDice();
    }
}
