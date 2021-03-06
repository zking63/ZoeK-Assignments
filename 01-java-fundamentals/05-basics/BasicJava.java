import java.util.ArrayList;
public class BasicJava {
    //Write a method that prints all the numbers from 1 to 255.
    public ArrayList<Integer> Print255(){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=1; i < 256; i++){
            myArray.add(i);
        }
        return myArray;
        //System.out.println(myArray);
    }
    //Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far.
    public void Sum255(){
        int number = 0;
        int sum = 0;
        for (int i=0; i <256; i++){
            number = i;
            sum+=i;
            System.out.println(String.format("New number : %s Sum: %s", i, sum));
        }
    }

    //Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important.
    public void PrintX(){
        int[] myArray2 = {1,3,5,7,9,13};
        for (int i = 0; i < myArray2.length; i++){
            System.out.println(String.format("Number : %s", myArray2[i]));
        }
    }

    //Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.
    public String PrintMax(int[] myArray3){
        int max = myArray3[0];
        for (int i =0; i < myArray3.length; i++){
            if (myArray3[i] > max){
                max = myArray3[i];
            }
        }
        String max2=String.format("%d",max); 
        return max2;
    }
    //Write a method that takes an array, and prints the AVERAGE of the values in the array. For example for an array [2, 10, 3], your method should print an average of 5. Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.
    public void PrintAv(int[] myArray3){
        int sum2 = 0;
        for (int i =0; i < (myArray3.length); i++){
            sum2+= myArray3[i];
        }
        int average = sum2/(myArray3.length);
        System.out.println(average);
    }

    //Write a method that creates an ArrayList 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
    public void GetOdds(){
        ArrayList<Integer> Y = new ArrayList<Integer>();
        for (int i =1; i < 256; i+=2){
            Y.add(i);
        }
        System.out.println(Y);
    }
    //Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).
    public void GetGreater(int[] myArray3){
        int y = 1;
        int total = 0;
        for (int i = 0; i < myArray3.length; i++){
            if (myArray3[i] > y){
                total++; 
            }
        }
        System.out.println(total);
    }
    //Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].
    public void Squared(int[] myArray3){
        ArrayList<Integer> newmyArray3 = new ArrayList<Integer>();
        for (int i = 0; i <myArray3.length; i++){
            newmyArray3.add(myArray3[i] * myArray3[i]);
        }
        System.out.println(newmyArray3);
    }
    //Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].
    public void ReplaceNeg(int[] myArray3){
        ArrayList<Integer> newReplace = new ArrayList<Integer>();
        for (int i = 0; i <myArray3.length; i++){
            if (myArray3[i] >= 0){
                newReplace.add(myArray3[i]);
            }
            else {
                newReplace.add(0);
            }
        }
        System.out.println(newReplace);
    }

    //Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]
    public void MaxMinAv(int[] myArray3){
        ArrayList<Integer> values = new ArrayList<Integer>();
        int max = myArray3[0];
        int min = myArray3[0];
        int average = 0;
        int sum = 0;
        for (int i =0; i < myArray3.length; i++){
            if (myArray3[i] > max){
                max = myArray3[i];
            }
            if (myArray3[i] < min){
                min = myArray3[i];
            }
            sum+= myArray3[i];
            average = sum/myArray3.length;
        }
        values.add(max);
        values.add(min);
        values.add(average);
        System.out.println(values);
    }
    //Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.
    public int[] GetShift(int[] myArray3){
        for (int i = 1; i < myArray3.length; i++){
            myArray3[i-1] = myArray3[i];
        }
        myArray3[myArray3.length-1] = 0;
        return myArray3;
    }
}