import java.util.*;
public class P42840_W {
class Solution {
    public int[] solution(int[] answers) {
        int cnt1=0; int cnt2=0; int cnt3=0;
        int[] math_g1=new int[] {1,2,3,4,5};
        int[] math_g2=new int[] {2,1,2,3,2,4,2,5};
        int[] math_g3=new int[] {3,3,1,1,2,2,4,4,5,5};
        for(int i=0;i<answers.length;i++)
        {
            int give_up1=i%math_g1.length;
            int give_up2=i%math_g2.length; int give_up3=i%math_g3.length;
            if(answers[i]==math_g1[give_up1]) cnt1++;
            if(answers[i]==math_g2[give_up2]) cnt2++;
            if(answers[i]==math_g3[give_up3]) cnt3++;
        }
        ArrayList<student> al=new ArrayList<>();
        al.add(new student(1,cnt1)); al.add(new student (2,cnt2));
        al.add(new student (3,cnt3));
        Collections.sort(al,new mycomparator());
        int max_value=al.get(0).score;
        int distance=0;
        for(student node : al)
        {
            int correct=node.score;
            if(max_value==correct) distance++;
        }
        int[] answer = new int[distance];
        for(int i=0;i<distance;i++)
        {
            int node=al.get(i).student_id;
            answer[i]=node;
        }
        return answer;
    }
    
    class student
    {
        int student_id;
        int score;
        student(int student_id,int score)
        {
            this.student_id=student_id;
            this.score=score;
        }
    }
    
    class mycomparator implements Comparator<student>
    {
        
        public int compare(student s1,student s2) 
    {
        return Integer.compare(s2.score, s1.score);
    }
    }
}
    
}
