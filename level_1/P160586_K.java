public class P160586_K {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            int countAll = 0, count = 100;
            char button[][] = new char[keymap.length][];

            for(int i = 0; i < keymap.length; i++){
                button[i] = keymap[i].toCharArray();
            }

            for(int i = 0; i < targets.length; i++){
                for(char c : targets[i].toCharArray()){
                    for(char[] findArr : button){
                        for(int j = 0; j < findArr.length; j++){
                            if(findArr[j] == c){
                                count = (count > j) ? j : count;
                                break;
                            }
                        }
                    }

                    if(count == 100){
                        countAll = -1;
                        break;
                    }

                    countAll += count+1;

                    count = 100;
                }
                answer[i] = countAll;
                countAll = 0;
            }

            return answer;
        }
    }

}
