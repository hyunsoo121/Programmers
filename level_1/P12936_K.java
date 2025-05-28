import java.util.*;

public class P12936_K {
    class Solution {
        int n;
        long k;
        long count = 0;
        boolean[] visited;
        int[] result;

        public int[] solution(int n, long k) {
            this.n = n;
            this.k = k;
            this.visited = new boolean[n];
            this.result = new int[n];

            dfs(new ArrayList<>(), 0);

            return result;
        }

        public void dfs(ArrayList<Integer> numList, int depth) {
            if (count >= k)
                return;

            if (depth == n) {
                count++;
                if (count == k) {
                    for (int i = 0; i < n; i++) {
                        result[i] = numList.get(i);
                    }
                }
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    numList.add(i + 1);
                    dfs(numList, depth + 1);
                    numList.remove(numList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

}
