public class P388351_K {
    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = schedules.length;

            int initDay = startday;

            for(int i = 0; i < schedules.length; i++){
                schedules[i] += 10;

                if(schedules[i] % 100 >= 60){
                    schedules[i] += 40;
                }
            }

            for(int i : schedules){
                System.out.println(i);
            }
            for(int i = 0; i < timelogs.length; i++){
                for(int j = 0; j < timelogs[0].length; j++){

                    if(startday == 6 || startday == 7){
                    }

                    else if(timelogs[i][j] > schedules[i]){
                        answer--;
                        startday = initDay;
                        break;
                    }

                    startday = (startday % 7) + 1;
                }
            }

            return answer;
        }
    }
}
