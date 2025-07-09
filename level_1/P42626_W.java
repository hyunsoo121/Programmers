import java.util.*;
public class P42626_W 
{
    class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville)
        {
            pq.add(s);
        }
        while(pq.peek()<K)
        {
            int candidate_1=pq.poll();
            int candidate_2=pq.poll();
            int new_scoville=candidate_1+(candidate_2*2);
            if(new_scoville<K && pq.isEmpty())
            {
                return -1;
            }
            answer++;
            pq.add(new_scoville);
        }
        return answer;
    }
}
}
