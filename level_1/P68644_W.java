import java.util.*;
public class P68644_W {
class Solution {
    public int[] solution(int[] numbers) {
        int cnt=0;
        HashSet<Integer> hs=new HashSet<>(); //더한 값을 집어넣음
        cnt=numbers.length;
        for(int i=0;i<cnt;i++)
        {
            int v1=numbers[i]; //
            for(int j=i+1;j<cnt;j++)
            {
                int v2=numbers[j];
                int result=v1+v2;
                hs.add(result);
            }
        }
        int size=hs.size();
        int[] answer = new int[size];
         ArrayList<Integer> al=new ArrayList<>();
        for(int n : hs)
        {
            al.add(n);
        }
        Collections.sort(al);
        for(int i=0;i<size;i++)
        {
            answer[i]=al.get(i);
        }
        return answer;
    }
}
    
}
