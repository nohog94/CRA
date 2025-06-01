public class GameMachine {
    private int totalCoin = 0;
    public void inputCoin(int a) throws Exception {
        if (a>5) {
           throw new RuntimeException("코인은 최대 5개까지 넣을 수 있음");
        }
        if (this.totalCoin + a > 10) {
            throw new RuntimeException("입력된 코인이 10보다 초과될 수 없음");
        }
        this.totalCoin += a;
    }
    public void playGame() throws Exception {
        if (this.totalCoin == 0 ){
            throw new RuntimeException("남아 있는 코인이 없음");
        }
        totalCoin -= 1;
    }
    public void coinStatus() {
        System.out.println("current coin : " + this.totalCoin);
    }
}
