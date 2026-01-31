import java.util.*;
class Main {
   static Node head;
    public static void printll(){
        Node temp=head;
        while(temp!=null){
           System.out.print(temp.data);
           temp=temp.next;
            if(temp!=null){
            System.out.print("->");
        }
        }
       System.out.println();
    }
    public static void insertatend(String newdata){
       Node newnode= new Node(newdata);
       Node temp=head;
       if(head==null){
           head=newnode;
           return;
       }
       while(temp.next!=null){
         
           temp=temp.next;
       }
     
      temp.next=newnode;
    }
    public static void insertatstart(String newdata){
        Node newnode=new Node(newdata);
        newnode.next=head;
        head=newnode;
      
    }
    public static void insertatmiddle(String newdata,int targetidx){
       
         if(targetidx==0){
             insertatstart(newdata);
             return ;
        }
        Node newnode= new Node(newdata);
        Node temp=head;
        for(int i=0;i<targetidx-1;i++){
            if(temp==null){
                System.out.println("target idx greater then length of ll");
                return ;
            }
            temp=temp.next;
        }
      
      Node nextnode=temp.next;
      temp.next=newnode;
      newnode.next=nextnode;
      
    }
    public static void deleteatstart(){
        if(head==null){
            return;          // zero elements
        }
        head=head.next;
    }
    public static void deleteatend(){
        Node temp=head;
        if(temp==null){
            return;             // zero element
        }
        if(temp.next==null){
            head=null;           // 1 element
           return;
        }
        while(temp.next.next!=null){
            temp=temp.next;              // more than 1 element
        }
        temp.next=null;
    }
    public static void deleteatidx(int idx){
        if(idx==0){
            deleteatstart();
            return;
        }
        if(idx<0||head==null){
            return;
        }
        Node temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
            if(temp.next==null){
                System.out.println("index out of bound");
                return;
            }
        }
        temp.next=temp.next.next;
    }
     public static void deletebyvalue(String val){
        if(head.data.equals(val)){
            deleteatstart();
            return;
        }
        if(head==null){
            return;
        }
        Node temp=head;
       while(!temp.next.data.equals(val)){
            temp=temp.next;
            if(temp.next==null){
                System.out.println("index out of bound");
                return;
            }
        }
        temp.next=temp.next.next;
    }
    public static void revsersell(){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        head=prev;
    }
    public static boolean iscycle(){
        Node temp=head;
        HashSet<Node>hs=new HashSet<>();
        while(temp!=null){
            if(hs.contains(temp)){
                return true;
            }
            hs.add(temp);
            temp=temp.next;
        }
        return false;
    }
    
    public static boolean iscyclefloyd(){
        Node slow =head;
        Node fast=head;
        while(slow!=null&&fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static int iscyclefloydlen(){
        Node slow =head;
        Node fast=head;
        while(slow!=null&&fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
              int count=1;
              slow=slow.next;
              while(slow!=fast){
                  slow=slow.next;
                  count++;
              }
              return count;
            }
        }
      return 0; // if not found
    }
    public static void main(String[] args) {
    //   Node node1=new Node("a");
   
    //   head=node1;
      // insertatstart("a");
    //   printll();
      insertatend("a");
      insertatend("b");
      insertatend("c");
      head.next.next.next=head.next;  // for creating cycle
      
     // deleteatstart();
      //deleteatend();
     //deleteatidx(4);
    // deletebyvalue("a");
    //     printll();
    //  revsersell();
    //  // printll();
      //System.out.println(iscycle());
    System.out.println(iscyclefloyd());
     System.out.println(iscyclefloydlen());
    //   insertatstart("k");
    //   printll();
    //   insertatmiddle("rahul",3);
    //   printll();
    }
}
class Node{
    String data;
    Node next;
    Node(String data){
        this.data=data;
        this.next=null;
    }
}   