public class Zergling {
    private int hp;
    private int mana;

    public Zergling(int mana, int hp) {
        this.mana = mana;
        this.hp = hp;
    }

    public void attack() {
        hp = hp + 1;
        mana = mana - 10;
    }
    public void move () {
        hp -= 10;
        mana +=5;
    }
    public void status () {
        System.out.println("hp :" + hp + ", mana :" + mana);
    }
}
