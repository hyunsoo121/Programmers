import java.util.*;

public class P135808_K {
    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            int[] box = new int[m];
            for(int i = 0; i < score.length / m; i++){
                for(int j = 0; j < m; j++){
                    box[j] = score[score.length - j - (i * m) - 1]; // 오름차순 정렬이여서 이렇게 더럽게...
                }
                answer += box[m-1] * m;
            }

            return answer;
        }
    }
}
