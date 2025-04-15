public class P134240_W {
    class Solution {
        public String solution(int[] food) 
        {
            int total=0; // 음식의 개수
            int cnt=0; //굳이 필요없음 -> food.length() 사용
            for(int n : food)
            {
                if(n%2!=0) //홀수 인 경우
                {
                    n--; //
                }
                total+=n;
                cnt++;
            }
            total++; //물의 개수 더함
            int[] save =new int[total];
            int fp=0; int bp=total-1; //투 포인터로 접근
            
            for(int i=1;i<cnt;i++)
            {
                int size=food[i];
                if(size%2!=0) //홀수인경우
                {
                    size--;
                }
                for(int j=0;j<size/2;j++)
                {
                    save[fp++]=i;
                    save[bp--]=i;
                }
            }
            save[fp]=0;
            StringBuilder sb=new StringBuilder();
            // char c=(char) (num+'0'); -> 문자로 바꿔서
            // s=문자배열.toString;
            // or
            // s=new String(문자배열);
            // s=String.valueof(문자배열);
            for(int n : save)
            {
                sb.append(n);
            }
            String answer=sb.toString();
            return answer;
        }
    }
    
    
}