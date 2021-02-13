public class Project {
    private String name;
    private String description;
    private static String defaultName = "Default Name";
    private static String defaultD = "Default Description";

    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) {this.description = description; }

    public String elevatorPitch(){
        System.out.println(name + ": " + description);
        return String.format("%s: %s", name, description);
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
        System.out.println(name + ": " + description);
    }
}