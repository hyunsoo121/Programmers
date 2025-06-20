import java.util.*;

public class P1844_K {
    class Solution {
        public int solution(int[][] maps) {
            int answer = 0;

            boolean[][] visited = new boolean[maps.length][maps[0].length];
            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{0, 0});

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            visited[0][0] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length){
                        if(!visited[nx][ny] && maps[nx][ny] != 0){
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                        }
                    }
                }
            }

            if(maps[maps.length - 1][maps[0].length - 1] == 1){
                return -1;
            }

            return maps[maps.length - 1][maps[0].length - 1];
        }
    }
}
