public class Samurai extends Human {
    private static int numberSam = 0;
    public static int howMany() {
        return Samurai.numberSam;
    }
    public Samurai(){
        this.health = 200;
        Samurai.numberSam += 1;
    }
    public void deathBlow(Human target){
        target.health = 0;
    }
    public void meditate(){
        this.health = 200;
    }
}