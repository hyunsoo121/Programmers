import java.util.*;
public class P86971_K {

    class Solution {

        HashMap<Integer, Node> nodeList = new HashMap<>();

        public int solution(int n, int[][] wires) {
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < n - 1; i++) {
                if(!nodeList.containsKey(wires[i][0]))
                    nodeList.put(wires[i][0], new Node(wires[i][0]));
                if(!nodeList.containsKey(wires[i][1]))
                    nodeList.put(wires[i][1], new Node(wires[i][1]));
            }

            for(int i = 0; i < n - 1; i++) {
                int node1 = wires[i][0];
                int node2 = wires[i][1];

                nodeList.get(node1).edge.add(node2);
                nodeList.get(node2).edge.add(node1);
            }

            for(int i = 0; i < n - 1; i++) {
                int node1 = wires[i][0];
                int node2 = wires[i][1];

                nodeList.get(node1).edge.remove(Integer.valueOf(node2));
                nodeList.get(node2).edge.remove(Integer.valueOf(node1));

                boolean[] visited = new boolean[n];

                int treeA = dfs(nodeList.get(node1), visited);

                min = Math.min(min, Math.abs((n - treeA) - treeA));

                nodeList.get(node1).edge.add(node2);
                nodeList.get(node2).edge.add(node1);
            }
            return min;
        }

        public int dfs(Node node, boolean[] visited){
            visited[node.data - 1] = true;
            int count = 1;

            for(int edge : node.edge){
                if(!visited[edge - 1]){
                    count += dfs(nodeList.get(edge), visited);
                }
            }

            return count;
        }

        class Node {
            int data;
            ArrayList<Integer> edge = new ArrayList<>();

            Node(int data){
                this.data = data;
            }
        }
    }
}
