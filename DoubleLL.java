package _9_LinkedList2;

public class DoubleLL {
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int  size;

    //add
    public void addfirst(int data){
        Node newnode= new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    //remove
    public int removefirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size ==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val= head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    }
    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr !=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }
        head=prev;
    }
    
    //print
    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        dll.print();
        dll.reverse();
        dll.print();
        System.out.println(dll.size);
    }
  
}
