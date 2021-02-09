public class FizzBuzzTest {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            FizzBuzz result = new FizzBuzz();
            String result2 = result.FizzBuzz(i);
            String output = String.format("Number: %d Result: %s", i, result2);
            System.out.println(output);
        }
    }
}