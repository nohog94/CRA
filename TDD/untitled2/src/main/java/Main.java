  class KFCException extends RuntimeException {

  }

public class Main {
    static  int bbq() {
        return 9;
    }
    public static void main(String[] args) {
        try {
            if (bbq() == 9) {
                throw new KFCException();
            }
        } catch (Exception e) {
            System.out.printf(String.valueOf(e));
        }
    }
}
