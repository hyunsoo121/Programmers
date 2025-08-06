import java.util.*;
public class P49993_K {

    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            ArrayList<Character> list = new ArrayList<>();

            for(char c : skill.toCharArray()){
                list.add(c);
            }

            for(String s : skill_trees){
                int index = 0;
                answer++;
                for(char c : s.toCharArray()){
                    if(list.contains(c)){
                        if(list.indexOf(c) == index){
                            index++;
                            continue;
                        }
                        else{
                            answer--;
                            break;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
