import java.util.*;

public class P178871_K {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = {};

            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < players.length; i++){
                map.put(players[i], i);
            }

            for(int i = 0; i < callings.length; i++){

                int calledIdx = map.get(callings[i]);

                String frontPlayer = players[calledIdx - 1];
                players[calledIdx - 1] = callings[i];
                players[calledIdx] = frontPlayer;

                map.put(callings[i], calledIdx - 1);
                map.put(frontPlayer, calledIdx);
            }

            return players;
        }
    }
}
