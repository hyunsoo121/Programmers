
import java.util.*;

public class P67258_K {
    class Solution {
        public int[] solution(String[] gems) {

            int start = 0, end = 0;
            HashSet<String> gemSet = new HashSet<>();

            for(String s : gems){
                gemSet.add(s);
            }

            for(int i = gemSet.size(); i <= gems.length; i++){
                HashSet<String> buyGem = new HashSet<>();
                for(int j = 0; j <= gems.length - i; j++){
                    for(int k = j; k < j + i; k++){
                        buyGem.add(gems[k]);
                    }

                    if(buyGem.size() == gemSet.size()){
                        start = j + 1;
                        end = j + i;
                        break;
                    }

                    buyGem.clear();
                }
                if(start != 0)
                    break;
            }
            int[] answer = {start, end};
            return answer;
        }
    }
}
