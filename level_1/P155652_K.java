import java.util.*;
public class P155652_K {
    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";

            ArrayList<Character> skipArr = new ArrayList<>();

            for(char c : skip.toCharArray()){
                skipArr.add(c);
            }

            for(char c : s.toCharArray()){
                for(int i = 0; i < index;){
                    c++;

                    if (c > 'z')
                        c = 'a';

                    if(!skipArr.contains(c)){
                        i++;
                    }
                }
                answer += c;
            }

            return answer;
        }
    }
}
