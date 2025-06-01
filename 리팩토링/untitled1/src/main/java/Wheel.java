import java.util.List;

public class Wheel {
    boolean[] isPossibleFirstChance = { false, false, false, false };
    int continueTurnBonusCount = 0;
    boolean[] FisrtChanceSuccessBefore = { false, false, false, false };
    boolean[][] isFlip = new boolean[4][15];

    int getPrice(List<StringBuilder> strs, String userdata) {
        int totalPrice = 0;
        

        for (int i = 0; i < 26; i++) {
            char answerChar = userdata.charAt(i);

            totalPrice += getLetsSecondPrice(strs, answerChar);
            totalPrice += getLetsFirstPrice(strs, answerChar);

            int flipCount = getFlipCount(strs, answerChar);
            updateContinueTurnBonusCount(flipCount);
            totalPrice += getaddedPrice(flipCount);

            initBeforeNextRound(flipCount);
        }
        return totalPrice;
    }

    private void initBeforeNextRound(int flipCount) {
        if (flipCount == 0) {
            continueTurnBonusCount = 0;
            for (int t = 0; t < 4; t++) FisrtChanceSuccessBefore[t] = false;
        }
    }

    private int getaddedPrice(int flipCount) {
        return (continueTurnBonusCount * 100) * flipCount;
    }

    private void updateContinueTurnBonusCount(int flipCount) {
        if (flipCount >= 1) {
            continueTurnBonusCount++;
        }
    }

    private int getFlipCount(List<StringBuilder> strs, char answerChar) {
        int flipCount = 0;
        for (int y = 0; y < strs.size(); y++) {
            for (int x = 0; x < strs.get(y).length(); x++) {
                if (isFlip[y][x]) continue;
                if (strs.get(y).charAt(x) != answerChar) continue;
                isFlip[y][x] = true;
                flipCount++;
            }
        }
        return flipCount;
    }

    private int getLetsFirstPrice(List<StringBuilder> strs, char answerChar) {
        int BonusPrice = 0;

        for (int y = 0; y < strs.size(); y++) {
            for (int x = 0; x < strs.get(y).length(); x++) {
                if (isFlip[y][x]) continue;
                if (strs.get(y).charAt(x) != answerChar) continue;
                if (isPossibleFirstChance[y]) continue;
                isPossibleFirstChance[y] = true;
                if (x == 0) {
                    BonusPrice += 1000;
                    FisrtChanceSuccessBefore[y] = true;
                }

            }
        }
        return BonusPrice;
    }

    private int getLetsSecondPrice(List<StringBuilder> strs, char answerChar) {
        int BonusPrice = 0;

        for (int y = 0; y < strs.size(); y++) {
            if (!FisrtChanceSuccessBefore[y]) continue;
            for (int x = 0; x < strs.get(y).length(); x++) {
                if (isFlip[y][x]) continue;
                if (strs.get(y).charAt(x) == answerChar) {
                    BonusPrice += 2000;
                    break;
                }
            }
        }
        for (int y = 0; y < strs.size(); y++) {
            FisrtChanceSuccessBefore[y] = false;
        }
        return BonusPrice;
    }
}