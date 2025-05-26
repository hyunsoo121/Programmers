public class P12971_K {
    class Solution {
        public int solution(int sticker[]) {
            int n = sticker.length;

            int max = 0;
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            if (n == 1) {
                return sticker[0];
            }

            if (n == 2) {
                return Math.max(sticker[0], sticker[1]);
            }

            arr1[0] = sticker[0];
            arr1[1] = Math.max(sticker[0], sticker[1]);

            arr2[0] = 0;
            arr2[1] = sticker[1];

            for (int i = 2; i < n - 1; i++) {
                arr1[i] = Math.max(arr1[i - 1], arr1[i - 2] + sticker[i]);
            }


            for (int i = 2; i < n; i++) {
                arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + sticker[i]);
            }

            max = Math.max(arr1[n - 2], arr2[n - 1]);

            return max;
        }
    }
}
