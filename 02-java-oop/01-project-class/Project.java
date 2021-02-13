
public class Project {
    private String name;
    private String description;
    private double initialCost = 0;

    //getters and setters
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double initialCost){
       this.initialCost = initialCost;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getInitialCost(){
        return initialCost;
    }
    //Overloads.
    public Project() {
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, double initialCost, String description){
        this.name = name;
        this.initialCost = initialCost;
        this.description = description;
    }
    //elevator pitch
    public String elevatorPitch(){
        return String.format("%s (%02f) %s", name, initialCost, description);
    }
}