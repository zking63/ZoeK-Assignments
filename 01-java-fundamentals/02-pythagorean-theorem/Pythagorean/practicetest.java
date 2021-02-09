public class practicetest {
	public static void main(String[] args) {
		practice manipulator = new practice();
		
		String str = manipulator.trimAndConcat("    Hello     ","     World    ");
		System.out.println(str); // HelloWorld 
	}
}