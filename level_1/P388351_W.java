public class P388351_W {
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            int[] credit=new int[schedules.length]; //각 사원들의 점수를 저장
            int[] day=new int[7];
            int start=startday-1;
            for(int i=0;i<7;i++){
                day[i]=start; start++; start%=7; 
            }
            for(int i=0;i<schedules.length;i++)
            {
                int target=schedules[i]+10; //출근 인정시간 >> 10분 더했을때 59이상인 경우
                if(target%100 >=60)
                {
                    target+=100; target-=60;
                }
                int cnt=0;
                for(int j=0;j<7;j++)
                {
                    if(day[j]<5&& target>=timelogs[i][j]) //평일인경우 + 출근 인정
                    {
                        cnt++;
                    }
                }
                credit[i]=cnt;
            }
            for(int mem : credit)
            {
                if(mem==5) answer++;
            }
            return answer;
        }
    }
    
}
