import java.util.*;
public class P81303_W {
    class Solution {
        static Stack<Node> stack=new Stack<>(); //삭제된 요소 복구하는 queue
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb=new StringBuilder();
        ArrayList<Node> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Node temp=new Node(i); //새로운 node
            al.add(temp);
        }
        for(int i=0;i<n;i++)
        {
            if(al.get(i).num==0) //처음 node인 경우
            {
                al.get(i).next=al.get(i+1);
            }
            else if(i==n-1) //마지막 node인 경우
            {
                al.get(i).front=al.get(i-1);
            }
            else //이외의 경우
            {
                al.get(i).front=al.get(i-1);
                al.get(i).next=al.get(i+1);
            }
        }
        Node current=al.get(k); //현재 선택된 node를 저장
        for(String s : cmd)
        {
            String c; int move=0;
            if(s.charAt(0)=='U' || s.charAt(0)=='D')
            {
                String[] input=s.split(" ");
                c=input[0]; move=Integer.parseInt(input[1]);
                current=U_OR_D(current, c, move);
            }
            else if(s.charAt(0)=='C') //현재 선택된 행 삭제
            {
                current=delete(current);
            }
            else
            {
                restore(current);
            }
        }
        boolean[] exist=new boolean[n];
        Node temp=current; exist[temp.num]=true;
        while(temp.next!=null)
        {
            temp=temp.next;
            exist[temp.num]=true;
        }
        temp=current;
        while(temp.front!=null)
        {
            temp=temp.front;
            exist[temp.num]=true;
        }
        for(int i=0;i<n;i++)
        {
            if(exist[i]) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
    public Node U_OR_D(Node current,String c,int move)
    {
        if(c.equals("U")) //위로 이동
        {
            for(int i=0;i<move;i++) current=current.front;
        }
        else if(c.equals("D")) //아래로 이동
        {
            for(int i=0;i<move;i++) current=current.next;
        }
        return current;
    }
    public Node delete(Node current)
    {
        stack.push(current); //현재 노드를 stack에 넣어서 restore를 대비
        if(current.next==null) //마지막 노드인 경우
        {
            Node before=current.front;
            before.next=null;
            return before;
        }
        else if(current.front==null) //첫번째 노드인 경우
        {
            Node after=current.next;
            after.front=null;
            return after;
        }
        else
        {
            Node before=current.front;
            Node after=current.next;
            before.next=after;
            after.front=before;
            return after;
        }
    }
    public void restore(Node current)
    {
        Node restore_entity=stack.pop();
        Node before=restore_entity.front;
        Node after=restore_entity.next;
        if(before!=null) before.next=restore_entity;
        if(after!=null) after.front=restore_entity;
    }
    class Node
    {
        int num;
        Node front;
        Node next;
        Node(int num)
        {
            this.num=num;
        }
    }
}
}
// U X : 현재 선택된 행에서 X칸 위에 행 선택
// D X : X칸 아래 행 선택
// C : 현재 선택된 행 삭제, 바로 아래 행 선택
// Z : 가장 최근에 삭제된 행 복구