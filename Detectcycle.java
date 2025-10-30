package _9_LinkedList2;

public class Detectcycle {
    static class Node {
        int data; 
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node head;
    public static Node tail;

    // Detect if the linked list has a cycle
    public boolean iscycle(){ 
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }

    // Remove cycle if present
    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycleDetected = false;

        // Detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleDetected = true;
                break;
            }
        }

        if (!cycleDetected) {
            System.out.println("No cycle detected");
            return;
        }

        // Find the start of the cycle
        slow = head;
        
        // Special case: cycle starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            System.out.println("Cycle removed");
            return;
        }

        // General case
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        System.out.println("Cycle removed");
    }

    public static void main(String[] args) {
        Detectcycle lst = new Detectcycle();
        
        head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        
        head.next = node2;
        node2.next = node3;
        node3.next = head; // Creates a cycle
        
        System.out.println("Cycle detected? " + lst.iscycle());  // Should print true
        lst.removeCycle();
        System.out.println("Cycle detected after removal? " + lst.iscycle()); // Should print false
    }
}
