import java.util.*;
public class P140108_K {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            char firstChar = ' ';

            for(char c : s.toCharArray()){
                if(s1.length() == 0){
                    firstChar = c;
                    s1.append(c);
                }
                else if(c == firstChar){
                    s1.append(c);
                }
                else if(c != firstChar){
                    s2.append(c);
                    if(s1.length() == s2.length()){
                        s1.setLength(0);
                        s2.setLength(0);
                        answer++;
                    }
                }
            }

            if(s1.length() != 0)
                answer++;

            return answer;
        }
    }
}
