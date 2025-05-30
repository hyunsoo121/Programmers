import java.util.*;
public class P138476_W {
    class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<tangerine.length;i++)
        {
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0)+1);
            if(hm.get(tangerine[i])==1) //지금 들어온 값이라면
            {
                al.add(tangerine[i]);
            }
        }
        Collections.sort(al,(a,b)->{
            return Integer.compare(hm.get(b), hm.get(a));
        });
        for(int num : al)
        {
            if(k>hm.get(num))
            {
                answer++;
                k-=hm.get(num);
            }
            else
            {
                answer++;
                break;
            }
        }
        return answer;
    }
}
}
