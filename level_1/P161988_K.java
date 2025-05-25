public class P161988_K {
    class Solution {
        public long solution(int[] sequence) {

            long[] arr1 = new long[sequence.length];
            long[] arr2 = new long[sequence.length];

            long perse = 1;

            for (int i = 0; i < sequence.length; i++) {
                arr1[i] = sequence[i] * perse;
                arr2[i] = sequence[i] * -perse;
                perse *= -1;
            }

            long max = Math.max(getMax(arr1), getMax(arr2));

            return max;
        }

        private long getMax(long[] arr) {
            long max = arr[0];
            long current = arr[0];

            for (int i = 1; i < arr.length; i++) {
                current = Math.max(arr[i], current + arr[i]);
                max = Math.max(max, current);
            }

            return max;
        }
    }
}
