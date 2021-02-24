import java.security.Key;
import java.security.KeyStore.Entry;
import java.util.Set;
import java.util.HashMap;

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
                currentNode.children.put(currentLetter, child); //currentLetter is in Node 1 and points to the child node. even if it's only one letter you're adding in, it will still create a new node that it is pointing to, this new node will be boolean true for end of word. 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    public boolean isPrefixValid(String prefix){
        Node currentNode = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            Character currentLetter = prefix.charAt(i);
            Node child = currentNode.children.get(currentLetter);
            if (child == null){ //root.children only touches on the top node; this seems to works when you put charAt(0) bc it loops through characters not the nodes. 
                return false;
            }
            currentNode = child;
        }
        return true;
    }
    public boolean isWordValid(String word){
        Node currentnode = this.root;
        for (int i = 0; i < word.length(); i++){
            Character currentLetter = word.charAt(i);
            Node child = currentnode.children.get(currentLetter);
            if (child == null){
                return false;
            }
            currentnode = child;
        }
        return currentnode.isCompleteWord;
    }
    public void printAllKeys(){
        Set<Character> keys = root.children.keySet(); //get node and set another to current, if there is a child and if it is null return, if not iterate through keys and print value
        for(Character key : keys){ 
            System.out.println(key);
            System.out.println(root.children.get(key).children.keySet());
            Set<Character> child = root.children.get(key).children.keySet();
            for(Character key1 : child){
                System.out.println(root.children.get(key1).children.keySet());
            }
        }
    }
}