public class P68645_W {
    class Solution {
        int[][] direction=new int[][] {{1,0},{0,1},{-1,-1}};
    public int[] solution(int n) {
        int result=n*(n+1)/2; //마지막 숫자
        int[][] map=new int[n][n];
        map[0][0]=1; int dir=0;
        int current_row=0; int current_col=0;
        for(int i=2;i<=result;i++)
        {
            int row=direction[dir][0];
            int col=direction[dir][1];
            if(current_row+row<n && current_row+row>=0 && current_col+col<n && current_col+col>=0
            && map[current_row+row][current_col+col]==0)
            {
                current_row+=row;
                current_col+=col;
                map[current_row][current_col]=i;
            }
            else
            {
                dir=(dir+1)%3;
                i--;
            }
        }
        int[] answer=new int[result];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                if(map[i][j]!=0)
                {
                    answer[cnt]=map[i][j];
                    cnt++;
                }
            }
        }
        return answer;
    }
}
}
