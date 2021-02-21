import java.security.Key;
import java.util.Set;

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
            Node child = currentNode.children.get(currentLetter); //children is hashmap, this is asking if the currentLetter exists in children. there is an empty node before Node 1, that gets the current letter (c) and then c points to the Node 2 and then child would be Node 2.
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); //currentLetter is in Node 1 and point to the child node. even if it's only one letter you're adding in, it will still create a new node that it is pointing to, this new node will be boolean true for end of word. 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public boolean isPrefixValid(String prefix){
        Node currentNode = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            Character currentLetter1 = prefix.charAt(i);
            Node child = currentNode.children.get(currentLetter1);
                if (currentNode.children.containsKey(prefix.charAt(i))){ //root.children only touches on the top node, it works at charAt(0) bc it loops through characters not the nodes. 
                    System.out.println(prefix.charAt(i) + ": " + "yes");
                }
                else {
                    System.out.println(prefix.charAt(i) + ": " + "no");
                    return false;
                }
                currentNode = child;
            }
            return true;
        }
        /*for(int i = 0; i < prefix.length(); i++) {
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