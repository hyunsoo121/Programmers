public class P172928_K {
    class Solution {
        public int[] solution(String[] park, String[] routes) {

            int w = -1, h = -1;
            for(int i = 0; i < park.length; i++){
                for(int j = 0; j < park[0].length(); j++){
                    if(park[i].charAt(j) == 'S'){
                        w = j;
                        h = i;
                        break;
                    }
                }

                if(w != -1)
                    break;
            }

            for(String s : routes){
                String[] route = s.split(" ");

                int distance = Integer.parseInt(route[1]);
                boolean isPossible = true;

                if(route[0].equals("E")){
                    if(w + distance >= park[0].length())
                        continue;

                    for(int i = w + 1; i <= w + distance; i++){
                        if(park[h].charAt(i) == 'X'){
                            isPossible = false;
                            break;
                        }
                    }

                    if(isPossible)
                        w += distance;
                }

                else if(route[0].equals("W")){
                    if(w - distance < 0)
                        continue;

                    for(int i = w - 1; i >= w - distance; i--){
                        if(park[h].charAt(i) == 'X'){
                            isPossible = false;
                            break;
                        }
                    }

                    if(isPossible)
                        w -= distance;
                }

                else if(route[0].equals("S")){
                    if(h + distance >= park.length)
                        continue;

                    for(int i = h + 1; i <= h + distance; i++){
                        if(park[i].charAt(w) == 'X'){
                            isPossible = false;
                            break;
                        }
                    }

                    if(isPossible)
                        h += distance;
                }

                else if(route[0].equals("N")){
                    if(h - distance < 0)
                        continue;

                    for(int i = h - 1; i >= h - distance; i--){
                        if(park[i].charAt(w) == 'X'){
                            isPossible = false;
                            break;
                        }
                    }

                    if(isPossible)
                        h -= distance;
                }
            }

            int[] answer = {h, w};
            return answer;
        }
    }
}
