import java.util.*;

public class P81303_K {

    class Solution {
        public String solution(int n, int k, String[] cmd) {
            boolean[] isDelete = new boolean[n];
            Stack<Integer> tableZ = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int cur = k;

            for (String s : cmd) {
                String[] cmdArr = s.split(" ");
                String op = cmdArr[0];

                if (op.equals("D")) {
                    int move = Integer.parseInt(cmdArr[1]);
                    while (move > 0) {
                        cur++;
                        if (cur >= n) break;
                        if (!isDelete[cur]) move--;
                    }
                }

                else if (op.equals("U")) {
                    int move = Integer.parseInt(cmdArr[1]);
                    while (move > 0) {
                        cur--;
                        if (cur < 0) break;
                        if (!isDelete[cur]) move--;
                    }
                }

                else if (op.equals("C")) {
                    isDelete[cur] = true;
                    tableZ.push(cur);
                    int next = cur + 1;
                    while (next < n && isDelete[next]) next++;
                    if (next < n) {
                        cur = next;
                    }
                    else {
                        int prev = cur - 1;
                        while (prev >= 0 && isDelete[prev]) prev--;
                        cur = prev;
                    }
                }

                else if (op.equals("Z")) {
                    int restore = tableZ.pop();
                    isDelete[restore] = false;
                }
            }

            for (int i = 0; i < n; i++) {
                if(isDelete[i])
                    sb.append("X");
                else
                    sb.append("O");
            }

            return sb.toString();
        }
    }
}
