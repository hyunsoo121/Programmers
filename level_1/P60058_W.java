import java.util.*;

public class P60058_W {
    class Solution {
    public String solution(String p) {
        if(p.equals("")) return "";
        String[] divided=divide(p);
        String u=divided[0]; String v=divided[1];
        if(isCorrect(u)) return u+solution(v);
        else
        {
            StringBuilder sb=new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            sb.append(reverse(u.substring(1, u.length()-1)));
            return sb.toString();
        }        
    }
    String[] divide(String s)
    {
        int left=0; int right=0;
        int i=0;
        for(;i<s.length();i++)
        {
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) break;
        }
        return new String[] {s.substring(0, i+1),
        s.substring(i+1)
    };
    }
    boolean isCorrect(String s)
    {
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c=='(') stack.push('(');
            else
            {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }
    String reverse(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(c=='(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}
}
