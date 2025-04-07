package Programmers.level_1;
import java.util.*;

public class P68644_K {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < numbers.length; i++){
                for (int j = i + 1; j < numbers.length; j++){
                    int sum = numbers[i] + numbers[j];
                    set.add(sum);
                }
            }

            answer = new int [set.size()];


            Iterator iter = set.iterator();

            for (int i = 0; i < set.size(); i++){
                answer[i] = (int)iter.next();
            }

            Arrays.sort(answer);
            return answer;
        }
    }
}