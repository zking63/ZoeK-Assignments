public class PokemonTest {
    public static void main(String[] args){
        Pokemon character1 = new Pokemon("baddie", 20, "bad guy");

        Pokemon character2 = new Pokemon("goody", 20, "good guy");

        character1.attackPokemon(character2);
        System.out.println("Count: " + Pokemon.getCount());
    }
}