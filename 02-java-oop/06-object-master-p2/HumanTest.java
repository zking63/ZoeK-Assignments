public class HumanTest {
    public static void main(String[] args){
        Human human = new Human();
        Human human2 = new Human();
        Wizard wizard = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();
        Samurai samurai2 = new Samurai();

        human.attack(human2);
        wizard.heal(human);
        samurai.meditate();
        samurai.deathBlow(human2);
        ninja.steal(human);
        ninja.runAway();
    }
}