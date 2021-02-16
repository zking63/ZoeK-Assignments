public class Samurai extends Human {
    Integer x = 0;
    private static int numberSam = 0; //why private? and why aren't getters and setters being used. static means you don't need getters and setters. this belongs to the class instead of the instance.
    //why does the solution have "private static int defaultHealth = 200;" up here? that is basically saying that the sam is going to have it on every sam
    public static int howMany() { //is this static? why didn't we write public Integer howMany()? : int is primitive only stores number and nothing else; integer takes up more memory, this is wrapper class 
        return Samurai.numberSam; //use Integer when you have a method that is returning string you would move the Integer.tostring; primitives can't do methods. (look up wrapper calsses)
    }
    public Samurai(){
        this.health = 200;
        numberSam += 1;
        //System.out.print(numberSam); why doesn't this print anything? you can't print out on a constructor, you need to print on testing file
    }
    public void deathBlow(Human target){
        target.health = 0; //when would you return "this" with public Samurai 
        //how does it know human. take in human obj and target encapsulates it
    }
    public void meditate(){
        this.health = 200;
    }
}