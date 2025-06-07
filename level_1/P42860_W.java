public class P42860_W {
        class Solution {
        public int solution(String name) {
            int answer = 0;
            int len = name.length();
            int move = len - 1;

            // 1. 알파벳 바꾸는 횟수 계산
            for (int i = 0; i < len; i++) {
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

                // 2. A 연속 구간 고려한 최소 이동 횟수 계산
                int next = i + 1;
                while (next < len && name.charAt(next) == 'A') {
                    next++;
                }

                // 좌우로 돌아가는 최적 경로 계산
                move = Math.min(move, i * 2 + len - next); // 오른쪽 갔다가 왼쪽
                move = Math.min(move, (len - next) * 2 + i); // 왼쪽 갔다가 오른쪽
            }

            answer += move;
            return answer;
        }
    }

}
