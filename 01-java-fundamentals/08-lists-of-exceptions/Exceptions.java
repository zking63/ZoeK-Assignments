import java.util.ArrayList;
public class Exceptions{
    public void Exceptions1(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i); //this doesn't work bc it is an integer here
            }
            catch (ClassCastException e){
                System.out.println("Here's the problem: " +e);
            }   
        }  
    }
}