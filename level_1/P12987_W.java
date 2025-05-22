import java.util.TreeMap;
public class P12987_W 
{
    class Solution {
    public int solution(int[] A, int[] B) 
    {
        int answer=0;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<B.length;i++)
        {
            tm.put(B[i],tm.getOrDefault(B[i],0)+1);
        }
        for(int i=0;i<A.length;i++)
        {
            int A_score=A[i];
            if(tm.higherKey(A_score)!=null)
            {
                int B_score=tm.higherKey(A_score);
                answer++;
                if(tm.get(B_score)==1)
                {
                    tm.remove(B_score);
                }
                else if(tm.get(B_score)>=2)
                {
                    tm.put(B_score,tm.get(B_score)-1);
                }
            }
            else
            {
                continue;
            }
        }
        return answer;
    }
}
}
