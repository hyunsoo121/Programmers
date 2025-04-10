public class P132267_W 
{
    class Solution {
        public int solution(int a, int b, int n) 
        {
            //현재 가지고 있는 빈병 개수 : n
            //a개 주면 b개 받음
            int answer = 0;
            int current=n; //현재 가지고 있는 빈병의 개수
            int replace=Integer.MAX_VALUE;
            int temp;
            while(replace!=0) 
            {
                replace=current/a*b; //몇개 교환할 수 있는지
                temp=replace/b*a;
                current=current+replace-temp; //현재 가지고 있는 콜라병의 개수 저장
                answer+=replace;
            }
            return answer;
        }
    }
}
