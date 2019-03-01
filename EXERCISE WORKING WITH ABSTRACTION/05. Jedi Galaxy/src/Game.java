import entity.Evil;
import entity.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Galaxy galaxy;
    private long sum;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.sum = 0L;
        this.initGalaxy();
    }

    private void initGalaxy() {
        int[] galaxySizes = this.inputReaderToIntArray(scanner);
        this.galaxy = new Galaxy(galaxySizes[0], galaxySizes[1]);
    }

    public void gameLoop() {

        while (true) {
            int[] ivoCoords;
            int[] evilCoords;
            try {
                ivoCoords = inputReaderToIntArray(scanner);
                evilCoords = inputReaderToIntArray(scanner);
            } catch (IllegalArgumentException e) {
                break;
            }

            Evil evil = new Evil(evilCoords[0], evilCoords[1]);

            while (evil.getRow() >= 0 && evil.getCol() >= 0) {
                if (galaxy.isValid(evil.getRow(), evil.getCol())) {
                    galaxy.stepOn(evil.getRow(), evil.getCol());
                }
                evil.move();
            }

            Player player = new Player(ivoCoords[0], ivoCoords[1]);

            while (player.getRow() >= 0 && player.getCol() < galaxy.getColLength()) {
                if (galaxy.isValid(player.getRow(), player.getCol())) {
                    sum += galaxy.getPointsAt(player.getRow(), player.getCol());
                }

                player.move();
            }

        }
    }

    public long getPoints() {
        return this.sum;
    }

    private int[] inputReaderToIntArray(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equals("Let the Force be with you")) {
            throw new IllegalArgumentException("Game Over!");
        }
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
