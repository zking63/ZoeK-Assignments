public class CalculatorTest {
    public static void main(String[] args){
        Calculator answer = new Calculator();
        Calculator answer2 = new Calculator();

        answer.setNumber1(10);
        answer.setNumber2(10);
        answer.setOperation("+");

        System.out.println(answer.getResult());

        answer2.setNumber1(6);
        answer2.setNumber2(5);
        answer2.setOperation("-");

        System.out.println(answer2.getResult());
    }
}