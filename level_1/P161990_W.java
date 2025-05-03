import java.util.*;
public class P161990_W {
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        ArrayList<int[]> al=new ArrayList<>();
        int row=0;
        for(String file : wallpaper){
            for(int col=0;col<file.length();col++)
            {
                if(file.charAt(col)=='#') al.add(new int[] {row,col});
            }
            row++;
        }
        int ldx=Integer.MAX_VALUE; int ldy=Integer.MAX_VALUE;
        int rdx=Integer.MIN_VALUE; int rdy=Integer.MIN_VALUE;
        for(int[] key : al)
        {
            ldx=Math.min(ldx,key[0]); ldy=Math.min(ldy,key[1]);
            rdx=Math.max(rdx,key[0]+1); rdy=Math.max(rdy,key[1]+1);
        }
        answer[0]=ldx; answer[1]=ldy; answer[2]=rdx; answer[3]=rdy;
        return answer;
    }
}
//빈칸은 . , 파일이 있는 칸은 #
//가장 위 + 가장 왼쪽 -> 가장 아래+1 + 가장 오른쪽+1
    
}
