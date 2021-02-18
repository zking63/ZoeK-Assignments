public class AbstractPokemon implements PokemonInterface {
    Pokemon createPokemon(String name, int health, String type){
        Pokemon p= new Pokemon(name, health, type);
        return p;
    }
    public String pokemonInfo(Pokemon pokemon){
        System.out.println("Name: " + this.name + "\n Health: " + this.health + "\n Type: " + this.type);
    }
}