import java.util.*;
public class P42747_W {
    class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++)
        {
            int current=citations[i]; //현재 확인중인 인용된 논문
            int h=n-i;
            if(current>=h)
            {
                answer=h;
                break;
            }
        }
        return answer;
    }
}
}
