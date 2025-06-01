import java.util.ArrayList;

public class OddEven {
    public ArrayList<String> getResult(ArrayList<Integer> nums) {
        if (nums == null || nums.isEmpty()) return null;

        ArrayList<String> result = new ArrayList<>();
        boolean hasEven = false;
        boolean hasOdd = false;

        for (Integer num : nums) {
            if (num % 2 == 0) {
                result.add("O");
                hasEven = true;
            } else {
                result.add("X");
                hasOdd = true;
            }
        }

        // 모두 짝수거나 모두 홀수면 null 리턴
        if (!hasEven || !hasOdd) return null;

        return result;
    }
}
