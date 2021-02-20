import java.util.ArrayList;

public class Calculator2 implements java.io.Serializable {
    private double number1;
    private double number2;
    //private double input;
    private Double result;
    private String operation;
    //private ArrayList numbers = new ArrayList<Double>();
    private double[] numbers;

    public Calculator2() {
	}

    /*public void setNumber1(double number){
        number1 = number;
    }
    public void setNumber2(double number2){
        this.number2 = number2;
    }*/
    public void setInput(Double[] inputs){
        for (int i = 0; i < inputs.length; i++){
            //numbers.add(i);
            this.numbers[i] = inputs[i]; //getting null pointer error, why?
        }
    }
    /*public void setOperation(String operation){
        this.operation = operation;
    }
    public double getNumber1(){
        return this.number1;
    }
    public double getNumber2(){
        return this.number2;
    }*/
    public double[] getInput(){
        return numbers;
    }
    /*public String getOperation(){
        return this.operation;
    }*/
    /*public ArrayList<double> getArray(){
        double n=0;
        while (numbers.hasNext()) {
            try {
                n = Integer.parseInt(numbers.nextLine());
                List.push(n);
            } catch (NumberFormatException nfe) { 
                System.out.println("problem");
            }
       }
    }*/

    public Double getResult(){
        for (Double number : numbers) {
            if (this.operation == "+"){ 
                result = result + number; 
            }
        }
        /*if (this.operation == "-"){
            result = number1 - number2;
        }
        if (this.operation == "x" || this.operation == "*"){
            result = number1 * number2;
        }
        if (this.operation == "/"){
            result = number1/number2;
        }*/
        return result; 
    }   
}