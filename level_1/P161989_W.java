public class P161989_W {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int current_paint=0;
            for(int i=0;i<section.length;i++)
            {
                if(current_paint < section[i])
                {
                    current_paint=section[i]+m-1;
                    answer++;   
                }
            }
            
            return answer;
        }
    }
    //1~n 배열 , 룰러의 길이는 m미터
    
}
