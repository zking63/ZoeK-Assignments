import java.util.Set;
public class TriesTest {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
        Set<Character> keys = trie.root.children.keySet(); //why is the keyset() up here?
        for (Character key : keys) {
            System.out.println(keys);
        }

        trie.isPrefixValid("ch");
    }
}