import java.util.Stack;

public class P76502_W {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int len = s.length();

            for (int i = 0; i < len; i++) {
                int cnt = 0;
                int current = i;
                boolean possible = true;
                Stack<Character> stack = new Stack<>();

                while (cnt < len) {
                    char ch = s.charAt(current);

                    if (ch == '(' || ch == '[' || ch == '{') {
                        stack.push(ch);
                    } else {
                        if (stack.isEmpty()) {
                            possible = false;
                            break;
                        }

                        char top = stack.peek();
                        if ((top == '(' && ch == ')') ||
                            (top == '[' && ch == ']') ||
                            (top == '{' && ch == '}')) {
                            stack.pop();
                        } else {
                            possible = false;
                            break;
                        }
                    }

                    current++;
                    current %= len;
                    cnt++;
                }

                if (possible && stack.isEmpty()) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
