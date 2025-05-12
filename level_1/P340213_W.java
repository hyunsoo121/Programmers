public class P340213_W {
    class Solution {
    static int opening_e;
    static int opening_s;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb=new StringBuilder();
        String[] temp=video_len.split(":"); //video_len
        int total_len=Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); //전체 길이
        temp=pos.split(":"); //pos
        int start=Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); // 시작 재생위치
        temp=op_start.split(":"); //op_start
        opening_s=Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]); //오프닝 시작
        temp=op_end.split(":"); //op_end
        opening_e=Integer.parseInt(temp[0])*60 +Integer.parseInt(temp[1]); //오프닝 종료
        int current_time=start;
        current_time=in_or_not(current_time);
        for(String c : commands)
        {
            if(c.equals("next")) //10초 추가
            {
                current_time+=10;
            }
            else //10초 전
            {
                current_time-=10;
            }
            current_time=valid_time(current_time,total_len);
            current_time=in_or_not(current_time);
        }
        int h=current_time/60; int m=current_time%60;
        String hour=null; String minute=null;
        if(h<10) sb.append("0").append(h);
        else sb.append(h);
        hour=sb.toString();
        sb.setLength(0);
        
        if(m<10) sb.append("0").append(m);
        else sb.append(m);
        minute=sb.toString();
        sb.setLength(0);
        
        sb.append(hour).append(":").append(minute);
        return sb.toString();
    }
    public int in_or_not(int current_time)
    {
        if(current_time >=opening_s && current_time<=opening_e)
        {
            current_time=opening_e;
        }
        return current_time;
    }
    public int valid_time(int current_time,int total_len)
    {
        if(current_time%60>=60)
        {
            current_time+=100;
            current_time-=60;
        }
        if(current_time<0)
        {
            current_time=0;
        }
        
        if(current_time>total_len) current_time=total_len;
        return current_time;
    }
}
    
}
