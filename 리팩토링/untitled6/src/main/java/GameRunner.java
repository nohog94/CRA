import java.util.Random;

public class GameRunner {
    public static void main(String[] args) {
        boolean notAWinner = true;

        Game aGame = new Game();

        aGame.add("[Kim]");
        aGame.add("[Lee]");
        aGame.add("[Park]");

        Random rand = new Random();

        do {
            int roll = rand.nextInt(6) + 1;
            aGame.rolling(roll);

            if (rand.nextInt(9) == 7) {
                aGame.wrongAnswer();
            } else {
                notAWinner = aGame.correctAnswer();
            }
        } while (notAWinner);
    }
}