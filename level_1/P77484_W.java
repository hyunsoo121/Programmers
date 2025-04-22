import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> my=new ArrayList<>();
        ArrayList<Integer> target=new ArrayList<>();
        int[] answer = new int[2];
        for(int key : lottos) my.add(key);
        for(int key : win_nums) target.add(key);
        int cnt=0; int zero_cnt=0;
        for(int t : my)
        {
            if(target.contains(t)) cnt++;
            if(t==0) zero_cnt++;
        }
            answer[0]=loto_ranking(cnt,zero_cnt);
            answer[1]=loto_ranking(cnt,0);
        return answer;
    }
    public static int loto_ranking(int cnt,int zero_cnt)
    {
        cnt+=zero_cnt;
        if(cnt==6) return 1;
        else if(cnt==5) return 2;
        else if(cnt==4) return 3;
        else if(cnt==3) return 4;
        else if(cnt==2) return 5;
        else return 6;
    }
}