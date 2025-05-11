import java.util.*;

public class P250137_K {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int success = 0;
            int maxHealth = health;
            HashMap<Integer, Integer> attacksMap = new HashMap<>();

            for(int i = 0; i < attacks.length; i++){
                attacksMap.put(attacks[i][0], attacks[i][1]);
            }

            for(int i = 1; i < attacks[attacks.length - 1][0] + 1; i++){

                int attack = attacksMap.getOrDefault(i, 0);

                if(attack == 0){
                    success++;

                    health += bandage[1];
                }
                else {
                    success = 0;
                    health -= attack;
                }

                if(health <= 0){
                    health = -1;
                    break;
                }

                if(success == bandage[0]){
                    health += bandage[2];
                    success = 0;
                }


                if(health > maxHealth)
                    health = maxHealth;

            }
            return health;
        }
    }
}
