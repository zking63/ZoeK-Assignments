public class Project {
    private String name;
    private String description;
    private double initialCost = 0;
    private static String defaultName = "Default Name";
    private static String defaultD = "Default Description";

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getInitialCost() { return initialCost; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) {this.description = description; }
    public void setInitialCost() { this.initialCost = initialCost; }

    public String elevatorPitch(){
        return String.format("%s:(%f) %s", name, initialCost, description);
    }
    public Project() {
        this.name = defaultName;
        this.description = defaultD;
        System.out.println(name + ": " + description);
    }
    
    public Project(String name) {
        this.name = name;
        this.description = defaultD;
        System.out.println(name + ": " + description);
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        System.out.println(name + ": " + initialCost + ": " + description);
    }
}