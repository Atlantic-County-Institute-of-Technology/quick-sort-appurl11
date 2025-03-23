import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
/*  Madison Bloom
    Date Created: 3/17/25
    Last Updated: 3/22/25
    Title: Quick Sort
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many items do you want to sort? \n 1: 0 \n 2: 10 \n 3: 50");
        int choice = scan.nextInt();
        int length = 0;
        if (choice == 2) {
            length = 10;
        }
        else if(choice == 3) {
            length = 50;
        }
        else if(choice != 1) {
            System.out.println("Invalid");
            System.exit(choice);
        }
        // Asks the user how long they want the sort to be, then does it

        int[] sort = new int[length];
        Random rand = new Random();
        for (int i = 0; i < sort.length; i++) {
            sort[i] = rand.nextInt(50);
        }
        // Creates an array of random numbers, unsorted

        System.out.println("Array before the sort:" + Arrays.toString(sort));

        quickSort(sort, 0, sort.length-1);
        System.out.println("Array after the sort:" + Arrays.toString(sort));
    }

    public static void quickSort(int [] sort, int low, int high) {
        if (low < high) {
        int pivot = sort[high];
        int i = low - 1;
        // make the pivot point as the last index

        for (int j = low; j < high; j++) {
            if (sort[j] <= pivot) {
                i++;
                int temp = sort[i];
                sort[i] = sort[j];
                sort[j] = temp;
            }
        }
        // goes through every item and if an item is less than the pivot point, it swaps 

        int temp = sort[i + 1];
        sort[i + 1] = sort[high];
        sort[high] = temp;

        quickSort(sort, low, i);
        quickSort(sort, i + 2, high);
        // recursion occurs, calling the quick sort function for the sub arrays 
        }
    }
}