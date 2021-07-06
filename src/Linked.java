public class Linked {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int n=3,m=4;
        LinkedNode linkedNode = new LinkedNode();
        for (int i = m+n-1; i < arr.length; i++) {
            linkedNode.add(arr[i]);
        }
        for (int i = n; i < m+n-1; i++) {
            linkedNode.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            linkedNode.add(arr[i]);
        }
        Node temp = linkedNode.head.next;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}

class LinkedNode {
    public Node head = new Node(0);

    public void add(int num){
        Node newnode = new Node(num);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=newnode;
    }
}
class Node{
    public int val;
    public Node next=null;

    public Node(int val) {
        this.val = val;
    }
}