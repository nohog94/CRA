import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameRefactor implements IGame{
    List<Player> players = new ArrayList<Player>();
    List<String> popQuestions = new LinkedList<>();
    List<String> scienceQuestions = new LinkedList<>();
    List<String> sportsQuestions = new LinkedList<>();
    List<String> rockQuestions = new LinkedList<>();

    int currentPlayerIndex = 0;
    Player currentPlayer;

    public GameRefactor(){  
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add("Science Question " + i);
            sportsQuestions.add("Sports Question " + i);
            rockQuestions.add(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }


    public int howManyPlayers() {
        return players.size();
    }

    public void rolling(int roll) {
        currentPlayer = getCurrentPlayer();
        System.out.println(currentPlayer.name + " is the current player");
        System.out.println("They have rolled a " + roll);
        if (!checkEscapePenaltyBox(roll)) return;
        movePlacesByRoll(roll);
        askQuestion();
    }

    private boolean checkEscapePenaltyBox(int roll) {
        if (currentPlayer.inPenaltyBox) {
            if (roll % 2 == 0) {
                System.out.println(currentPlayer.name + " is not getting out of the penalty box");
                return false;
            } else {
                currentPlayer.inPenaltyBox = false;
                System.out.println(currentPlayer.name + " is getting out of the penalty box");
            }
        }
        return true;
    }

    private void movePlacesByRoll(int roll) {
        currentPlayer.setPlace((currentPlayer.getPlace() + roll) % 12);
        System.out.println(currentPlayer.name
                + "'s new location is "
                + currentPlayer.getPlace());
    }

    private void askQuestion() {
        System.out.println("The category is " + currentCategory());
        if (currentCategory().equals("Pop"))
            System.out.println(popQuestions.remove(0));
        if (currentCategory().equals("Science"))
            System.out.println(scienceQuestions.remove(0));
        if (currentCategory().equals("Sports"))
            System.out.println(sportsQuestions.remove(0));
        if (currentCategory().equals("Rock"))
            System.out.println(rockQuestions.remove(0));
    }

    public boolean correctAnswer() {
        if (currentPlayer.inPenaltyBox) {
            setNextPlayer();
        } else{
            System.out.println("Answer was correct!!!!");
            currentPlayer.setCoins(currentPlayer.getCoin()+1);
            System.out.println(currentPlayer.name + " now has "
                    + currentPlayer.getCoin() + " Gold Coins.");
            if (onGame()) {
                setNextPlayer();
            }
        }
        return onGame();
    }


    public void wrongAnswer(){
        if (currentPlayer.inPenaltyBox){
            setNextPlayer();
        } else {
            System.out.println("Question was incorrectly answered");
            System.out.println(currentPlayer.name + " was sent to the penalty box");
            currentPlayer.inPenaltyBox = true;
            setNextPlayer();
        }
    }

    private String currentCategory() {
        if (currentPlayer.getPlace() == 0) return "Pop";
        if (currentPlayer.getPlace() == 4) return "Pop";
        if (currentPlayer.getPlace() == 8) return "Pop";
        if (currentPlayer.getPlace() == 1) return "Science";
        if (currentPlayer.getPlace() == 5) return "Science";
        if (currentPlayer.getPlace() == 9) return "Science";
        if (currentPlayer.getPlace() == 2) return "Sports";
        if (currentPlayer.getPlace() == 6) return "Sports";
        if (currentPlayer.getPlace() == 10) return "Sports";
        return "Rock";
    }

    private void setNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        currentPlayer = getCurrentPlayer();
    }

    private Player getCurrentPlayer() {

        return players.get(currentPlayerIndex);
    }

    private boolean onGame() {
        return !(currentPlayer.getCoin() == 6);
    }
}