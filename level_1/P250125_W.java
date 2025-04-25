public class P250125_W {
    class Solution {
        int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        public int solution(String[][] board, int h, int w) {
            int answer = 0;
            String target=board[h][w]; //target 블럭
            int len=board.length; //한번의 길이
            for(int i=0;i<4;i++)
            {
                int temp_h=h+direction[i][0];
                int temp_w=w+direction[i][1];
                if(temp_h>=0 && temp_h<len && temp_w>=0 && temp_w<len)
                {
                    if(board[temp_h][temp_w].equals(target)) answer++;
                }
            }
            return answer;
        }
    }
}
