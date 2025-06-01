import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<StringBuilder> strs = new ArrayList<>();
        int[][] map = new int[4][50];
        String userdata = "";
        int n = 0;

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input1.txt"));
        //BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input2.txt"));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String temp;
            temp = br.readLine();
            strs.add(new StringBuilder(temp));
        }
        userdata = br.readLine();
        br.close();

        Wheel game = new Wheel();
        int sum = game.getPrice(strs, userdata);

        System.out.println("$" + sum);
    }
}