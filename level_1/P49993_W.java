import java.util.*;

public class P49993_W {
    class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set=new TreeSet<>();
        for(int i=0;i<skill.length();i++)
        {
            set.add(skill.charAt(i));
        }
        for(String s : skill_trees)
        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                if(set.contains(s.charAt(i))) //스킬트리에 있는 스킬인 경우
                {
                    sb.append(s.charAt(i));
                }
                else continue;
            }
            String candidate=sb.toString();
            if(candidate.equals(""))
            {
                answer++; continue;
            }
            boolean[] check=new boolean[skill.length()];
            boolean value=true;
            for(int i=0;i<candidate.length();i++)
            {
                char c=candidate.charAt(i);
                for(int j=0;j<skill.length();j++)
                {
                    if(c==skill.charAt(j))
                    {
                        for(int k=0;k<j;k++)
                        {
                            if(!check[k])
                            {
                                value=false;
                                break;
                            }
                        }
                        if(value) check[j]=true;
                    }
                }
            }
            if(value) answer++;
        }
        return answer;
    }
}
}
