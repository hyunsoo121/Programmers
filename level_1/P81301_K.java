
import java.util.*;

public class P81301_K {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            HashMap<String, String> map = new HashMap<>();

            String result = "";
            String key = "";

            map.put("zero", "0");
            map.put("one", "1");
            map.put("two", "2");
            map.put("three", "3");
            map.put("four", "4");
            map.put("five", "5");
            map.put("six", "6");
            map.put("seven", "7");
            map.put("eight", "8");
            map.put("nine", "9");

            for (char c : s.toCharArray()){

                if (!Character.isDigit(c)){
                    key += c;
                    if (map.containsKey(key)){
                        result += map.get(key);
                        key = "";
                    }
                }
                else result += c;
            }

            answer = Integer.parseInt(result);

            return answer;
        }
    }
}