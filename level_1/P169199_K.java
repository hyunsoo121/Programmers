import java.util.*;
public class P169199_K {

    class Solution {
        public int solution(String[] board) {
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            int[] start = new int[2];
            int[] goal = new int[2];

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length(); j++){
                    if(board[i].charAt(j) == 'R'){
                        start[0] = i;
                        start[1] = j;
                    }

                    if(board[i].charAt(j) == 'G'){
                        goal[0] = i;
                        goal[1] = j;
                    }
                }
            }

            boolean[][] visited = new boolean[board.length][board[0].length()];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{start[0], start[1], 0});
            visited[start[0]][start[1]] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                if(cur[0] == goal[0] && cur[1] == goal[1])
                    return cur[2];

                for(int i = 0; i < 4; i++){
                    int nx = cur[0];
                    int ny = cur[1];

                    while(nx >= 0 && ny >= 0 && ny < board[0].length() && nx < board.length
                            && board[nx].charAt(ny) != 'D'){
                        nx += dx[i];
                        ny += dy[i];
                    }

                    nx -= dx[i];
                    ny -= dy[i];

                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }


            return -1;
        }
    }
}
