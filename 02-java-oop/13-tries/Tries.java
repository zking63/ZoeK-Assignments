import java.security.Key;

public class Tries {
    public Node root;
    
    public Tries() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter); //is "get" a method already?
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public void isPrefixValid(String prefix){
		for(int i = 0; i < prefix.length(); i++) {
            Character currentLetter = prefix.charAt(i);
            Node child = this.root.children.get(currentLetter);
			if(child.value == currentLetter) {
                currentLetter++;
                System.out.println("it worked");
			}
		}
        /*for (int i = 0; i < prefix.length(); i++){
            if (prefix.charAt(i) == this.root){
                System.out.println("worked");
                return;
            }
            else {
                System.out.println("didn't work");
                return;
            }
        }
        /*Set<Character> keys = trie.root.children.keySet();
        for (Character key : keys) {
            if (prefix.charAt(i) == trie.root.children.keySet()){
                System.out.println("worked");
                return;
            }
            else {
                System.out.println("didn't work");
                return;
            }
        }*/
    }
}