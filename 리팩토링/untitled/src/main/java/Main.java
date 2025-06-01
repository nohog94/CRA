import java.util.ArrayList;
class ExpressionValidator {

    public static String getResult(String str) {
        int p1, p2;

        p1 = getPlusMarkPos(str);
        p2 = getEqualMarkPos(str);
        if (!isValid(str, p1, p2)) {return "ERROR";}

        String num1 = str.substring(0, p1);
        String num2 = str.substring(p1 + 1, p2);
        String num3 = str.substring(p2 + 1);
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int n3 = Integer.parseInt(num3);
        if (n1 + n2 == n3) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    private static int getPlusMarkPos(String str) {
        int count = 0;
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                count++;
                pos = i;
            }
        }
        if (count > 1 || pos == 0) {
            return -1;
        }
        return pos;
    }

    private static int getEqualMarkPos(String str) {
        int count = 0;
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '=') {
                count++;
                pos = i;
            }
        }
        if (count > 1 || pos < 3 || pos == str.length() -1) {
            return -1;
        }
        return pos;
    }

    private static boolean isValid(String str, int plusMarkPos, int equalMarkPos) {
        if (plusMarkPos == -1 || equalMarkPos == -1 || plusMarkPos >= equalMarkPos - 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9') && i != plusMarkPos && i != equalMarkPos) {
                return false;
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        String str = "25+61=86";
        System.out.println(ExpressionValidator.getResult(str));
    }
}
