import java.util.*;
public class P150370_K {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();

            for (String s : terms) {
                String[] term = s.split(" ");
                map.put(term[0], Integer.parseInt(term[1]));
            }

            String[] todayArr = today.split("\\.");
            int todayTotal = Integer.parseInt(todayArr[0]) * 12 * 28 +
                    Integer.parseInt(todayArr[1]) * 28 +
                    Integer.parseInt(todayArr[2]);

            for (int i = 0; i < privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");
                String[] date = privacy[0].split("\\.");

                int privacyTotal = Integer.parseInt(date[0]) * 12 * 28 +
                        Integer.parseInt(date[1]) * 28 +
                        Integer.parseInt(date[2]) + map.get(privacy[1]) * 28;

                if (todayTotal >= privacyTotal) {
                    list.add(i + 1);
                }
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }
    }
}
