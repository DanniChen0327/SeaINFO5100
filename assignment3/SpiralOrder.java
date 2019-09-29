package assignment3;

import java.util.ArrayList;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> order= new ArrayList<>();
        if(matrix[0].length ==0 || matrix.length ==0){
            int[] intoder = new int[order.size()];
            return intoder;
        }

        int xmin = 0;
        int ymin = 0;
        int xmax = matrix[0].length-1;
        int ymax = matrix.length-1;
        int i = 0;
        int j = 0;

        order.add(matrix[0][0]);

        while(true){
            while(i < xmax){
                order.add(matrix[j][++i]);
            }
            if(++ymin > ymax)
                break;

            while(j < ymax){
                order.add(matrix[++j][i]);
            }
            if(xmin > --xmax)
                break;

            while(i > xmin){
                order.add(matrix[j][--i]);
            }
            if(ymin > --ymax)
                break;

            while(j > ymin){
                order.add(matrix[--j][i]);
            }
            if(++xmin > xmax)
                break;

        }
        int[] output = new int[order.size()];
        for(int x = 0; x< order.size();x++){
            output[x] = order.get(x);
        }
        return output;
    }

    public static void main(String[] args){
        SpiralOrder test = new SpiralOrder();
        int[][] matrix = new int[][]{{ 1,2,3,4 },{5,6,7,8},{9,10,11,12}};
        int[] order = test.spiralOrder(matrix);
        for(int i = 0; i< order.length-1;i++){
            System.out.print(order[i]+",");
        }
        System.out.println(order[order.length-1]);

    }
}
