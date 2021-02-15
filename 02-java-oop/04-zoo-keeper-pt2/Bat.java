public class Bat extends Mammal2 {
    public Bat (int energyLevel) {
        super(energyLevel);
    }
    public void fly (){
        System.out.println("Vroom");
        energyLevel -= 50;
    }
    public void eatHumans(){
        System.out.println("less humans");
        energyLevel += 25;
    }
    public void attackTown(){
        System.out.println("AHHH");
        energyLevel -= 100;
    }
}