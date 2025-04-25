import java.util.*;
public class P42576_K {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Arrays.sort(participant);
            Arrays.sort(completion);

            HashMap<Integer, String> participantMap = new HashMap<>();
            HashMap<Integer, String> completionMap = new HashMap<>();

            for(int i = 0; i < participant.length; i++){
                participantMap.put(i, participant[i]);
            }

            for(int i = 0; i < completion.length; i++){
                completionMap.put(i, completion[i]);
            }

            for(int i = 0; i < participant.length; i++){
                if(!participantMap.get(i).equals(completionMap.get(i))){
                    answer = participantMap.get(i);
                    break;
                }
            }

            return answer;
        }
    }
}
