import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    void playGame(IGame aGame, int seed) {
        boolean onGame = true;

        aGame.add("[Kim]");
        aGame.add("[Lee]");
        aGame.add("[Park]");

        Random rand = new Random(seed);

        do {
            int roll = rand.nextInt(6) + 1;
            aGame.rolling(roll);

            if (rand.nextInt(9) == 7) {
                aGame.wrongAnswer();
            } else {
                onGame = aGame.correctAnswer();
            }
        } while (onGame);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 50, 100, 777})
    void goldenMaster(int randomSeed) {
        //arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        playGame(new Game(), randomSeed);
        String expected = outputStream.toString();
        outputStream.reset(); //출력 스트림 리셋

        //actual
        playGame(new GameRefactor(), randomSeed);
        String actual = outputStream.toString();
        System.setOut(originalOut); //출력 스트림 원상복구

        //assert
        assertEquals(expected, actual);
    }
}