import java.util.*;

public class P12978_K {

    class Solution {
        public int solution(int N, int[][] road, int K) {
            int answer = 0;

            ArrayList<Node> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new Node(i));
            }

            for (int[] r : road) {
                int from = r[0];
                int to = r[1];
                int dist = r[2];

                list.get(from).setRoad(to, dist);
                list.get(to).setRoad(from, dist);
            }

            int[] distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[1] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{1, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int nowTown = cur[0];
                int distSoFar = cur[1];

                if (distSoFar > distance[nowTown]) continue;

                for (int nextTown : list.get(nowTown).road.keySet()) {
                    int nextDist = list.get(nowTown).road.get(nextTown);

                    if (distance[nextTown] > distSoFar + nextDist) {
                        distance[nextTown] = distSoFar + nextDist;
                        pq.offer(new int[]{nextTown, distance[nextTown]});
                    }
                }

            }

            for (int i = 1; i <= N; i++) {
                if (distance[i] <= K) answer++;
            }

            return answer;
        }

        class Node {
            int start;
            HashMap<Integer, Integer> road = new HashMap<>();

            public Node(int start) {
                this.start = start;
            }

            public void setRoad(int end, int distance) {
                road.put(end, Math.min(road.getOrDefault(end, Integer.MAX_VALUE), distance));
            }
        }
    }
}
