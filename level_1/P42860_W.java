public class P42860_W {
    class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] alpha=name.toCharArray();
        int current=0; //현재 위치를 저장
        boolean[] visited=new boolean[alpha.length];
        for(int i=0;i<alpha.length;i++)
        {
            char cur_point=alpha[i];
            if(cur_point=='A') //현재 값이 A인 경우
            {
                visited[i]=true;
                continue;
            }
            else
            {

            }
        }
        return answer;
    }
    public int min_cursor(int target,int current,int n) //최소한의 커서 움직임 => 문제있으니 수정해야됨(지나가는 길에 있는걸 처리하지 못함)
    {
        int front=target-current;
        int back=n-front;
        return Math.min(front,back);
    }
    public int min_change(char target) //현재 얼마나 바꿔야지 최소인지
    {
        int front=target-'A';
        int back=26-front;
        // int current=0;
        // for(int i=0;i<25;i++)
        // {
        //     current-=1;
        //     if(current<0)
        //     {
        //         current+=26;
        //     }
        //     if(current==front) back=i+1;
        // }
        return Math.min(front,back);
    }
}
}
