import java.util.*;

public class P42861_W {
    class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] c : costs) 
        {          // 양방향 간선 삽입
            adj.get(c[0]).add(new int[]{c[1], c[2]});
            adj.get(c[1]).add(new int[]{c[0], c[2]});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [정점, 비용]
        pq.offer(new int[]{0, 0});      // 임의의 시작 섬 0, 비용 0

        int picked = 0;                 // 트리에 편입된 섬 수
        while (!pq.isEmpty() && picked < n) 
        {
            int[] cur = pq.poll();
            int v = cur[0], w = cur[1];

            if (visited[v]) continue;   // 이미 트리에 포함된 섬이면 스킵
            visited[v] = true;
            answer += w;                // 트리에 새로 편입될 때 드는 비용 누적
            picked++;

            // v에서 이어지는 간선을 PQ에 추가
            for (int[] next : adj.get(v)) {
                if (!visited[next[0]]) pq.offer(next);
            }
        }
        return answer;
    }
}
}
