public class Player {
    String name;
    private int coins = 0;

    int place = 0;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    boolean inPenaltyBox = false;

    public int getCoin() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Player(String name) {
        this.name = name;
    }
}
