import java.util.*;
public class P64061_W {
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<moves.length;i++)
        {
            int current=moves[i]-1; //현재 뽑힌 순서
            for(int j=0;j<board.length;j++)
            {
                if(board[j][current]!=0) //0이 아닌경우
                {
                    int doll=board[j][current];
                    board[j][current]=0;
                    if(!stack.isEmpty() &&stack.peek()==doll)
                    {
                        stack.pop();
                        answer+=2;
                    }
                    else
                    {
                        stack.push(doll);
                    }
                    break;
                }
            }
    }
        return answer;
}
}
//stack 사용
    
}
