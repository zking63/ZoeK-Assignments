public class ProjectTest {
    public static void main(String[] args){
        //check
        Project project = new Project();
        Project project2 = new Project("Project 1:");
        Project project3 = new Project("Project 2:", 10, "Description.");
        Project project4 = new Project("Project 3:", 21030, "Description 2");

        /* when you remove the project overloads/getters and setters on the Project.java
        and add call the function like this:
        project.elevatorPitch("Project 3:", 21030, "Description 2");
        and have:
            Portfolio portfolio = new Portfolio();
            portfolio.addProject(project);
            portfolio.showPortfolio();
        this is the outcome:
            PORTFOLIO PROJECTS:
            Exception in thread "main" java.lang.NoSuchMethodError: 'java.lang.String Project.elevatorPitch()'
                at Portfolio.showPortfolio(Portfolio.java:22)
                at ProjectTest.main(ProjectTest.java:20)  */ 


        //portfolio
        Portfolio portfolio = new Portfolio();

        // Add projects to the portfolio
        portfolio.addProject(project);
        portfolio.addProject(project2);
        portfolio.addProject(project3);
        portfolio.addProject(project4);
        
        portfolio.showPortfolio();
    }
}