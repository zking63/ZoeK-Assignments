import java.util.Set;
public class TriesTest {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");

        System.out.println(trie.isPrefixValid("chi"));
        System.out.println(trie.isPrefixValid("zz"));
        System.out.println(trie.isWordValid("chip"));
        System.out.println(trie.isWordValid("pop"));

        trie.printAllKeys();
        //Set<Character> keys = trie.root.children.keySet();
        //System.out.println(trie.root.children.get('c').children.keySet());
        //System.out.println("The set is: " + entrySet());
    }
}