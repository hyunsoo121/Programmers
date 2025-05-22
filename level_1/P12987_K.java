import java.util.*;

public class P12987_K {
    class Solution {
        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);

            int score = 0;

            for(int a = 0, b = 0; b < B.length; b++){
                if(A[a] < B[b]){
                    score++;
                    a++;
                }
            }

            return score;
        }
    }
}
