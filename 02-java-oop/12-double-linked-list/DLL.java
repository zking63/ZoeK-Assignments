public class DLL {
    public Node head;
    public Node tail; //when do you initialize values and when do you not? there's no rule for this. problems with making everything universal is if you need to reset between methods.
    public Node current; 
    public int counter = 0;

    public DLL() { //why do we need to set them to null? placeholder, reference point, otherwise you wouldn't know when it started/ended
        this.head = null; 
        this.tail = null;
    }
    
    //new node to the end of the list
    public void push(Node newNode){
        //if no head
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        //link the list, set last node as last, set new node as next, set last node as previous, set new node as tail
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode; //why write "this" here? not 100% necessary, just in case there are parameters in the constructor
    }
    //print forward
    public void printValuesForward(){
        current = this.head;
        while (current != null){
            System.out.println(current.value); //why doesn't "this.value" work? this.value is value of the node; node belongs to this head; current.value is referencing whatever node we are on.
            current = current.next; 
        }
    }

    //print backward
    public void printValuesBackward(){
        current = this.tail;
        while (current != null){
            System.out.println(current.value); //why doesn't "this.value" work? this is like folders, you have to get to the node first before opening it
            current = current.previous; 
        }
    }

    public Node pop(){
        Node temp = this.tail;
        Node lastNode = this.tail;
        this.tail = lastNode.previous;
        this.tail.next = null; //why doesn't lastNode = null work?, because you've defined it as this.tail and then overwritten it
        return temp;
    }

    public boolean contains(Integer value1){
        current = this.head;
        while (current != null){
            if (current.value == value1){
                System.out.println("Value found!");
                return true;
            }
            current = current.next;
        }
        System.out.println("Value not found!");
        return false;
    }
    public int size(){
        current = this.head;
        while (current != null){
            counter++;
            current = current.next;
        }
        return counter;
    }
}