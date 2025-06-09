import java.util.*;
public class P1844_W {
    class Solution {
        int[][] direction=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] maps) {
        int target_row=maps.length-1;
        int target_col=maps[0].length-1;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        queue.add(new int[]{0,0,1});
        while(!queue.isEmpty())
        {
            int[] temp=queue.poll();
            int cx=temp[0]; int cy=temp[1]; int count=temp[2];
            if(cx==target_row && cy==target_col)
            {
                return count;
            }
            for(int i=0;i<4;i++)
            {
                int nx=cx+direction[i][0];
                int ny=cy+direction[i][1];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length
                && maps[nx][ny]==1 &&!visited[nx][ny])
                {
                    visited[nx][ny]=true;
                    queue.add(new int[] {nx,ny,count+1});
                }
            }
        }
        return -1;
    }
}
}
