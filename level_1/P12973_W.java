import java.util.Stack;

public class P12973_W 
{
    class Solution 
    {
        public int solution(String s) 
        {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) 
            {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) 
                {
                    stack.pop(); // 짝 제거
                } 
                else 
                {
                    stack.push(c); // 스택에 추가
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
