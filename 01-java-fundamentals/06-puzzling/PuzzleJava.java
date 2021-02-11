import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
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
    public ArrayList<Integer> RandomTen(){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i <10; i++){
            //multiple ways to do this
            //one way: int num = ThreadLocalRandom.current().nextInt(55, 101);

            /* another way:
            Random rand = new Random();
            int upperbound = 101;
            int num = rand.nextInt(upperbound); 
            myList.add(num);*/

            //another way: 
            int max = 101;
            int min = 55;
            int num = (int) (Math.random() * (max - min +1) +min);
            myList.add(num);
        }
        return myList;
    }

    //Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.
    public ArrayList<Integer> RandomDisplay(){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i <10; i++){
            int max = 101;
            int min = 55;
            int num = (int) (Math.random() * (max - min +1) +min);
            myList.add(num);
            Collections.sort(myList);
        }
        int min1 = myList.get(0);
        int max1 = myList.get(myList.size() -1);
        System.out.println(myList);
        System.out.println("The max is: " +max1);
        System.out.println("The min is " +min1);
        return myList;
    }

    //Create a random string that is 5 characters long.
    public void RanSdo(){
        Random alphList = new Random();
        ArrayList<Character> rando = new ArrayList<Character>();
        char [] Five = new char [5];
        for (char ch = 'A'; ch <= 'Z'; ++ch){
            rando.add(ch);
            Collections.shuffle(rando);
        }
        for (int i =0; i <5; i++){
            int random = alphList.nextInt(26);
            Five[i] = (rando.get(random));
        }
        System.out.println(Five);
    }

        //Create a random array that is 5 characters long.
        public void RandoS(){
            Random alphList2 = new Random();
            ArrayList<Character> rando2 = new ArrayList<Character>();
            ArrayList<Character> Five2 = new ArrayList<Character>();
            for (char ch = 'A'; ch <= 'Z'; ++ch){
                rando2.add(ch);
                Collections.shuffle(rando2);
            }
            for (int i =0; i <5; i++){
                int random2 = alphList2.nextInt(26);
                Five2.add(rando2.get(random2));
            }
            System.out.println(Five2);
        }

    //Generate an array with 10 random strings that are each 5 characters long
    public void RandoS105(){
        //generate strings
        Random randomMethod = new Random();
        ArrayList<Character> randomListofLetters = new ArrayList<Character>();
        ArrayList<String> Arrayof10 = new ArrayList<String>();
        char [] FiveCharacterArray = new char [5];
        String str2 = new String();
        //generate arrays
        //10 string array ready to be filled
        for (int j = 0; j <=10; j++){
            Arrayof10.add(str2);
            //generate random alphabet
            for (char ch = 'A'; ch <= 'Z'; ++ch){
                randomListofLetters.add(ch);
                Collections.shuffle(randomListofLetters);
            }
            //5 character strings
            for (int i =0; i <5; i++){
                int randomNumber = randomMethod.nextInt(26);
                FiveCharacterArray[i] = (randomListofLetters.get(randomNumber));
                str2 = String.valueOf(FiveCharacterArray);
            }
        }
        System.out.println(Arrayof10);
    }
}