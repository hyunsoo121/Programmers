
import java.util.*;
public class P138477_K {
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < score.length; i++){

                arr.add(score[i]);
                Collections.sort(arr);

                if (arr.size() > k){
                    arr.remove(0);
                }

                answer[i] = arr.get(0);
            }

            return answer;
        }
    }
}