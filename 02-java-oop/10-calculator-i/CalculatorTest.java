public class CalculatorTest {
    public static void main(String[] args){
        Calculator answer = new Calculator();

        answer.setNumber1(10);
        answer.setNumber2(10);
        answer.setOperation("+");

        System.out.println(answer.getResult());
    }
}