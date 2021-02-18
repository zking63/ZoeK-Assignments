public class Pokemon {
    private String name; 
    private int health = 0;
    private String type;
    static int count = 0;
    //constructor
    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
        System.out.println("Name: " + name + "\n Health: " + health + "\n Type: " + type);
    }
    //attack method
    void attackPokemon(Pokemon pokemon) {
        pokemon.health -= 10;
        System.out.println("Name of attacked: " + pokemon.name + "\n Health: " + pokemon.health + "\n Type: " + pokemon.type);
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setType(String type){
        this.type = type;
    }
    //getters
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public String getType(){
        return type;
    }
    public static int getCount(){
        return count;
    }
}