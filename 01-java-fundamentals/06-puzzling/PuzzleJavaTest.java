import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava done = new PuzzleJava();

        //Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
        ArrayList<Integer> output = done.PrintSumR();
        System.out.println(output);

        //Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
        String[] testList = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        System.out.println(done.Shuffle(testList));

        //Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
        String[] Alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        done.GetAlpha(Alpha);

        //Generate and return an array with 10 random numbers between 55-100.
        System.out.println(done.RandomTen());

        //Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
        done.RandomDisplay();

        //Create a random string that is 5 characters long.
        done.RanSdo();

        //Create a random array that is 5 characters long.
        done.RandoS();

        //Generate an array with 10 random strings that are each 5 characters long
        done.RandoS105();
    }
}