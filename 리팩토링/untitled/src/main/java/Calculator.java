public class Calculator {
    private int result;
    public void plus(int a, int b) {
        this.result = a+b;
    }
    public void minus(int a, int b) {
        this.result = a-b;
    }
    public void divide(int a, int b) {
        this.result = a/b;
    }
    public void multiple(int a, int b) {
        this.result = a*b;
    }
    public void printResult() {
        System.out.println(this.result);
    }
    public int getsum(int a, int b) {return a+b;}
}
