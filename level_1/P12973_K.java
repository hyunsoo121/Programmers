import java.util.*;
public class P12973_K {

    class Solution
    {
        public int solution(String s){
            int answer = 0;

            Stack<Character> stack = new Stack<>();

            for(char c : s.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty())
                answer++;

            return answer;
        }
    }

}
