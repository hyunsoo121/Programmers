public class P340213_K {
    class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = "";

            int pos_second = toSecond(pos);
            int op_start_second = toSecond(op_start);
            int op_end_second = toSecond(op_end);
            int video_len_second = toSecond(video_len);

            for(String s : commands){
                if(op_start_second <= pos_second && pos_second <= op_end_second)
                    pos_second = op_end_second;

                if(s.equals("next")){
                    pos_second += 10;
                }

                else if(s.equals("prev")){
                    pos_second -= 10;
                }

                if(pos_second < 10){
                    pos_second = 0;
                }

                if(pos_second > video_len_second - 10)
                    pos_second = video_len_second;

                if(op_start_second <= pos_second && pos_second <= op_end_second)
                    pos_second = op_end_second;
            }

            String minute = String.valueOf(pos_second / 60);
            String second = String.valueOf(pos_second % 60);

            if(second.length() == 1)
                second = "0" + second;

            if(minute.length() == 1)
                minute = "0" + minute;

            answer = minute + ":" + second;

            return answer;
        }

        int toSecond(String s){

            String[] timeArr = s.split(":");

            int time = Integer.parseInt(timeArr[0]) * 60
                    + Integer.parseInt(timeArr[1]);

            return time;
        }
    }
}
