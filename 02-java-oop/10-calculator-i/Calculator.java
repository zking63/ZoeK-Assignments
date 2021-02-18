public class Calculator implements java.io.Serializable {
    private double number1;
    private double number2;
    private double result;
    private String operation;

    public void setNumber1(double number){
        number1 = number;
    }
    public void setNumber2(double number2){
        this.number2 = number2;
    }
    public void setOperation(String operation){
        this.operation = operation;
    }
    public double getNumber1(){
        return this.number1;
    }
    public double getNumber2(){
        return this.number2;
    }
    public String getOperation(){
        return this.operation;
    }

    public double getResult(){
        if (operation == "+"){
            result = number1 + number2;
        }
        if (operation == "-"){
            result = number1 - number2;
        }
        return result; 
    }   
}