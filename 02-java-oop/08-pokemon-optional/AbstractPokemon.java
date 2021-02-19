public class AbstractPokemon { //create protected array list to track pokemon names //implements PokemonInterface
    Pokemon createPokemon(String name, int health, String type){
        Pokemon p= new Pokemon(name, health, type);
        return p; //add pokemon to myarraylist
    }
    public String pokemonInfo(Pokemon pokemon){
        System.out.println("Name: " + this.getName() + "\n Health: " + this.getHealth() + "\n Type: " + this.getType());//use getters cause private
    }
}