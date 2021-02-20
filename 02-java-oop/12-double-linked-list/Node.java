public class Node {
    public Integer value; 
    public Node previous;
    public Node next;
    
    public Node(Integer val) { 
        this.value = val;
        this.previous = null; //why do you have to set these to null
        this.next = null;
    }
}