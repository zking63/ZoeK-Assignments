import java.util.ArrayList;

public class Portfolio {
    // ArrayList of Project objects
    ArrayList<Project> projects = new ArrayList<>();
    // Add Project object to ArrayList
    public void addProject(Project X) {
        projects.add(X);
    }
    // Sums the initialCost of Project objects in ArrayList.
    public double getPortfolioCost() {
        double cost = 0;
        for(Project X: projects){
            cost += X.getInitialCost();
        }
        return cost;
    }
    // Print elevatorPitch.
    public void showPortfolio() {
        System.out.println("PORTFOLIO PROJECTS:");
        for(Project X: projects){
            System.out.println(X.elevatorPitch());
        }
        System.out.println("PORTFOLIO COST: $"+getPortfolioCost());
    }
}