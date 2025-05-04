import java.util.*;
public class P150370_W {

class Solution {
    static int[] Today = new int[3]; // 오늘 날짜 저장

    public int[] solution(String today, String[] terms, String[] privacies) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        today=today.replace(".", " ");
        String[] temp=today.split(" ");

        Today[0] = Integer.parseInt(temp[0]);
        Today[1] = Integer.parseInt(temp[1]);
        Today[2] = Integer.parseInt(temp[2]);

        for (String term : terms) 
        {
            String[] input = term.split(" ");
            hm.put(input[0], Integer.parseInt(input[1]));
        }

        for (int i = 0; i < privacies.length; i++) 
        {
            String[] input = privacies[i].split(" ");
            input[0]=input[0].replace(".", " ");
            String[] dateParts = input[0].split(" ");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int termMonths = hm.get(input[1]);
            if (shouldRemove(year, month, day, termMonths)) 
            {
                al.add(i + 1);
            }
        }

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
        {
            answer[i] = al.get(i);
        }

        return answer;
    }
    boolean shouldRemove(int year, int month, int day, int termMonths) 
    {
        // 개인정보 만료일 = 수집일 + term개월
        int expireDate = toDays(year, month + termMonths, day);
        int todayDate = toDays(Today[0], Today[1], Today[2]);

        return todayDate >= expireDate;
    }
    int toDays(int year, int month, int day) 
    {
        year += (month - 1) / 12;
        month = (month - 1) % 12 + 1;
        return year * 12 * 28 + month * 28 + day;
    }
}
}
