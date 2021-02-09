public class FizzBuzz {
    public String FizzBuzz(int number) {
        String log1 = null;
        if ((number % 3 == 0) && (number % 5 == 0)){
            log1 = "FizzBuzz";
        }
        else if (number % 3 == 0){
            log1 = "Fizz";
        }
        else if (number % 5 == 0){
            log1 = "Buzz";
        }
        else {
            log1 = Integer.toString(number);
        }
        return log1;
    }
}

/** Class solution
public class FizzBuzz {
   public static String fizzBuzz(int number) {
        if(number % 5 == 0 && number % 3 == 0)
            return "FizzBuzz";
        if(number % 5 == 0)
            return "Fizz";
        if(number % 3 == 0)
            return "Buzz";
        return Integer.toString(number);
    }
    public static void FizzBuzzTest() (WHY no "main"???){
        for(int i = 0; i < 100; i++) {
            String result = fizzBuzz(i); (WHY no "FizzBuzz result = new FizzBuzz();"??)
            String output = String.format("Number: %d :: Result: %s", i, result);
            System.out.println(output);
        }
    }
} **/