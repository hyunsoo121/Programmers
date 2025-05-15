import java.util.*;
class P67258_W{
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs=new HashSet<>(); //전체 보석의 종류가 몇개인지 저장
        for(String gem : gems)
        {
            hs.add(gem); //보석의 종류를 저장
        }
        int total_count=hs.size(); //보석의 종류의 개수
        HashMap<String,Integer> hm=new HashMap<>();
        int front=0; int end=0; int min_length=Integer.MAX_VALUE;
        while(true)
        {
            if(hm.keySet().size()<total_count) //확장
            {
                if(end==gems.length) break;
                hm.put(gems[end],hm.getOrDefault(gems[end],0)+1);
                end++;
            }
            else //축소
            {
                if(end-front <min_length)
                {
                    min_length=end-front;
                    answer[0]=front+1; answer[1]=end;
                }
                hm.put(gems[front],hm.get(gems[front])-1);
                if(hm.get(gems[front])==0) hm.remove(gems[front]);
                front++;
            }
        }
        return answer;
    }
}
}