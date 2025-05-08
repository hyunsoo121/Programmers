import java.util.*;
public class P340198_K {

    class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = -1;
            boolean isTrue;

            Arrays.sort(mats);

            for (int m : mats) {
                isTrue = false;

                for (int i = 0; i <= park.length - m; i++) {
                    for (int j = 0; j <= park[0].length - m; j++) {
                        boolean canPlace = true;

                        for (int h = i; h < i + m; h++) {
                            for (int w = j; w < j + m; w++) {
                                if (!park[h][w].equals("-1")) {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (!canPlace) break;
                        }

                        if (canPlace) {
                            isTrue = true;
                            break;
                        }
                    }
                    if (isTrue) break;
                }

                if (isTrue) {
                    answer = m;
                }
            }

            return answer;
        }
    }
}
