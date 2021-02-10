import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class PuzzleJava{
    //Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
    public ArrayList<Integer> PrintSumR(){
        int[] myArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> NewmyArray = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < myArray.length; i++){
            sum+= myArray[i];
            if (myArray[i]>10){
                NewmyArray.add(myArray[i]);
            }
        }
        System.out.println(sum);
        return NewmyArray;
    }
    //Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
    public ArrayList<String> Shuffle(String[] arr){
        ArrayList<String> myNames = new ArrayList<String>();
        ArrayList<String> newNames = new ArrayList<String>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() > 5){
                newNames.add(arr[i]);
            }
            myNames.add(arr[i]);
        }
        Collections.shuffle(myNames);
        System.out.println(myNames);
        return newNames;
    }

    //Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
    public ArrayList<String> GetAlpha(String[] arr1){
        ArrayList<String> myAlph = new ArrayList<String>();
        String mesg = new String();
        for(int i = 0; i < arr1.length; i++){
            myAlph.add(arr1[i]);
        }
        Collections.shuffle(myAlph);
        if("aeiou".indexOf(myAlph.get(0)) > 0){
            mesg = " Whoa! The first letter happens to be a vowel!";
        }
        System.out.println("Last letter: " + myAlph.get(0) + mesg);
        System.out.println("First letter: " + myAlph.get(25));
        return myAlph;
    }

    //Generate and return an array with 10 random numbers between 55-100.

    //Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

    //Create a random string that is 5 characters long.

    //Generate an array with 10 random strings that are each 5 characters long
}