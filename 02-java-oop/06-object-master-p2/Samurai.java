public class Samurai extends Human {
    private static int numberSam = 0; //why private? and why aren't getters and setters being used
    //why does the solution have "private static int defaultHealth = 200;" up here?
    public static int howMany() { //is this static? why didn't we write Integer?
        return Samurai.numberSam;
    }
    public Samurai(){
        this.health = 200;
        Samurai.numberSam += 1;
        //System.out.print(numberSam); why doesn't this print anything?
    }
    public void deathBlow(Human target){
        target.health = 0;
    }
    public void meditate(){
        this.health = 200;
    }
}