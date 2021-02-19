public class Calculator2Test {
    public static void main(String[] args){
        Calculator2 answer = new Calculator2();
        Calculator2 answer2 = new Calculator2();

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