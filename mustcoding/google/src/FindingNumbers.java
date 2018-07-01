/*
https://practice.geeksforgeeks.org/problems/finding-the-numbers/0
https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 */


import java.util.HashSet;
import java.util.Set;

public class FindingNumbers {

    private static void findNumbers(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        set.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
        findNumbers(arr);
    }
}
