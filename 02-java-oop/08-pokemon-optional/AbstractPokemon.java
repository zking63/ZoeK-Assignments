public class AbstractPokemon implements PokemonInterface {
    Pokemon createPokemon(String name, int health, String type){
        return new Pokemon(name, health, type);
    }
    /*public String pokemonInfo(Pokemon pokemon){
        return String.format("name, health, type");
    }*/
}