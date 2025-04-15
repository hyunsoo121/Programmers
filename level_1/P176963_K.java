

import java.util.*;

public class P176963_K {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {

            int[] answer = new int[photo.length];
            ArrayList<String> arr = new ArrayList<>(Arrays.asList(name));

            for(int i = 0; i < photo.length; i++){

                int count = 0;

                for(int j = 0; j < photo[i].length; j++){
                    if (arr.contains(photo[i][j]))
                        count += yearning[arr.indexOf(photo[i][j])];
                }

                answer[i] = count;
            }

            return answer;
        }
    }
}