import java.util.*;
public class P42892_W {
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<node> al=new ArrayList<>(); //좌표와 노드 번호가 주어짐
        for(int i=0;i<nodeinfo.length;i++)
        {
            int[] temp=new int[3];
            for(int j=0;j<2;j++)
            {
                temp[j]=nodeinfo[i][j];
            }
            temp[2]=i+1;
            node n1=new node(temp[0],temp[1],temp[2]);
            al.add(n1);
        }
        Collections.sort(al, (a,b) -> {
            if(a.y!=b.y)
            {
                return Integer.compare(b.y,a.y);
            }
            else
            {
                return Integer.compare(a.x,b.x);
            }
        });
        node root=al.get(0); //root노드 정의
        for(int i=1;i<al.size();i++)
        {
            insert(root,al.get(i));
        }
        
        ArrayList<Integer> post=new ArrayList<>(); //후위 탐색
        ArrayList<Integer> pre=new ArrayList<>(); //전위 탐색
        
        preorder(root,pre);
        postorder(root,post);
        
        int[][] answer=new int[2][al.size()];
        for(int i=0;i<al.size();i++)
        {
            answer[0][i]=pre.get(i);
            answer[1][i]=post.get(i);
        }
        return answer;
    }
    
    void insert(node parent,node child) 
    {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    void preorder(node node, ArrayList<Integer> result)
    {
        if(node==null) return;
        result.add(node.num);
        preorder(node.left,result);
        preorder(node.right,result);
    }
    void postorder(node node,ArrayList<Integer> result)
    {
        if(node==null) return;
        postorder(node.left,result);
        postorder(node.right,result);
        result.add(node.num);
    }
    class node{
        int num;
        int x; int y;
        node left; node right;
        
        node(int x,int y,int num)
        {
            this.x=x; this.y=y; this.num=num;
        }
    }
}
}
