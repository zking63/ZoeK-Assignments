import java.util.Arrays;
import java.util.ArrayList;
public class BasicJavaTest {
    //Write a method that prints all the numbers from 1 to 255.
    public static void main(String[] args) {
        BasicJava result = new BasicJava();


        ArrayList<Integer> output = result.Print255();
        System.out.println(output);

        //Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far.
        result.Sum255();

        //Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important.
        result.PrintX();

        //Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.
        int[] myArray3 = {-1,0,1,2};
        String answer = result.PrintMax(myArray3);
        System.out.println(answer);

        //Write a method that takes an array, and prints the AVERAGE of the values in the array. For example for an array [2, 10, 3], your method should print an average of 5. Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.
        result.PrintAv(myArray3);

        //Write a method that creates an ArrayList 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
        result.GetOdds();

        //Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).
        result.GetGreater(myArray3);

        //Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].
        result.Squared(myArray3);

        //Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].
        result.ReplaceNeg(myArray3);

        //Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]
        result.MaxMinAv(myArray3);
        
        //Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.
        System.out.println(Arrays.toString(result.GetShift(myArray3)));
    }
}