import java.util.*;
public class P12901_K {
    class Solution {
        public String solution(int a, int b) {
            String answer = "";
            String[] weekend = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
            int index = 4;
            int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            for(int i = 0; i < a - 1; i++){
                for(int j = 1; j <= day[i]; j++){
                    index = (index+1) % 7;
                }
            }

            for(int i = 1; i <= b; i++){
                index = (index+1) % 7;
            }

            answer = weekend[index];
            return answer;
        }
    }
}
