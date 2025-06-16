public class P68645_K {
    class Solution {
        public int[] solution(int n) {
            int[][] arr = new int[n][n];
            int num = 1;
            int direction = 0;

            for (int i = 0, x = -1, y = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (direction == 0) {
                        x++;
                    }
                    else if (direction == 1) {
                        y++;
                    }
                    else if (direction == 2) {
                        x--;
                        y--;
                    }
                    arr[x][y] = num++;
                }
                direction = (direction + 1) % 3;
            }

            int[] answer = new int[n * (n + 1) / 2];

            num = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    answer[num++] = arr[i][j];
                }
            }

            return answer;
        }
    }

}
