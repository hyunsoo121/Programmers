public class P12901_W {
    class Solution {
        public String solution(int a, int b) 
        {
            String[] week ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
            int[] monthDays = {0,31,29,31,30,31,30,31,31,30,31,30,31};
            int totalDays = 0;
            for (int i=1;i<a;i++) 
            {
                totalDays+=monthDays[i];
            }
            totalDays+=(b-1); // 해당 월의 b일 전까지 며칠 지났는지
            // 해당 요일을 week 배열에서 찾기
            String answer = week[totalDays%7];
            return answer;
        }
    }
    
}
