public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        dll.printValuesBackward();

        //removes the last node of our DLL and returns it
        //dll.pop();
        System.out.println(dll.pop().value);

        //returns a boolean whether the value in the argument is in the list or not. Return true if the value exists, else, return false.
        dll.contains(50);
        dll.contains(20);
        dll.contains(11);
        dll.contains(100);

        //return number of nodes
        System.out.println(dll.size());
    }
}