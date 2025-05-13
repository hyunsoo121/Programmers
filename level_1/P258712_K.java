import java.util.*;

public class P258712_K {

    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            ArrayList<User> users = new ArrayList<>();
            HashMap<String, Integer> userIdx = new HashMap<>();

            for(int i = 0; i < friends.length; i++){
                users.add(new User(friends[i]));
                userIdx.put(friends[i], i);
            }

            for(String s : gifts){
                String[] gift = s.split(" ");
                User giveUser = users.get(userIdx.get(gift[0]));
                User takeUser = users.get(userIdx.get(gift[1]));
                giveUser.giftMap.put(gift[1], giveUser.giftMap.getOrDefault(gift[1], 0) + 1);
                giveUser.giftPoint++;
                takeUser.giftPoint--;
            }

            int index = 1;

            for(User user : users){
                for(int i = index; i < users.size(); i++){
                    User user2 = users.get(i);

                    int userGift = user.giftMap.getOrDefault(user2.name, 0);
                    int user2Gift = user2.giftMap.getOrDefault(user.name, 0);

                    if(userGift > user2Gift)
                        user.nextMonthPoint++;

                    else if(userGift < user2Gift)
                        user2.nextMonthPoint++;

                    else{
                        if(user.giftPoint > user2.giftPoint)
                            user.nextMonthPoint++;
                        else if(user.giftPoint < user2.giftPoint)
                            user2.nextMonthPoint++;
                    }
                }
                index++;
            }

            for(User user : users){
                if(answer < user.nextMonthPoint)
                    answer = user.nextMonthPoint;
            }

            return answer;
        }
    }

    class User{
        String name;
        HashMap<String, Integer> giftMap;
        int giftPoint;
        int nextMonthPoint;

        public User(String name){
            giftMap = new HashMap<>();
            giftPoint = 0;
            this.name = name;
            nextMonthPoint = 0;
        }
    }
}
