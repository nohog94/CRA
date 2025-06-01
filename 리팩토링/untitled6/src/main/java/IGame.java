public interface IGame {
    public boolean add(String playerName);
    public void rolling(int roll);
    public boolean correctAnswer();
    public void wrongAnswer();
}