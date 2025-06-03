import java.util.*;
public class P169199_W {
class Solution {
    int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(String[] board) 
    {
        int target_row = 0, target_col = 0;
        int cur_row = 0, cur_col = 0;
        char[][] map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) 
        {
            String input = board[i];
            for (int j = 0; j < input.length(); j++) 
            {
                char c = input.charAt(j);
                map[i][j] = c;
                if (c == 'G') 
                {
                    target_row = i;
                    target_col = j;
                }
                if (c == 'R') {
                    cur_row = i;
                    cur_col = j;
                }
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cur_row, cur_col, 0});
        visited[cur_row][cur_col] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cx = temp[0], cy = temp[1], count = temp[2];
            if (cx == target_row && cy == target_col) 
            {
                return count;
            }

            for (int i = 0; i < 4; i++) 
            {
                int dx = direction[i][0];
                int dy = direction[i][1];
                int[] next = moving(cx, cy, dx, dy, map);
                int nx = next[0], ny = next[1];

                if (!visited[nx][ny]) 
                {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return -1;
    }

    int[] moving(int cx, int cy, int dx, int dy, char[][] map) {
        int nx = cx;
        int ny = cy;

        while (true) 
        {
            int tx = nx + dx;
            int ty = ny + dy;

            if (tx < 0 || tx >= map.length || ty < 0 || ty >= map[0].length) break;
            if (map[tx][ty] == 'D') break; // 장애물이 있으면 멈춤
            if (map[tx][ty] == '.' || map[tx][ty] == 'G' || map[tx][ty]=='R') 
            {
                nx = tx;
                ny = ty;
            } else {
                break;
            }
        }

        return new int[]{nx, ny};
    }
}
}
