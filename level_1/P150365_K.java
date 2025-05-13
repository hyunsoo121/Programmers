public class P150365_K {
    class Solution {
        static boolean[][] maze;
        static char[] way = {'d', 'l', 'r', 'u'};

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            String answer = "";

            maze = new boolean[n][m];

            maze[r-1][c-1] = true;

            StringBuilder sb = new StringBuilder();

            answer = out(k, x-1, y-1, sb);

            if(answer == null){
                answer = "impossible";
            }
            return answer;
        }

        public String out(int k, int x, int y, StringBuilder direction) {
            if (k == 0) {
                if (maze[x][y]) return direction.toString();
                return null;
            }

            for (char c : way) {
                int nx = x, ny = y;

                if (c == 'd' && x + 1 < maze.length)
                    nx++;
                else if (c == 'l' && y - 1 >= 0)
                    ny--;
                else if (c == 'u' && x - 1 >= 0)
                    nx--;
                else if (c == 'r' && y + 1 < maze[0].length)
                    ny++;
                else
                    continue;

                direction.append(c);

                String result = out(k - 1, nx, ny, direction);

                if (result != null){
                    return result;
                }

                direction.deleteCharAt(direction.length() - 1);
            }

            return null;
        }
    }
}
