public class P161990_K {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int left = wallpaper[0].length(), right = 0;
            int top = -1, bottom = -1;

            char[][] arr = new char[wallpaper.length][wallpaper[0].length()];

            for (int i = 0; i < wallpaper.length; i++) {
                arr[i] = wallpaper[i].toCharArray();
            }

            for (int i = 0; i < wallpaper.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '#') {
                        if (top == -1)
                            top = i;
                        bottom = i + 1;

                        if (j < left)
                            left = j;
                        if (j + 1 > right)
                            right = j + 1;
                    }
                }
            }

            int[] result = {top, left, bottom, right};
            return result;
        }
    }
}
