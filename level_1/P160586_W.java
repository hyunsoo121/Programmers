import java.util.*;
public class P160586_W {
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> hm=new HashMap<>(); //문자의 최소 개수 저장
        for(String s :keymap)
        {
            char[] str=s.toCharArray();
            for(int i=0;i<str.length;i++)
            {
                if(hm.containsKey(str[i])) //포함하고 있는 경우
                {
                    int min=Math.min(hm.get(str[i]),i+1);
                    hm.put(str[i],min);
                }
                else
                {
                    hm.put(str[i],i+1);
                }
            }
        }
        for(int j=0;j<targets.length;j++)
        {
            char[] str=targets[j].toCharArray();
            int cnt=0;
            for(int i=0;i<str.length;i++)
            {
                if(!hm.containsKey(str[i]))
                {
                    cnt=-1;
                    break;
                }
                cnt+=hm.get(str[i]);
            }
            answer[j]=cnt;
        }
        return answer;
    }
}
    
}
