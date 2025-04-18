import java.util.*;
public class P12977_W {
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int length=nums.length;
        ArrayList<Integer> al=new ArrayList<>(); //가능한 모든 합을 저장
        for(int i=0;i<length;i++)
        {
            for(int j=i+1;j<length;j++)
            {
                for(int k=j+1;k<length;k++)
                {
                    int total=nums[i]+nums[j]+nums[k];
                    al.add(total);
                }
            }
        }
        Collections.sort(al); int l=al.size();
        int max=al.get(l-1); //가장 큰 값 저장
        boolean[] isPrime=new boolean[max+1]; //소수의 여부를 정함
        for(int i=2;i<=max;i++)
        {
            for(int j=i*2;j<=max;j+=i)
            {
                isPrime[j]=true; //true면 소수아님, false면 소수
            }
        }
        for(int key : al)
        {
            if(!isPrime[key]) answer++;
        }
        return answer;
    }
}
    
}
