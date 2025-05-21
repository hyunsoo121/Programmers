import java.util.*;

public class P12981 {
    class Solution {
        public int[] solution(int n, String[] words) {

            int[] participant = new int[n];
            int[] answer = {0, 0};
            ArrayList<String> wordList = new ArrayList<>();

            String prevWord = " ";
            int index = 0;

            for(String s: words){
                if((!(prevWord.charAt(prevWord.length() - 1) == s.charAt(0)) && !prevWord.equals(" ")) || wordList.contains(s)){
                    participant[index]++;

                    answer[0] = index + 1;
                    answer[1] = participant[index];
                    break;
                }

                prevWord = s;
                wordList.add(s);
                participant[index]++;
                index = (index + 1) % n;
            }

            return answer;
        }
    }
}
