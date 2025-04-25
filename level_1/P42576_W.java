import java.util.*;
public class P42576_W 
{
    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String,Integer> hm=new HashMap<>();
            for(String part : participant)
            {
                hm.put(part,hm.getOrDefault(part,0)+1);
            }
            for(String finish : completion)
            {
                hm.put(finish,hm.get(finish)-1);
            }
            for(String check : hm.keySet())
            {
                if(hm.get(check)!=0)
                {
                    return check;
                }
            }
            return "";
        }
    }    
}
