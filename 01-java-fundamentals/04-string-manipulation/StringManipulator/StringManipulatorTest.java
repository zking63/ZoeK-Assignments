public class StringManipulatorTest {
    public static void main(String[] args) {
        StringManipulator result = new StringManipulator();
        String str = result.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);

        char letter = 'o';
        Integer a = result.getIndexOrNull("Coding", letter);
        Integer b = result.getIndexOrNull("Hello World", letter);
        Integer c = result.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = result.getIndexOrNull(word, subString);
        Integer e = result.getIndexOrNull(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null

        String stringBig = result.concatSubstring("Hello", 1, 2, "world");
        System.out.println(stringBig);
    }
}