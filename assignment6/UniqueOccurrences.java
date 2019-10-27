package assignment6;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> arrmap= new HashMap<Integer,Integer>();
        if(arr.length >=1 && arr.length <=1000){
            for(int num: arr){     //put array into hashmap, value is the times of each number.
                if(num >= -1000 && num <=1000)
                    arrmap.put(num, arrmap.getOrDefault(num,0)+1);
                else
                    return false;
            }
        }else
            return false;


        HashSet<Integer> arrset = new HashSet<Integer>();
        for(Integer num : arrmap.values()){    // put all values into hashSet
            if(arrset.contains(num))  //check whether the num has been in the hashSet
                return false;
            arrset.add(num);

        }
        return true;

    }

    public static void main(String args[]){
        UniqueOccurrences test = new UniqueOccurrences();
        int[] arr1 = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        int[] arr2 = new int[]{1,2,2,1,1,3};
        int[] arr3 = new int[]{1,2};
        System.out.println(test.uniqueOccurrences(arr1));
        System.out.println(test.uniqueOccurrences(arr2));
        System.out.println(test.uniqueOccurrences(arr3));
    }
}
