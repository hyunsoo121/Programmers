import java.util.*;
public class P64061_K {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            ArrayList<Integer> basket = new ArrayList<>();

            for (int i : moves) {
                for (int j = 0; j < board.length; j++) {
                    int doll = board[j][i - 1];
                    if (doll != 0) {
                        board[j][i - 1] = 0;

                        int size = basket.size();
                        if (size > 0 && basket.get(size - 1) == doll) {
                            basket.remove(size - 1);
                            answer += 2;
                        } else {
                            basket.add(doll);
                        }

                        break;
                    }
                }
            }

            return answer;
        }
    }
}
