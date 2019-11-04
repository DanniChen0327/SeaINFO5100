package assignment7;

import java.util.Arrays;

public class SumArray {
    static long a= 0;
    /*generate array of random numbers*/
    static int[] generateRandomArray(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int a = (int)(Math.random() * 100);
            arr[i] = a;
        }
        return arr;

    }

    /*get sum of an array using 1 threads*/
    static long sum(int[] arr){
        long sum = 0;
        for(int j = 0; j< arr.length; j++){
            sum += arr[j];
        }
        return sum;
    }


    /*get sum of an array using 4 threads*/
    static class ThreadSum extends Thread{
        private int[] arr;
        public ThreadSum(int[] arr){
            this.arr = arr;
        }

        public void run(){
            a += sum(arr);
        }
    }


    public static void main(String[] args)throws Exception{
        long start = System.currentTimeMillis();
        int[] arr = new int[4000000];
        int[] arr1 = generateRandomArray(arr);
        long sum = sum(arr1);
        System.out.println("the sum of one thread is : " + sum);    //result of one thread
        long end1 = System.currentTimeMillis();
        System.out.println("total time -> " + (end1 - start));


        ThreadSum ts1 = new ThreadSum(Arrays.copyOfRange(arr1,0,1000000));   //the end will not be calculated,so the range is 0-1000000
        ThreadSum ts2 = new ThreadSum(Arrays.copyOfRange(arr1,1000000,2000000));
        ThreadSum ts3 = new ThreadSum(Arrays.copyOfRange(arr1,2000000,3000000));
        ThreadSum ts4 = new ThreadSum(Arrays.copyOfRange(arr1,3000000,4000000));
        ts1.start();
        ts1.join();
        ts2.start();
        ts2.join();
        ts3.start();
        ts3.join();
        ts4.start();
        ts4.join();
        System.out.println("the sum of four thread is : " + a);
        long end2 = System.currentTimeMillis();
        System.out.println("total time -> " + (end2 - start));

    }
}
