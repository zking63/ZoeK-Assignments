public class BatTest {
    public static void main(String[] args){
        Bat result = new Bat(500);

        result.displayEnergy();
        result.fly();
        result.eatHumans();
        result.attackTown();
        result.displayEnergy();
    }
}